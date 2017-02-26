package com.vox.mobile.study.common

import java.awt.image.BufferedImage
import java.util

import com.google.zxing.common.BitMatrix
import com.google.zxing.{BarcodeFormat, EncodeHintType, MultiFormatWriter}
import org.junit.Test
import java.io.File
import javax.imageio.ImageIO
import scala.util.Failure
import scala.util.Try
import scala.util.Success

class CommonTests {
  @Test
  def pringTest(): Unit = {
    val hints = new util.Hashtable[EncodeHintType, String]()
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8")
    val matrix = new MultiFormatWriter().encode("1234", BarcodeFormat.QR_CODE, 300, 300, hints)
  }

}

object CommonTests {
  private val BLACK = 0xFF000000
  private val WHITE = 0xFFFFFFFF 
  
  def toBufferdImage(matrix: BitMatrix): BufferedImage = {
    val width = matrix.getWidth
    val height = matrix.getHeight
    val image = new BufferedImage(matrix.getWidth, matrix.getHeight, BufferedImage.TYPE_INT_RGB)
    
    for (i <- 0 until matrix.getWidth) 
      for (j <- 0 until matrix.getHeight) 
        image.setRGB(i, j, if (matrix.get(i, j)) BLACK else WHITE)
    image
  }
  
  def writeToFile(matrix: BitMatrix, format: String, file: File): Unit = {
    val image = toBufferdImage(matrix)
    Try(ImageIO.write(image, format, file)) match {
      case Failure(e) => println(e.getMessage)
      case _ => None
    }
  }
}