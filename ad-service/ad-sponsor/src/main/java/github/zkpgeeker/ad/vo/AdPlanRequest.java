package github.zkpgeeker.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @description:创建和更新AdPlan时用的Request
 * @author: ZKP
 * @time: 2023/1/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanRequest {

    private Long id;

    private Long userId;

    private String planName;

    private String startDate;

    private String endDate;

    public boolean createValidate() {
        return userId != null
                && ! StringUtils.isEmpty(planName)
                && ! StringUtils.isEmpty(startDate)
                && ! StringUtils.isEmpty(endDate);
    }

    public boolean updateValid() {
        return id != null && userId != null;
    }

    public boolean deleteValidate() {
        return id != null && userId != null;
    }
}
