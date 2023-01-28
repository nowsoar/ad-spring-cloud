package github.zkpgeeker.ad.index;

/**
 * @description:
 * @author: ZKP
 * @time: 2023/1/28
 */
public interface IndexAware<K, V> {

    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}
