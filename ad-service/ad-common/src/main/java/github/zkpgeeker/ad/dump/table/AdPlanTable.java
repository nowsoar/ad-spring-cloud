package github.zkpgeeker.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanTable {

    private Long id;

    private Long userId;

    private Integer planStatus;

    private Date startDate;

    private Date endData;
}
