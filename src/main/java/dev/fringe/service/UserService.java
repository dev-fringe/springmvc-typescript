package dev.fringe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.fringe.mapper.UserMapper;
import dev.fringe.model.User;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public class UserService  {

   @Autowired
   private UserMapper userMapper;

   public void save(User user) {
	   userMapper.insert(user);
   }

   public List<User> list() {
      return userMapper.selectList(null);
   }

}
