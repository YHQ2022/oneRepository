package com.example.dao;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>, Serializable {
    public User findByUnameAndPassword(String uname,String password);
}
