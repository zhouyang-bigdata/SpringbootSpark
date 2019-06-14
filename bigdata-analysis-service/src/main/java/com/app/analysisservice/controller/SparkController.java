/**
 * @ClassName SparkController
 * @Description TODO
 * @Author zy
 * @Date 2019/6/5 7:49
 * @Version 1.0
 **/
package com.app.analysisservice.controller;

import com.app.analysisservice.service.SparkService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/*
 * @Author zhouyang
 * @Description //TODO
 * @Date 7:51 2019/6/5
 * @Param
 * @return
 **/
@RestController
@RequestMapping("v1/private/commom/")
@Slf4j
public class SparkController {

    @Autowired
    private SparkService sparkService;

    @ApiOperation(value = "启动spark任务", notes = "")
    @ApiImplicitParams({

    })
    @ApiResponse(code = 200, message = "", response = String.class)
    @GetMapping("startSparkJob")
    public String sparkSubmit(HttpServletRequest request, HttpServletResponse response) {
        sparkService.sparkSubmit();

        return "ok";
    }

}
