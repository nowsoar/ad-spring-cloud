package github.zkpgeeker.ad.controller;

import com.alibaba.fastjson.JSON;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.service.AdCreativeService;
import github.zkpgeeker.ad.vo.CreativeRequest;
import github.zkpgeeker.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
@Slf4j
@RestController
public class CreativeOpController {

    private final AdCreativeService creativeService;

    @Autowired
    public CreativeOpController(AdCreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(
            @RequestBody CreativeRequest request
    ) throws AdException {
        log.info("ad-sponsor: createCreative -> {}",
                JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
