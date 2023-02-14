package github.zkpgeeker.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geo {

    private Float latitude;

    private Float longitude;

    private String city;

    private String province;
}
