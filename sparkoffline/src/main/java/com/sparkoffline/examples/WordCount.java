/**
 * @ClassName WordCount
 * @Description TODO
 * @Author zy
 * @Date 2019/6/5 7:54
 * @Version 1.0
 **/
package com.sparkoffline.examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.SPACE;

/*
 * @Author zhouyang
 * @Description //TODO 
 * @Date 7:58 2019/6/5
 * @Param 
 * @return  
 **/
public class WordCount {
    public static void main(String[] args) {

        String testFilePath = "file:///home/taima/test-data/wordcount.txt";
        //String testFilePath = "F:\\sparktest\\sample.txt";
        String jarParentPath = "/home/taima/test-program/sparkoffline_jar/";
        SparkConf conf = new SparkConf().setAppName("JavaWordCount").setMaster("local[2]");
        String[] jars = getFiles(jarParentPath);
        conf.setJars(jars);
        JavaSparkContext jsc = new JavaSparkContext(conf);

        JavaRDD<String> lines = jsc.textFile(testFilePath,1);
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Iterator<String> call(String s) {
                return Arrays.asList(SPACE.split(s)).iterator();
            }
        });

        JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {

            private static final long serialVersionUID = 1L;

            //@Override
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }
        });

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }

        //停止sc
        jsc.stop();

    }

    /*
     * @Author zhouyang
     * @Description //TODO
     * @Date 12:38 2019/6/7
     * @Param [path, filePathList]
     * @return java.lang.String[]
     **/
    public static String[] getFiles(String path) {

        List<String> filePathList = new ArrayList<>();
        File file = new File(path);

        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    System.out.println("目录：" + files[i].getPath());
                    getFiles(files[i].getPath());
                } else {
                    System.out.println("文件：" + files[i].getPath());
                    //
                    filePathList.add(files[i].getPath());
                }

            }
        } else {
            System.out.println("文件：" + file.getPath());
            //
            filePathList.add(file.getPath());
        }
        String[] filePathArr = filePathList.toArray(new String[filePathList.size()]);
        return filePathArr;

    }
}