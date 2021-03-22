package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 仓储
 */
@Repository
public class UserRepository {
    private final static AtomicInteger idGenerator = new AtomicInteger();

    private ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

    /**
     * 保存用户对象
     * @param user
     * @return
     */
    public boolean save(User user) {
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }
}
