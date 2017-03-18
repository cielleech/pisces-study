package org.tyrant.study.main

import java.util.regex.Pattern

object RegexUtils {
  def main(args: Array[String]): Unit = {
    val pattern = Pattern.compile("1234.*")

    val matcher = pattern.matcher("12341324")
    
    if (matcher.find()) {
      val txt = matcher.group(1)
      
      val pattern2 = Pattern.compile(regex)
    }
    if (matcher.matches()) {
      println("true")
    }
  }
  
  private val regex = """<table.*?><thead>.*?母基.*?净值.*?</thead>(.*?)</table>"""
}