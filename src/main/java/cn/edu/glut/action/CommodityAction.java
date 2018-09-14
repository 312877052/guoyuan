package cn.edu.glut.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.edu.glut.component.service.CommodityService;
import cn.edu.glut.model.CommodityDetailVo;
import cn.edu.glut.model.CommodityListVo;

@Controller
@RequestMapping("/common")
public class CommodityAction {
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String showCommoditys(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            					@RequestParam(value = "pageSize",defaultValue = "3") int pageSize, Model model) {
		PageInfo<CommodityListVo> commodtiypageInfo = commodityService.getCommodityList(pageNum, pageSize);
		model.addAttribute("commodtiypageInfo", commodtiypageInfo);
		System.out.println(commodtiypageInfo);
		return "treeList";
	}
	
	@RequestMapping(value="/showCommodity",method=RequestMethod.GET)
	public String showCommodityById(Long commodityId,Model model) {
		CommodityDetailVo commodityDetailVo= commodityService.getCommodityDetailById(commodityId);
		model.addAttribute("commodityDetail", commodityDetailVo);
		return "treedetail";
	}
	
	


}
