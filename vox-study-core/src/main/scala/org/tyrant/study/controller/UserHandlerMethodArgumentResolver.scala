package org.tyrant.study.controller

import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.core.MethodParameter
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.bind.support.WebDataBinderFactory
import org.tyrant.study.support.UserIdAttribute

class UserHandlerMethodArgumentResolver extends HandlerMethodArgumentResolver {
  def resolveArgument(parameter: MethodParameter, mvc: ModelAndViewContainer, webRequest: NativeWebRequest, factory: WebDataBinderFactory): Object = ???
  
  def supportsParameter(parameter: MethodParameter): Boolean = {
    return parameter.hasParameterAnnotation(classOf[UserIdAttribute])
  }
}