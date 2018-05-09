package com.gx.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.gx.po.StayRegisterPo;
import com.gx.po.UserPo;
import com.gx.service.StayRegisterService;
import com.gx.service.UserService;
import com.gx.service.impl.UserServiceImpl;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("/Login")
@SessionAttributes({"userPo","userName","retMsg"})
public class Login {
	Logger logger = Logger.getLogger(Login.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private StayRegisterService stayRegisterService;
	
	@RequestMapping("/tologin")
	public String tologin(SessionStatus status,ModelMap map){
		status.setComplete();//清空session
		map.put("userPo", "");
		map.put("userName", "");
		map.put("retMsg", "");
		return "/login/login";
	}
	
	@RequestMapping("/tomain")
	public ModelAndView tomain(UserPo user,ModelMap map){
		logger.info("Login tomain..."); 
		ModelAndView mv=null;
		double zongFeiYongOne=0;
		double zongFeiYongTwo=0;
		UserPo u=userService.selectLogin(user);
		List<StayRegisterPo> list=stayRegisterService.selectAll();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getReceiveTargetID()==2) {
				zongFeiYongOne+=list.get(i).getSumConst();
			}else {
				zongFeiYongTwo+=list.get(i).getSumConst();
			}
		}
		
		if (u!=null) {
			map.addAttribute("userName", u.getUserName());
			map.addAttribute("userPo", u);
			mv=new ModelAndView("/main/main");
		}else {
			map.addAttribute("retMsg", "用户名或者密码错误！");
			if (user==null) {
				map.addAttribute("retMsg", "请重新登陆！");
			}
			
			mv=new ModelAndView("/login/login");
		}
		mv.addObject("zongFeiYongOne",zongFeiYongOne);
		mv.addObject("zongFeiYongTwo",zongFeiYongTwo);
		return mv;
	}
	

}
