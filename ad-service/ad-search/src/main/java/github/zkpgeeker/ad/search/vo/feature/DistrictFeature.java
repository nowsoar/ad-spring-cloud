package github.zkpgeeker.ad.search.vo.feature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictFeature {

    private List<ProvinceAndCity> districts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProvinceAndCity {

        private String province;

        private String city;

    }
}
