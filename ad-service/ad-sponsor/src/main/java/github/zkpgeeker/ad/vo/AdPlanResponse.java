package github.zkpgeeker.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:创建和更新AdPlan时用的Request
 * @author: ZKP
 * @time: 2023/1/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanResponse {

    private Long id;

    private String planName;
}
