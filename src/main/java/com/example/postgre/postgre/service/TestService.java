package com.example.postgre.postgre.service;

import com.example.postgre.postgre.model.Test;
import com.example.postgre.postgre.repository.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public List<Test> findByName(String name) {
        // Some business logic like name should be made lower before query
        // Validate and throw exception if name is empty
        // etc
        return testDao.findByName(name.toLowerCase(Locale.ROOT));
    }
}
