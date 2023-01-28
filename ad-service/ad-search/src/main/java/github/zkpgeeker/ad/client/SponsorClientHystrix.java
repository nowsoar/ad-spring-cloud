package github.zkpgeeker.ad.client;

import github.zkpgeeker.ad.client.vo.AdPlan;
import github.zkpgeeker.ad.client.vo.AdPlanGetRequest;
import github.zkpgeeker.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/28
 */
@Component
public class SponsorClientHystrix implements SponsorClient{

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor-error");
    }
}
