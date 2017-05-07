package com.manning.gia.todo.web

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

/**
  * Created by cielleech on 16/6/28.
  */
class ToDoServlet extends HttpServlet {
  protected override def service(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val servletPath = request.getServletPath
  }
}