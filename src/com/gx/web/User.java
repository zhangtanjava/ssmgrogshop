package com.gx.web;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.AttributePo;
import com.gx.po.UserPo;
import com.gx.service.AttributeService;
import com.gx.service.UserService;
import com.gx.service.impl.UserServiceImpl;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("/User")
public class User {
	
	Logger logger = Logger.getLogger(User.class);
	@Autowired
	private AttributeService attributeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(HttpServletRequest request,Integer currentPage,String txtname){
		ModelAndView mv=null;
		mv=new ModelAndView("/user/list");
		Page<UserPo> vo=new Page<UserPo>();
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		if(txtname==null)
		{
			txtname="";
		}
		vo.setCurrentPage(currentPage);
		vo=this.userService.pageFuzzyselect(txtname, vo);
		logger.info("createTime 是："+vo.getResult().get(0).getCreateTime());
		mv.addObject("list",vo);
		mv.addObject("txtname",txtname);
		return mv;
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		List<AttributePo> listGender=attributeService.selectGender();                      //性别
		List<AttributePo> listNation=attributeService.selectNation();                      //民族
		List<AttributePo> listPassengerLevel=attributeService.selectPassengerLevel();      //旅客级别
		List<AttributePo> listEducationDegree=attributeService.selectEducationDegree();    //文化程度
		List<AttributePo> listPapers=attributeService.selectPapers();                      //证件类型
		List<AttributePo> listThingReason=attributeService.selectThingReason();            //事由
		mv=new ModelAndView("/user/add");
		mv.addObject("listGender",listGender);
		mv.addObject("listNation",listNation);
		mv.addObject("listPassengerLevel",listPassengerLevel);
		mv.addObject("listEducationDegree",listEducationDegree);
		mv.addObject("listPapers",listPapers);
		mv.addObject("listThingReason",listThingReason);
		return mv;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		List<AttributePo> listGender=attributeService.selectGender();                      //性别
		List<AttributePo> listNation=attributeService.selectNation();                      //民族
		List<AttributePo> listPassengerLevel=attributeService.selectPassengerLevel();      //旅客级别
		List<AttributePo> listEducationDegree=attributeService.selectEducationDegree();    //文化程度
		List<AttributePo> listPapers=attributeService.selectPapers();                      //证件类型
		List<AttributePo> listThingReason=attributeService.selectThingReason();            //事由
		UserPo list=userService.selectById(id);
		mv=new ModelAndView("/user/update");
		mv.addObject("listGender",listGender);
		mv.addObject("listNation",listNation);
		mv.addObject("listPassengerLevel",listPassengerLevel);
		mv.addObject("listEducationDegree",listEducationDegree);
		mv.addObject("listPapers",listPapers);
		mv.addObject("listThingReason",listThingReason);
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(UserPo userPo){
		ModelAndView mv=null;
		userPo.setCreateTime(new Timestamp(System.currentTimeMillis()));
		userPo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userService.insertAll(userPo);
		mv=new ModelAndView("redirect:/User/tolist.do");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(UserPo userPo){
		ModelAndView mv=null;
		userPo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userService.updateById(userPo);
		mv=new ModelAndView("redirect:/User/tolist.do");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			userService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/User/tolist.do");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/selectByUserName")
	public Object selectByName(String userName){
		int accout = userService.selectByUserName(userName);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}
}
