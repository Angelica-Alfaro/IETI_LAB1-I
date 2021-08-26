package edu.eci.users.services.impl;

import edu.eci.users.data.User;
import edu.eci.users.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private static final ConcurrentHashMap<String,User> users = new ConcurrentHashMap<>();
    private AtomicInteger userId = new AtomicInteger(0);

    @Override
    public User create(User user) {
        Integer id = userId.getAndIncrement();
        String idStr = id.toString();
        user.setId(id.toString());
        user.setCreatedAt(LocalDate.now());
        users.put(idStr, user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> all() {
        List<User> allUsers = new ArrayList<>();
        for (String idKey : users.keySet()){
            allUsers.add(users.get(idKey));
        }
        return allUsers;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        user.setId(userId);
        user.setCreatedAt(findById(userId).getCreatedAt());
        return users.put(userId,user);
    }
}

