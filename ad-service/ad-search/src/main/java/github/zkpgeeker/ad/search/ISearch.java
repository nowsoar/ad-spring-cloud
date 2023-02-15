package github.zkpgeeker.ad.search;

import github.zkpgeeker.ad.search.vo.SearchRequest;
import github.zkpgeeker.ad.search.vo.SearchResponse;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/13
 */
public interface ISearch {

    SearchResponse fetchAds(SearchRequest request);
}
