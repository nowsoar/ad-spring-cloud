package github.zkpgeeker.ad.controller;

import com.alibaba.fastjson.JSON;
import github.zkpgeeker.ad.entity.AdPlan;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.service.AdPlanService;
import github.zkpgeeker.ad.vo.AdPlanGetRequest;
import github.zkpgeeker.ad.vo.AdPlanRequest;
import github.zkpgeeker.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
@Slf4j
@RestController
public class AdPlanOpController {

    private final AdPlanService adPlanService;

    public AdPlanOpController(AdPlanService adPlanService) {
        this.adPlanService = adPlanService;
    }

    @PostMapping("/create/adPlan")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    public List<AdPlan> getAdPlanByIds(@RequestBody AdPlanGetRequest request) throws AdException{
        log.info("ad-sponsor: getAdByIds -> {}", JSON.toJSONString(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PostMapping("/update/adPlan")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}", JSON.toJSONString(request));
    }
}
