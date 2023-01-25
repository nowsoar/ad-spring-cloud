package github.zkpgeeker.ad.service.impl;

import github.zkpgeeker.ad.constant.Constants;
import github.zkpgeeker.ad.dao.AdCreativeRepository;
import github.zkpgeeker.ad.dao.AdPlanRepository;
import github.zkpgeeker.ad.dao.AdUnitRepository;
import github.zkpgeeker.ad.dao.unit_condition.AdUnitDistrictRepository;
import github.zkpgeeker.ad.dao.unit_condition.AdUnitItRepository;
import github.zkpgeeker.ad.dao.unit_condition.AdUnitKeyWordRepository;
import github.zkpgeeker.ad.dao.unit_condition.CreativeUnitRepository;
import github.zkpgeeker.ad.entity.AdPlan;
import github.zkpgeeker.ad.entity.AdUnit;
import github.zkpgeeker.ad.entity.unit_condition.AdUnitDistrict;
import github.zkpgeeker.ad.entity.unit_condition.AdUnitInterest;
import github.zkpgeeker.ad.entity.unit_condition.AdUnitKeyWord;
import github.zkpgeeker.ad.entity.unit_condition.CreativeUnit;
import github.zkpgeeker.ad.exception.AdException;
import github.zkpgeeker.ad.service.AdUnitService;
import github.zkpgeeker.ad.utils.CommonUtils;
import github.zkpgeeker.ad.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
@Service
public class AdUnitServiceImpl implements AdUnitService {

    private final AdPlanRepository planRepository;

    private final AdUnitRepository unitRepository;

    private final AdUnitKeyWordRepository unitKeyWordRepository;

    private final AdUnitItRepository unitItRepository;

    private final AdUnitDistrictRepository unitDistrictRepository;

    private final AdCreativeRepository creativeRepository;

    private final CreativeUnitRepository creativeUnitRepository;

    public AdUnitServiceImpl(AdPlanRepository planRepository,
                             AdUnitRepository unitRepository,
                             AdUnitKeyWordRepository unitKeyWordRepository,
                             AdUnitItRepository unitItRepository,
                             AdUnitDistrictRepository unitDistrictRepository, AdCreativeRepository creativeRepository, CreativeUnitRepository creativeUnitRepository) {
        this.planRepository = planRepository;
        this.unitRepository = unitRepository;
        this.unitKeyWordRepository = unitKeyWordRepository;
        this.unitItRepository = unitItRepository;
        this.unitDistrictRepository = unitDistrictRepository;
        this.creativeRepository = creativeRepository;
        this.creativeUnitRepository = creativeUnitRepository;
    }

    @Override
    public AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException {
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        Optional<AdPlan> adPlan = planRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        AdUnit oldUnit = unitRepository.findByPlanIdAndUnitName(request.getPlanId(),
                request.getUnitName());
        if (oldUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }
        AdUnit newAdUnit = unitRepository.save(
                new AdUnit(request.getPlanId(), request.getUnitName(),
                        request.getPositionType(), request.getBudget()
                )
        );
        return new AdUnitResponse(newAdUnit.getId(), newAdUnit.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        List<Long> unitIds = request.getUnitKeywords().stream()
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());
        if (!idRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();
        List<AdUnitKeyWord> unitKeyWords = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {
            request.getUnitKeywords().forEach(i -> unitKeyWords.add(
                    new AdUnitKeyWord(i.getUnitId(), i.getKeyword())
            ));
            ids = unitKeyWordRepository.saveAll(unitKeyWords).stream()
                    .map(AdUnitKeyWord::getId).collect(Collectors.toList());
        }
        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        List<Long> unitIds = request.getUnitIts().stream().map(AdUnitItRequest.UnitIt::getUnitId)
                .collect(Collectors.toList());
        if (!idRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<AdUnitInterest> unitInterests = new ArrayList<>();
        request.getUnitIts().forEach(i -> unitInterests.add(
                new AdUnitInterest(i.getUnitId(), i.getItTag())
        ));
        List<Long> ids = unitItRepository.saveAll(unitInterests).stream()
                .map(AdUnitInterest::getId)
                .collect(Collectors.toList());
        return new AdUnitItResponse(ids);
    }

    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
            throws AdException {
        List<Long> unitIds = request.getUnitDistricts().stream()
                .map(AdUnitDistrictRequest.UnitDistrict::getUnitId)
                .collect(Collectors.toList());
        if (!idRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<AdUnitDistrict> unitDistricts = new ArrayList<>();
        request.getUnitDistricts().forEach(d -> unitDistricts.add(
                new AdUnitDistrict(d.getUnitId(), d.getProvince(), d.getCity())
        ));
        List<Long> ids = unitDistrictRepository.saveAll(unitDistricts).stream()
                .map(AdUnitDistrict::getId).collect(Collectors.toList());
        return new AdUnitDistrictResponse(ids);
    }

    @Override
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {
        List<Long> unitIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getUnitId)
                .collect(Collectors.toList());
        List<Long> creativeIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getCreativeId)
                .collect(Collectors.toList());
        if (!idRelatedUnitExist(unitIds) || !idRelatedCreativeExist(creativeIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<CreativeUnit> creativeUnits = new ArrayList<>();
        request.getUnitItems().forEach(i -> creativeUnits.add(
                new CreativeUnit(i.getCreativeId(), i.getUnitId())
        ));
        List<Long> ids = creativeUnitRepository.saveAll(creativeUnits).stream()
                .map(CreativeUnit::getId)
                .collect(Collectors.toList());
        return new CreativeUnitResponse(ids);
    }

    private boolean idRelatedUnitExist(List<Long> unitIds) {
        if (CollectionUtils.isEmpty(unitIds)) {
            return false;
        }
        return unitRepository.findAllById(unitIds).size() ==
                new HashSet<>(unitIds).size();
    }

    private boolean idRelatedCreativeExist(List<Long> creativeIds) {
        if (CollectionUtils.isEmpty(creativeIds)) {
            return false;
        }
        return creativeRepository.findAllById(creativeIds).size() ==
                new HashSet<>(creativeIds).size();
    }
}
