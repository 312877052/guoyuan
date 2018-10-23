package cn.edu.glut.action;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.edu.glut.component.service.CommodityService;
import cn.edu.glut.model.CommodityDetailVo;
import cn.edu.glut.model.CommodityListVo;
import cn.edu.glut.util.DebugOut;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/commondity")
public class CommodityAction {
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String showCommoditys(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            					@RequestParam(value = "pageSize",defaultValue = "3") int pageSize, Model model
            					,HttpServletResponse response) {
		PageInfo<CommodityListVo> commodtiypageInfo = commodityService.getCommodityList(pageNum, pageSize);
		model.addAttribute("commodtiypageInfo", commodtiypageInfo);
		JSONArray list=new JSONArray();
		list.addAll(commodtiypageInfo.getList());
		DebugOut.print(list);
		try {
			response.getWriter().print(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/showCommodity",method=RequestMethod.GET)
	public String showCommodityById(Long commodityId,Model model) {
		CommodityDetailVo commodityDetailVo= commodityService.getCommodityDetailById(commodityId);
		model.addAttribute("commodityDetail", commodityDetailVo);
		JSONObject obj =JSONObject.fromObject(commodityDetailVo);
		model.addAttribute("obj", obj.toString());
		return "treedetail";
	}
	
	


}
