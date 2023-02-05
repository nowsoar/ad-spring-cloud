package github.zkpgeeker.ad.mysql.listener;

import github.zkpgeeker.ad.mysql.dto.BinlogRowData;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/2/5
 */
public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
