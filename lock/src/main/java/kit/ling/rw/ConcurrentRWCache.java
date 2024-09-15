package kit.ling.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 基于ReentrantReadWriteLock实现的读写锁实现类
 * @param <K>
 * @param <V>
 */
public class ConcurrentRWCache <K, V> implements RWCache<K, V> {

    // 读写锁
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    // 存储数据的map
    private volatile Map<K, V> map = new HashMap<>();

    // 读锁
    private final Lock readLock = lock.readLock();

    // 写锁
    private final Lock writeLock = lock.writeLock();

    @Override
    public V get(K key) {
        // 定义返回数据
        V value = null;

        try {
            readLock.lock();
            value = map.get(key);
        } finally {
            readLock.unlock();
        }

        // 如果获得了数据，则返回数据，否则去数据库查询数据
        if (value != null) {
            return value;
        }
        // 去数据库查询数据
        // ...
        value = null;
        // 将数据存入map中
        try {
            writeLock.lock();
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        try {
            writeLock.lock();
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
