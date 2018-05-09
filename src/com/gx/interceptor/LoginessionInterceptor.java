package com.gx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component("loginessionInterceptor")
public class LoginessionInterceptor implements HandlerInterceptor{
	private static final String LOGIN_URL="/jsp/login/login.jsp"; 
	  @Override 
	  public void postHandle(HttpServletRequest request, 
	      HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception { 
	     
	 
	  } 
	 
	  @Override 
	  public void afterCompletion(HttpServletRequest request, 
	      HttpServletResponse response, Object handler, Exception ex) 
	      throws Exception { 
	 
	  } 
	 
	  @Override 
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler) throws Exception { 
	    HttpSession session=request.getSession(true); 
	    //session中获取用户名信息 
	    Object obj = session.getAttribute("userPo"); 
	    if (obj==null||"".equals(obj.toString())) { 
	      response.sendRedirect(request.getSession().getServletContext().getContextPath()+LOGIN_URL);
	         return false;
	      }
	    return true;
	    }
}
