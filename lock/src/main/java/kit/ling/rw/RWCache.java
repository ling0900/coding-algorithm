package kit.ling.rw;

/**
 * 这是一个读写锁的缓存接口
 * @param <K>
 * @param <V>
 */
public interface RWCache <K, V>{
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    void clear();
    int size();
}
