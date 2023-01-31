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
public class AdUnitTable {

    private Long unitId;

    private Integer unitStatus;

    private Integer positionType;

    private Long planId;
}
