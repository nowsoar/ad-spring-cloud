package github.zkpgeeker.ad.sender;

import github.zkpgeeker.ad.mysql.dto.MySqlRowData;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/5
 */
public interface ISender {

    void send(MySqlRowData rowData);
}
