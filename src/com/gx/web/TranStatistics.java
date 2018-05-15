package com.gx.web;

import com.alibaba.druid.util.StringUtils;
import com.gx.page.Page;
import com.gx.po.TransInfoPo;
import com.gx.service.TranInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/TranStatistics")
public class TranStatistics {

	Logger logger = Logger.getLogger(TranStatistics.class);
	@Autowired
	private TranInfoService tranInfoService;
	
	@RequestMapping("/tolist")
	public ModelAndView tolist(String datemin, String datemax,Integer currentPage){
		ModelAndView mv=null;
		int sumCount=0;
		double sumMoney=0;

		if (currentPage==null) {
			currentPage=1;
		}else if (currentPage==0) {
			currentPage=1;
		}
		mv=new ModelAndView("/transtatistics/transtatistics");




		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Page<TransInfoPo> vo=new Page<TransInfoPo>();
		vo.setCurrentPage(currentPage);
		try {
			if (!StringUtils.isEmpty(datemin)){
				String minStr=datemin+" 00:00:00";
				vo.setBeginDate(simpleDateFormat.parse(minStr));
			}
			if (!StringUtils.isEmpty(datemax)){
				String maxStr=datemax+" 23:59:59";
				vo.setEndDate(simpleDateFormat.parse(maxStr));
			}
		}catch (Exception e){
			logger.info("日期转换异常："+e);
		}


		vo=this.tranInfoService.pageFuzzyselect(vo);
		mv.addObject("list",vo);

		if (datemin=="" || datemax=="" || datemin==null || datemax==null) {
		}else {
		}
		mv.addObject("list",vo);
		mv.addObject("sumCount",sumCount);
		mv.addObject("sumMoney",sumMoney);
		mv.addObject("min",datemin);
		mv.addObject("max",datemax);
		return mv;
	}
	
	@RequestMapping("/toinformation")
	public ModelAndView toinformation(Integer id,Integer stayregisterdetailsId,String min, String max){

		return null;
	}

}
