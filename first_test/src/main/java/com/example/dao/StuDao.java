package com.example.dao;

import com.example.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StuDao extends JpaRepository<Stu,Integer>, JpaSpecificationExecutor<Stu>, Serializable {
}
