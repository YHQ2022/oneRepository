package com.example.entity;


import lombok.Data;

import javax.persistence.*;
import com.example.entity.Cla;
@Entity
@Data
public class Stu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String sname;
    private String sex;
    @ManyToOne
    @JoinColumn(name = "cid")
    private Cla cla;

}
