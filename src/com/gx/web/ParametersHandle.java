package com.gx.web;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.Parametersinfo;
import com.gx.po.Parametersinfo;
import com.gx.service.ParametersHandleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/ParametersHandle")
public class ParametersHandle {

	Logger logger = Logger.getLogger(ParametersHandle.class);

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private ParametersHandleService parametersHandleService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(String datemin, String datemax,String agreementID,Integer currentPage){
		logger.info("ParametersHandle tolist req:"+datemin+"|"+datemax+"|"+agreementID);
		ModelAndView mv=null;
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		mv=new ModelAndView("/parametershandle/parametershandle");

		Parametersinfo req = new Parametersinfo();

		Page<Parametersinfo> vo=new Page<Parametersinfo>();
		vo.setCurrentPage(currentPage);
		try {
			if (!StringUtils.isEmpty(datemin)){
				String minStr=datemin+" 00:00:00";
				req.setBeginDate(simpleDateFormat.parse(minStr));
			}
			if (!StringUtils.isEmpty(datemax)){
				String maxStr=datemax+" 23:59:59";
				req.setEndDate(simpleDateFormat.parse(maxStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}

		req.setAgreementID(agreementID);

		vo=this.parametersHandleService.pageFuzzyselect(vo,req);


		Parametersinfo res = this.parametersHandleService.selectAllInfo(req);

		mv.addObject("list",vo);
		mv.addObject("min",datemin);
		mv.addObject("max",datemax);
		mv.addObject("agID",agreementID);
		return mv;
	}
	

	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		mv=new ModelAndView("/parametershandle/add");
		return mv;
	}

	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		Parametersinfo list=parametersHandleService.selectById(id);
		mv=new ModelAndView("/parametershandle/update");
		mv.addObject("list",list);
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(Parametersinfo Parametersinfo){
		ModelAndView mv=null;
		String payDateStr = Parametersinfo.getPayDateStr();
		String playdateStr = Parametersinfo.getPlayDateStr();

//		try {
//			if (!StringUtils.isEmpty(payDateStr)){
//				Parametersinfo.setPayDate(simpleDateFormat.parse(payDateStr));
//			}
//			if (!StringUtils.isEmpty(playdateStr)){
//				Parametersinfo.setPlayDate(simpleDateFormat.parse(playdateStr));
//			}
//		}catch (Exception e){
//			logger.info("日期转换异常："+e);
//		}

//		Parametersinfo.setCreateDate(new Date());
//		Parametersinfo.setUpdateDate(new Date());
		parametersHandleService.insertAll(Parametersinfo);
		mv=new ModelAndView("redirect:/ParametersHandle/tolist.do");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(Parametersinfo Parametersinfo){
		ModelAndView mv=null;
		String payDateStr = Parametersinfo.getPayDateStr();
		String playdateStr = Parametersinfo.getPlayDateStr();

		try {
//			if (!StringUtils.isEmpty(payDateStr)){
//				Parametersinfo.setPayDate(simpleDateFormat.parse(payDateStr));
//			}
//			if (!StringUtils.isEmpty(playdateStr)){
//				Parametersinfo.setPlayDate(simpleDateFormat.parse(playdateStr));
//			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}

//		Parametersinfo.setUpdateDate(new Date());
		parametersHandleService.updateById(Parametersinfo);
		mv=new ModelAndView("redirect:/ParametersHandle/tolist.do");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			parametersHandleService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/ParametersHandle/tolist.do");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value="/selectByAgreementID")
	public Object selectByName(String agreementID){
		int accout = parametersHandleService.selectByAgreementID(agreementID);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}

	@RequestMapping("/toinformation")
	public ModelAndView toinformation(Integer id,Integer stayregisterdetailsId,String min, String max){
		ModelAndView mv=null;
		Parametersinfo list=parametersHandleService.selectById(id);

		mv=new ModelAndView("/parametershandle/particulars");
		mv.addObject("list",list);
		mv.addObject("id",id);
		mv.addObject("min",min);
		mv.addObject("max",max);
		return mv;
	}
}
