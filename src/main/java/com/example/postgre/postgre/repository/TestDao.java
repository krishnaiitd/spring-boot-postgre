package com.example.postgre.postgre.repository;

import com.example.postgre.postgre.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao extends JpaRepository<Test, Long> {

//    Test findById(long id);

    List<Test> findAll();

    List<Test> findByName(String name);

}
