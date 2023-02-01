package github.zkpgeeker.ad.handler;

import github.zkpgeeker.ad.dump.table.AdCreativeTable;
import github.zkpgeeker.ad.dump.table.AdPlanTable;
import github.zkpgeeker.ad.index.DataTable;
import github.zkpgeeker.ad.index.IndexAware;
import github.zkpgeeker.ad.index.adplan.AdPlanIndex;
import github.zkpgeeker.ad.index.adplan.AdPlanObject;
import github.zkpgeeker.ad.index.creative.CreativeIndex;
import github.zkpgeeker.ad.index.creative.CreativeObject;
import github.zkpgeeker.ad.mysql.constant.OpType;
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
