package edu.qdu.action

import org.apache.spark.{SparkConf, SparkContext}

import java.sql.DriverManager

object Action_SaveToMysql {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[3]").setAppName("save")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("input/person.txt").map(line=>{
      val arr = line.split(",")
      Person(arr(0).toInt,arr(1),arr(2),arr(3),arr(4).toInt)
    })
    val filtedRdd = rdd.filter(_.age>22)
    Class.forName("com.mysql.jdbc.Driver")
    val url = "jdbc:mysql://spark01:3306/qdu?useSSL=false"
    filtedRdd.foreachPartition(items=>{
      val conn = DriverManager.getConnection(url,"root","123456")
      val insert = "insert into person values(?,?,?,?,?)"
      val psmt = conn.prepareStatement(insert)
      items.foreach(p=>{
        psmt.setInt(1,p.pid)
        psmt.setString(2,p.pname)
        psmt.setString(3,p.phone)
        psmt.setString(4,p.addr)
        psmt.setInt(5,p.age)
        psmt.addBatch()
      })
      psmt.executeBatch()
      psmt.close()
      conn.close()

    })

    sc.stop()
  }
}

case class Person(val pid:Int,val pname:String, val phone:String,
                  val addr:String,val age:Int)