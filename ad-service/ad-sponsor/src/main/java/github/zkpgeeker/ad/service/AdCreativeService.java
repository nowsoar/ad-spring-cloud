package github.zkpgeeker.ad.service;

import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.vo.CreativeRequest;
import github.zkpgeeker.ad.vo.CreativeResponse;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
public interface AdCreativeService {

    CreativeResponse createCreative(CreativeRequest request) throws AdException;
}
