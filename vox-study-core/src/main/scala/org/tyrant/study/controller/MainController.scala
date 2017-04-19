package org.tyrant.study.controller

import javax.servlet.http.HttpServletRequest

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody, RestController}

/**
  * Created by cielleech on 16/7/4.
  */
@RestController
@RequestMapping(value = Array("/cms"))
class MainController {

  import MainController.logger

  @RequestMapping(value = Array("/index"), method = Array(RequestMethod.GET), produces = Array("text/javascript;charset=UTF-8"))
  @ResponseBody
  def index(request: HttpServletRequest): String = {
    logger.debug("this is a test")
    "index"
  }
}

object MainController {
  val logger = LoggerFactory.getLogger(classOf[MainController])
}
