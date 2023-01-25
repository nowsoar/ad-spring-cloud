package github.zkpgeeker.ad.service.impl;

import github.zkpgeeker.ad.dao.AdCreativeRepository;
import github.zkpgeeker.ad.entity.AdCreative;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.service.AdCreativeService;
import github.zkpgeeker.ad.vo.CreativeRequest;
import github.zkpgeeker.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
@Service
public class AdCreativeServiceImpl implements AdCreativeService {

    private final AdCreativeRepository creativeRepository;

    public AdCreativeServiceImpl(AdCreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }


    @Override
    public CreativeResponse createCreative(CreativeRequest request) throws AdException {
        AdCreative creative = creativeRepository.save(
                request.convertToEntity()
        );
        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
