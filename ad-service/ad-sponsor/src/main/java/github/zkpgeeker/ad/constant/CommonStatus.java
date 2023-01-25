package github.zkpgeeker.ad.constant;

import lombok.Getter;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/24
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
