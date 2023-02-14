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
public class App {

    //应用编码
    private String addCode;

    private String appName;

    private String packageName;

    private String activityName;

}
