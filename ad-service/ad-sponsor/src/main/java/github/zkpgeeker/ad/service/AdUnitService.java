package github.zkpgeeker.ad.service;

import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.vo.*;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
public interface AdUnitService {

    AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;


}
