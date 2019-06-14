/**
 * @ClassName SubmitJobToSpark
 * @Description TODO
 * @Author zy
 * @Date 2019/6/5 7:51
 * @Version 1.0
 **/
package com.sparkoffline.submitjob;

import org.apache.spark.deploy.SparkSubmit;

/*
 * @Author zhouyang
 * @Description //TODO
 * @Date 7:52 2019/6/5
 * @Param
 * @return
 **/
public class SubmitJobToSpark {

    public static void submitJob() {
        String[] args = new String[] { "--master", "spark://192.168.66.10:7077", "--name", "test java submit job to spark", "--class", "com.sparkoffline.examples.WordCount", "/home/taima/test-program/sparkoffline_jar/sparkoffline.jar", "file///home/taima/test-data/wordcount.txt" };
        SparkSubmit.main(args);
    }
}