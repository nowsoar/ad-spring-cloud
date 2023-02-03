package github.zkpgeeker.ad.handler;

import com.alibaba.fastjson.JSON;
import github.zkpgeeker.ad.dump.table.AdCreativeTable;
import github.zkpgeeker.ad.dump.table.AdCreativeUnitTable;
import github.zkpgeeker.ad.dump.table.AdPlanTable;
import github.zkpgeeker.ad.dump.table.AdUnitTable;
import github.zkpgeeker.ad.index.DataTable;
import github.zkpgeeker.ad.index.IndexAware;
import github.zkpgeeker.ad.index.adplan.AdPlanIndex;
import github.zkpgeeker.ad.index.adplan.AdPlanObject;
import github.zkpgeeker.ad.index.adunit.AdUnitIndex;
import github.zkpgeeker.ad.index.adunit.AdUnitObject;
import github.zkpgeeker.ad.index.creative.CreativeIndex;
import github.zkpgeeker.ad.index.creative.CreativeObject;
import github.zkpgeeker.ad.index.creativeunit.CreativeUnitIndex;
import github.zkpgeeker.ad.index.creativeunit.CreativeUnitObject;
import github.zkpgeeker.ad.mysql.constant.OpType;
import github.zkpgeeker.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/31
 */
@Slf4j
public class AdLevelDataHandler {

    public static void handleLevel2(AdPlanTable planTable, OpType type) {
        AdPlanObject planObject = new AdPlanObject(
                planTable.getId(),
                planTable.getUserId(),
                planTable.getPlanStatus(),
                planTable.getStartDate(),
                planTable.getEndData()
        );
        handleBinlogEvent(
                DataTable.of(AdPlanIndex.class),
                planObject.getPlanId(),
                planObject,
                type
        );
    }

    public static void handleLevel2(AdCreativeTable creativeTable, OpType type) {
        CreativeObject creativeObject = new CreativeObject(
                creativeTable.getAdId(),
                creativeTable.getName(),
                creativeTable.getType(),
                creativeTable.getMaterialType(),
                creativeTable.getHeight(),
                creativeTable.getWidth(),
                creativeTable.getAuditStatus(),
                creativeTable.getAdUrl()
        );
        handleBinlogEvent(
                DataTable.of(CreativeIndex.class),
                creativeObject.getAdId(),
                creativeObject,
                type
        );
    }

    public static void handleLevel3(AdUnitTable unitTable, OpType type) {
        AdPlanObject adPlanObject = DataTable.of(AdPlanIndex.class)
                .get(unitTable.getPlanId());
        if (null == adPlanObject) {
            log.error("handleLevel3 found AdPlanObject error: {}",
                    unitTable.getPlanId());
            return;
        }
        AdUnitObject adUnitObject = new AdUnitObject(
                unitTable.getUnitId(),
                unitTable.getUnitStatus(),
                unitTable.getPositionType(),
                unitTable.getPlanId(),
                adPlanObject
        );
        handleBinlogEvent(
                DataTable.of(AdUnitIndex.class),
                unitTable.getUnitId(),
                adUnitObject,
                type
        );
    }

    public static void handleLevel3(AdCreativeUnitTable creativeUnitTable, OpType type) {
        if (type == OpType.UPDATE) {
            log.error("CreativeUnitIndex does not support update");
            return;
        }
        AdUnitObject unitObject = DataTable.of(AdUnitIndex.class)
                .get(creativeUnitTable.getUintID());
        CreativeObject creativeObject = DataTable.of(CreativeIndex.class)
                .get(creativeUnitTable.getAdId());
        if (null == unitObject || null == creativeObject) {
            log.error("AdUnitCreativeObject Index Error: {}",
                    JSON.toJSONString(creativeUnitTable));
            return;
        }
        CreativeUnitObject creativeUnitObject = new CreativeUnitObject(
                creativeUnitTable.getAdId(),
                creativeUnitTable.getUintID()
        );
        handleBinlogEvent(DataTable.of(CreativeUnitIndex.class),
                CommonUtils.stringConcat(
                        creativeObject.getAdId().toString(),
                        unitObject.getUnitId().toString()
                ),
                creativeUnitObject,
                type
        );
    }

    private static <K, V> void handleBinlogEvent(IndexAware<K, V> index,
                                                 K key,
                                                 V value,
                                                 OpType type) {
        switch (type) {
            case ADD:
                index.add(key, value);
                break;
            case UPDATE:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                break;
        }
    }
}
