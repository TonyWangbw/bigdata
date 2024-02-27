package edu.qdu.transform

import org.apache.spark.{SparkConf, SparkContext}

object Transform_Map {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("map").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(1 to 10)
    //val mapRdd = rdd.map(addOne)
    //val mapRdd = rdd.map(x=>x+1)//   匿名函数
    val mapRdd = rdd.map(_+1)
    rdd.foreach(println)
    println("---------------")
    mapRdd.foreach(println)
    sc.stop()

  }
  def addOne(num:Int):Int={
    num+1
  }

}
