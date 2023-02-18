package github.zkpgeeker.ad.search.impl;

import github.zkpgeeker.ad.index.DataTable;
import github.zkpgeeker.ad.index.adunit.AdUnitIndex;
import github.zkpgeeker.ad.search.ISearch;
import github.zkpgeeker.ad.search.vo.SearchRequest;
import github.zkpgeeker.ad.search.vo.SearchResponse;
import github.zkpgeeker.ad.search.vo.feature.DistrictFeature;
import github.zkpgeeker.ad.search.vo.feature.FeatureRelation;
import github.zkpgeeker.ad.search.vo.feature.ItFeature;
import github.zkpgeeker.ad.search.vo.feature.KeywordFeature;
import github.zkpgeeker.ad.search.vo.media.AdSlot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/18
 */
@Slf4j
@Component
public class SearchImpl implements ISearch {
    @Override
    public SearchResponse fetchAds(SearchRequest request) {
        List<AdSlot> adSlots = request.getRequestInfo().getAdSlots();
        KeywordFeature keywordFeature = request.getFeatureInfo().getKeywordFeature();
        DistrictFeature districtFeature = request.getFeatureInfo().getDistrictFeature();
        ItFeature itFeature = request.getFeatureInfo().getItFeature();
        FeatureRelation relation = request.getFeatureInfo().getRelation();
        SearchResponse response = new SearchResponse();
        Map<String, List<SearchResponse.Creative>> adSlot2Ads =
                response.getAdSlot2Ads();
        for (AdSlot adSlot :adSlots) {
            Set<Long> targetUnitIdSet;
            Set<Long> adUnitIdSet = DataTable.of(
                    AdUnitIndex.class
            ).match(adSlot.getPositionType());
        }
        return null;
    }
}
