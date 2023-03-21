package com.example.postgre.postgre.controller;

import com.example.postgre.postgre.model.Test;
import com.example.postgre.postgre.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/withoutdb")
    public ResponseEntity<String> testWithoutDB() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    // Map(key, value)
    // Map(api -> TestController )
//             Map(withoutdb -> testWithoutDB)
//             Map(/test/{name}, -> getTestByName)

    // After first test example we will discuss below
    @Autowired
    private TestService testService;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test/{name}")
    public ResponseEntity<List<Test>> getTestByName(@PathVariable("name") String name) {

        logger.info(String.format("Got the request with name %s", name));
        List<Test> tests = testService.findByName(name);
        logger.info(String.format("Going to return the response with %s", tests));
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }
}
