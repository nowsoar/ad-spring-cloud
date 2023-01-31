package github.zkpgeeker.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitKeywordTable {

    private Long unitId;

    private String keyword;
}
