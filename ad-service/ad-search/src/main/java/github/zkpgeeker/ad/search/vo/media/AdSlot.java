package github.zkpgeeker.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:广告位信息
 * @author: ZKP
 * @time: 2023/2/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdSlot {

    private String adSlotCode;

    private Integer positionType;

    private Integer width;

    private Integer height;

    //广告物料类型：图片，视频
    private List<Integer> type;

    //最低出价
    private Integer minCpm;
}
