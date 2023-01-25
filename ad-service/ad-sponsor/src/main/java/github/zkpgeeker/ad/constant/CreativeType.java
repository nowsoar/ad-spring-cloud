package github.zkpgeeker.ad.constant;

import lombok.Getter;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
@Getter
public enum CreativeType {

    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本");

    private Integer type;
    private String desc;

    CreativeType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
