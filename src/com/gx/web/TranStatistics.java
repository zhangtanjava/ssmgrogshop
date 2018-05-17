package com.gx.web;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.gx.page.Page;
import com.gx.po.TransInfoPo;
import com.gx.service.TranInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/TranStatistics")
public class TranStatistics {

	Logger logger = Logger.getLogger(TranStatistics.class);

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private TranInfoService tranInfoService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(String datemin, String datemax,String agreementID,Integer currentPage){
		logger.info("TranStatistics tolist req:"+datemin+"|"+datemax+"|"+agreementID);
		ModelAndView mv=null;
		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		mv=new ModelAndView("/transtatistics/transtatistics");

		TransInfoPo req = new TransInfoPo();

		Page<TransInfoPo> vo=new Page<TransInfoPo>();
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
		vo=this.tranInfoService.pageFuzzyselect(vo,req);


		TransInfoPo res = this.tranInfoService.statisticsInfo(req);

		mv.addObject("list",vo);
		mv.addObject("sumCount",res.getCounts().toString());
		mv.addObject("sumMoney",res.getSumMoney() == null? "0":res.getSumMoney().toString());
		mv.addObject("min",datemin);
		mv.addObject("max",datemax);
		mv.addObject("agID",agreementID);
		return mv;
	}
	
	@RequestMapping("/toinformation")
	public ModelAndView toinformation(Integer id,Integer stayregisterdetailsId,String min, String max){

		return null;
	}

	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv=null;
		mv=new ModelAndView("/transtatistics/add");
		return mv;
	}

	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int id){
		ModelAndView mv=null;
		TransInfoPo list=tranInfoService.selectById(id);
		mv=new ModelAndView("/transtatistics/update");
		mv.addObject("list",list);
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView add(TransInfoPo transInfoPo){
		ModelAndView mv=null;
		String payDateStr = transInfoPo.getPayDateStr();
		String playdateStr = transInfoPo.getPlayDateStr();

		try {
			if (!StringUtils.isEmpty(payDateStr)){
				transInfoPo.setPayDate(simpleDateFormat.parse(payDateStr));
			}
			if (!StringUtils.isEmpty(playdateStr)){
				transInfoPo.setPlayDate(simpleDateFormat.parse(playdateStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}

		transInfoPo.setCreateDate(new Date());
		transInfoPo.setUpdateDate(new Date());
		tranInfoService.insertAll(transInfoPo);
		mv=new ModelAndView("redirect:/Transtatistics/tolist.do");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(TransInfoPo transInfoPo){
		ModelAndView mv=null;
		transInfoPo.setUpdateDate(new Date());
		tranInfoService.updateById(transInfoPo);
		mv=new ModelAndView("redirect:/Transtatistics/tolist.do");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(String id){
		ModelAndView mv=null;
		String[] FenGe=id.split(",");
		for (int i = 0; i < FenGe.length; i++) {
			tranInfoService.deleteById(Integer.parseInt(FenGe[i]));
		}
		mv=new ModelAndView("redirect:/Transtatistics/tolist.do");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value="/selectByAgreementID")
	public Object selectByName(String agreementID){
		int accout = tranInfoService.selectByAgreementID(agreementID);
		Gson gson =new Gson();
		return gson.toJson(accout);
	}
}
