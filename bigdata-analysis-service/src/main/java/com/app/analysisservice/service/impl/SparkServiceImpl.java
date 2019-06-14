/**
 * @ClassName SparkServiceImpl
 * @Description TODO
 * @Author zy
 * @Date 2019/6/6 7:59
 * @Version 1.0
 **/
package com.app.analysisservice.service.impl;

import com.app.analysisservice.service.SparkService;
import com.sparkoffline.submitjob.SubmitJobToSpark;
import org.springframework.stereotype.Service;

@Service
public class SparkServiceImpl implements SparkService {
    /*
     * @Author zhouyang
     * @Description //TODO
     * @Date 8:00 2019/6/6
     * @Param []
     * @return void
     **/
    public void sparkSubmit(){
        SubmitJobToSpark.submitJob();
    }
}
