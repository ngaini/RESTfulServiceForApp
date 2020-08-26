package com.in28minutes.rest.webservices.restfulwebservices.user.dao;

import com.in28minutes.rest.webservices.restfulwebservices.user.entity.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static{
        users.add(new User(1, "Arsene Wenger", new Date()));
        users.add(new User(2, "Theo Walcott", new Date()));
        users.add(new User(3, "Aaron Ramsey", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(!(user.getId() > 0)){
            user.setId(users.size()+1);
        }
        users.add(user);
        return user;
    }

    public User findUser(int id){
        for(User user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
