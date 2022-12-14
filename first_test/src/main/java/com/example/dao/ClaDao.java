package com.example.dao;


import com.example.entity.Cla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ClaDao extends JpaRepository<Cla,Integer>,JpaSpecificationExecutor<Cla>, Serializable {
}
