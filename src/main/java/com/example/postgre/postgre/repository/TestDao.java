package com.example.postgre.postgre.repository;

import com.example.postgre.postgre.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao extends JpaRepository<Test, Long> {

//    Test findById(long id);

    List<Test> findAll();// select * from test

    List<Test> findByName(String a); // select * from test where name = ?

    // Find by id and Name
//    Option<Test> findByIdAndName(long id, String name);

//    List<Test> findByFirstname(String firstName);// select * from test where firstname = ?

}
