package github.zkpgeeker.ad.handler;

import github.zkpgeeker.ad.index.IndexAware;
import github.zkpgeeker.ad.mysql.constant.OpType;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/31
 */
@Slf4j
public class AdLevelDataHandler {

    private static <K, V> void handleBinlogEvent(IndexAware<K, V> index,
                                                 K key,
                                                 V value,
                                                 OpType type) {
        switch (type) {
            case ADD:
                index.add(key, value);
                break;
            case UPDATE:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                break;
        }
    }
}
