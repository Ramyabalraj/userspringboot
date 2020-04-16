  
package com.kgisl.demo.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.demo.entity.User;
import com.kgisl.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User create(User user) {
   
String email=user.getUserEmail();
 if((email=="")){

        }
        else{
        Boolean e=  userRepository.existsByuserEmail(email);
       if(e == false){
      
      return userRepository.save(user);
        }
        }
     System.out.println("Already exists...");
    return null;
    
     }
 
 public Boolean login(String email,String name){
     System.out.println(userRepository.existsByuserEmailAnduserName(email,name));
     if(userRepository.existsByuserEmailAnduserName(email,name)){
         return true;
     }
     
     return false;
 }
 

    public List<User> get() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(Long id,User user) {
        String email=user.getUserEmail();
        if(email=="" && user.getUserName() ==""){

        }
        else{
         Boolean e=  userRepository.existsByuserEmail(email);
         if(e == false){
         User t = userRepository.getOne(id);
         t.setUserName(user.getUserName());
         t.setUserEmail(user.getUserEmail());
        return userRepository.save(t);
        }
            }
  
        System.out.println("Already exists...");
        return null;
       
       
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}