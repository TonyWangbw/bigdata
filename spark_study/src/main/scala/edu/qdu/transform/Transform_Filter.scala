package edu.qdu.transform

import org.apache.spark.{SparkConf, SparkContext}

object Transform_Filter {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("filter").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(1 to 10)
    val filteredRdd = rdd.filter(filterEven)
    filteredRdd.foreach(println)
    sc.stop()

  }//odd
  def filterEven(num:Int):Boolean={
    num%2==0
  }

}
