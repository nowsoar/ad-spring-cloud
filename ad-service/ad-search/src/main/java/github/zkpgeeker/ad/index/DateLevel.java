package github.zkpgeeker.ad.index;

import lombok.Getter;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/12
 */
@Getter
public enum DateLevel {

    LEVEL2("2", "level 2"),
    LEVEL3("3", "level 3"),
    LEVEL4("4", "level 4");

    private String level;

    private String desc;

    DateLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
