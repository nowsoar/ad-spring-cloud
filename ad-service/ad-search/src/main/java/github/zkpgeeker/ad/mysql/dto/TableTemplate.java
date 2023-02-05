package github.zkpgeeker.ad.mysql.dto;

import github.zkpgeeker.ad.mysql.constant.OpType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableTemplate {

    private String tableName;

    private String level;

    private Map<OpType, List<String>> opTypeFieldSetMap = new HashMap<>();

    /**
     * 字段索引到字段名的映射
     */
    private Map<Integer, String> posMap = new HashMap<>();

}
