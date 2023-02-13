package github.zkpgeeker.ad.search.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestInfo {

    }

    public static class FeatureInfo {

    }
}
