package com.analysis.lottery.service;

import com.analysis.lottery.pojo.PUser;
import com.analysis.lottery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(PUser user){
        user.setId(String.valueOf(System.currentTimeMillis()));
        user.setRegisterDate(new Date());
        userRepository.save(user);
    }

    public PUser login(String name,String password) throws Exception {
        PUser user = userRepository.findPUserByNameAndPassword(name,password);
        if(user == null){
            throw new Exception("找不到用户");
        }
        return user;
    }

    public PUser findPUserById(String id){
        return userRepository.findPUserById(id);
    }
    public void saveEdit(PUser user){
        userRepository.save(user);
    }

}
