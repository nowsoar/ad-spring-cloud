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
public class Device {

    private String deviceId;

    private String mac;

    private String ip;

    //机型编码
    private String model;

    //分辨率尺寸
    private String displaySize;

    //屏幕尺寸
    private String screenSize;

    //设备序列号
    private String serialName;
}
