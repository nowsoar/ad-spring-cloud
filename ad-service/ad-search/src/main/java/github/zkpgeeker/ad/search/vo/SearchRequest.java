package github.zkpgeeker.ad.search.vo;

import github.zkpgeeker.ad.search.vo.feature.DistrictFeature;
import github.zkpgeeker.ad.search.vo.feature.FeatureRelation;
import github.zkpgeeker.ad.search.vo.feature.ItFeature;
import github.zkpgeeker.ad.search.vo.feature.KeywordFeature;
import github.zkpgeeker.ad.search.vo.media.AdSlot;
import github.zkpgeeker.ad.search.vo.media.App;
import github.zkpgeeker.ad.search.vo.media.Device;
import github.zkpgeeker.ad.search.vo.media.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    private String mediaId;

    private RequestInfo requestInfo;

    private FeatureInfo featureInfo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestInfo {

        private String requestId;

        private List<AdSlot> adSlots;

        private App app;

        private Geo geo;

        private Device device;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;

        private ItFeature itFeature;

        private DistrictFeature districtFeature;

        private FeatureRelation relation = FeatureRelation.AND;

    }
}
