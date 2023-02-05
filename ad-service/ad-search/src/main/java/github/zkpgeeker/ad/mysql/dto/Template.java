package github.zkpgeeker.ad.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {

    private String database;

    private List<JsonTable> tableList;
}
