package github.zkpgeeker.ad.service;

import github.zkpgeeker.ad.entity.AdPlan;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.vo.AdPlanGetRequest;
import github.zkpgeeker.ad.vo.AdPlanRequest;
import github.zkpgeeker.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
public interface AdPlanService {

    /**
     * 创建推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;

}
