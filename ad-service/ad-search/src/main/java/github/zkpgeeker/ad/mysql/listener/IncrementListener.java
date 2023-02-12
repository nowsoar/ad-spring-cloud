package github.zkpgeeker.ad.mysql.listener;

import com.github.shyiko.mysql.binlog.event.EventType;
import github.zkpgeeker.ad.mysql.constant.Constant;
import github.zkpgeeker.ad.mysql.constant.OpType;
import github.zkpgeeker.ad.mysql.dto.BinlogRowData;
import github.zkpgeeker.ad.mysql.dto.MySqlRowData;
import github.zkpgeeker.ad.mysql.dto.TableTemplate;
import github.zkpgeeker.ad.sender.ISender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/5
 */
@Slf4j
@Component
public class IncrementListener implements Ilistener {

    @Resource(name = "")
    private ISender sender;

    private final AggregationListener aggregationListener;

    public IncrementListener(AggregationListener aggregationListener) {
        this.aggregationListener = aggregationListener;
    }

    @Override
    @PostConstruct
    public void register() {
        log.info("IncrementListener register db and table info");
        Constant.table2Db.forEach((k, v) ->
                aggregationListener.register(v, k, this));
    }

    @Override
    public void onEvent(BinlogRowData eventData) {
        TableTemplate table = eventData.getTable();
        EventType eventType = eventData.getEventType();
        MySqlRowData rowData = new MySqlRowData();
        rowData.setTableName(table.getTableName());
        rowData.setLevel(table.getLevel());
        OpType opType = OpType.to(eventType);
        rowData.setOpType(opType);
        List<String> filedList = table.getOpTypeFieldSetMap().get(opType);
        if (null == filedList) {
            log.warn("{} not supported for  {}", opType, table.getTableName());
            return;
        }
        for (Map<String, String> afterMap : eventData.getAfter()) {
            Map<String, String> _afterMap = new HashMap<>();
            for (Map.Entry<String, String> entry : afterMap.entrySet()) {
                String colName = entry.getKey();
                String colValue = entry.getValue();
                _afterMap.put(colName, colValue);
            }
            rowData.getFieldValueMap().add(_afterMap);
        }
    }
}
