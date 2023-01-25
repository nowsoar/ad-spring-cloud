package github.zkpgeeker.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItResponse {

    private List<Long> ids;
}
