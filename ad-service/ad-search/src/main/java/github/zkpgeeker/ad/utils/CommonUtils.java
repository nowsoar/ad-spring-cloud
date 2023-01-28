package github.zkpgeeker.ad.utils;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/28
 */
public class CommonUtils {

    public static <K, V> V getOrCreate(K key, Map<K, V> map,
                                       Supplier<V> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }
}
