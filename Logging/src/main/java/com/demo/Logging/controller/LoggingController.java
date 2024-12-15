package com.demo.Logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log/v1/")
//@Slf4j
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    private LoggingSystem loggingSystem;

    @PostMapping("changeLogLevel/{loggerName}/{level}")
    public String setLogLevel(@PathVariable String loggerName, @PathVariable String level) {
        try {
            loggingSystem.setLogLevel(loggerName, LogLevel.valueOf(level.toUpperCase()));
            return "Log level for " + loggerName + " set to " + level.toUpperCase();
        } catch (IllegalArgumentException e) {
            return "Invalid log level: " + level;
        }
    }

    @GetMapping("logLevels")
    public ResponseEntity<String> printLogLevels() {
        logger.error("Error");
        logger.warn("Warn");
        logger.info("Info");
        logger.debug("Debug");
        logger.trace("Trace");

//        String myMethod = "printLogLevels";
//        Integer myPriority = 2;
//        logger.info("My current method {} is a non-static method with {} as priority.", myMethod, myPriority);


//        try {
//            throw new RuntimeException("My Exception");
//        } catch (Exception ex) {
//            logger.error("MyEx: ", ex);
//        }

        return new ResponseEntity<>("Logging Successful!", HttpStatus.OK);
    }



}
