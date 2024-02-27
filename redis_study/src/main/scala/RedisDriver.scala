import redis.clients.jedis.Jedis

object RedisDriver {
  def main(args: Array[String]): Unit = {
    val jedis = new Jedis("spark01",6379)
    jedis.set("university","qdu")

    val uni = jedis.get("university")
    println(uni)
    jedis.close()

  }
}
