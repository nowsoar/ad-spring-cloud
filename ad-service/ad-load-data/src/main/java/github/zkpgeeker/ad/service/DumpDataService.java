package github.zkpgeeker.ad.service;

import github.zkpgeeker.ad.dao.AdCreativeRepository;
import github.zkpgeeker.ad.dao.AdPlanRepository;
import github.zkpgeeker.ad.dao.AdUnitRepository;
import github.zkpgeeker.ad.dao.unit_condition.AdUnitDistrictRepository;
import github.zkpgeeker.ad.dao.unit_condition.AdUnitItRepository;
import github.zkpgeeker.ad.dao.unit_condition.AdUnitKeyWordRepository;
import github.zkpgeeker.ad.dao.unit_condition.CreativeUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/30
 */
public class DumpDataService {

    @Autowired
    private AdPlanRepository planRepository;

    @Autowired
    private AdUnitRepository unitRepository;

    @Autowired
    private AdCreativeRepository creativeRepository;

    @Autowired
    private CreativeUnitRepository creativeUnitRepository;

    @Autowired
    private AdUnitDistrictRepository districtRepository;

    @Autowired
    private AdUnitItRepository itRepository;

    @Autowired
    private AdUnitKeyWordRepository keyWordRepository;
}
