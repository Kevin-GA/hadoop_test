package com.ydjt.stream.until

import com.typesafe.config.ConfigFactory

/**
 * 这个是获取resources里面.conf文件的配置信息的类
 */
class GlobalConfigUtils {

  private def conf = ConfigFactory.load()
  def  heartColumnFamily = "MM"
  val getProp: String => String = (argv:String) => conf.getString(argv)

  //加载配置
//  val config = ConfigFactory.load()
  //获取属性
  //    val bootstrapServers = config.getString(runEnv+".bootstrap.servers")
}
//把类变为单例类(静态类static)就可以不用new就可以直接.方法进行使用
object GlobalConfigUtils extends GlobalConfigUtils
