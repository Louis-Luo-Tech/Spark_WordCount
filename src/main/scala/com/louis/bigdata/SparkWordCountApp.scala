package com.louis.bigdata

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object SparkWordCountApp {
  def main(args: Array[String]): Unit = {
//    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkWordCountApp")//local mode
//    val sc = new SparkContext(sparkConf)

    val spark = SparkSession
      .builder()
      .appName("SparkWordCountApp")
      .master("local[*]")
      .getOrCreate()
    val rdd = spark.sparkContext.textFile("file:///Users/xiangluo/Documents/GitHub/Spark_WordCount/data/input.txt")

//    rdd.collect().foreach(println)

    rdd.flatMap(_.split(",")).map(word => (word,1))
      .reduceByKey(_+_).map(x =>(x._2,x._1)).sortByKey(false)
      .map(x=>(x._2,x._1))
      .saveAsTextFile("file:///Users/xiangluo/Documents/GitHub/Spark_WordCount/out/")

    spark.close()
  }
}
