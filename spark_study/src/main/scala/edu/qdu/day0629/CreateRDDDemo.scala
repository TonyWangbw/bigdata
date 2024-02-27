package edu.qdu.day0629

import org.apache.spark.{SparkConf, SparkContext}

object CreateRDDDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("rdd").setMaster("local[5]")
    val sc = new SparkContext(conf)

    //val rdd = sc.parallelize(seq = 1 to 10,numSlices = 1)
    val rdd = sc.makeRDD(1 to 10,2)
    println(rdd.partitions.length)

    sc.stop()

  }

}
