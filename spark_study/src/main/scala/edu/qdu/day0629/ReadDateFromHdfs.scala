package edu.qdu.day0629

import org.apache.spark.{SparkConf, SparkContext}

object ReadDateFromHdfs {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("spark://spark01:7077").setAppName("work")

    val sc = new SparkContext(conf)
    val sourceRdd = sc.textFile("hdfs://spark01:9820/words.txt")
    val flatMapRdd = sourceRdd.flatMap(_.split(","))
    val mapRdd = flatMapRdd.map((_,1))
    val reduceRdd = mapRdd.reduceByKey(_+_)
    reduceRdd.foreach(println)
    sc.stop()
  }
}
