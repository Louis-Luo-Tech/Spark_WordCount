package com.louis.bigdata

import org.apache.spark.{SparkConf, SparkContext}

object SparkWordCountAppV2 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile(args(0))

//    rdd.collect().foreach(println)

    rdd.flatMap(_.split(",")).map(word => (word,1))
      .reduceByKey(_+_).map(x =>(x._2,x._1)).sortByKey(false)
      .map(x=>(x._2,x._1))
      .saveAsTextFile(args(1))

    sc.stop()
  }
}
