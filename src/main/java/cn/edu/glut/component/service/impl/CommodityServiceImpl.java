package cn.edu.glut.component.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.glut.component.dao.CommodityDao;
import cn.edu.glut.component.dao.CommodityDecDao;
import cn.edu.glut.component.service.CommodityService;
import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.CommodityDec;
import cn.edu.glut.model.CommodityDetailVo;
import cn.edu.glut.model.CommodityListVo;
import cn.edu.glut.util.IDUtils;
import cn.edu.glut.util.ServerResponse;

/**
 * 商品服务类
 * @author Kuang
 *
 */

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private CommodityDecDao commodityDetailDao;
	
	public PageInfo<CommodityListVo> getCommodityList(int pageNum, int pageSize) {
		//设置当前页和每页大小
		PageHelper.startPage(pageNum,pageSize);
		List<CommodityListVo> commodityList = commodityDao.selectCommodityList();
		for(CommodityListVo commodityListVo:commodityList) {
			Integer mouth = commodityListVo.getCommodityTerm()/31+1;
			commodityListVo.setCommodityTerm(mouth);
		}
		PageInfo<CommodityListVo> pageInfo = new PageInfo<>(commodityList);
		return pageInfo;
	}

	public ServerResponse saveCommodity(Commodity commodity, String detail, String photos) {
		if(commodity!=null && !StringUtils.isEmpty(detail)&&!StringUtils.isEmpty(photos)) {
			//设置商品id
			Long commodityId = IDUtils.genCommodityId();
			commodity.setCommodityId(commodityId);
			//设置图片url地址
			String[] photoUrls = photos.split(",");
			System.out.println("图片长度："+photoUrls.length);
			String[] newphotoUrls = new String[5];
			for(int i=0;i<photoUrls.length;i++) {
				newphotoUrls[i] = photoUrls[i];
			}
			if(newphotoUrls.length>0) {
				commodity.setCommodityMainPho(newphotoUrls[0]);
				commodity.setCommoditySubPho1(newphotoUrls[1]);
				commodity.setCommoditySubPho2(newphotoUrls[2]);
				commodity.setCommoditySubPho3(newphotoUrls[3]);
				commodity.setCommoditySubPho4(newphotoUrls[4]);
			}
			int commodityResult = commodityDao.insertCommodity(commodity);
			if(commodityResult !=1) {
				return ServerResponse.createByErrorMessage("商品添加失败");
			}
			CommodityDec commodityDec = new CommodityDec();
			commodityDec.setCommodityId(commodityId);
			commodityDec.setCommodityDesc(detail);
			int commodityDeatilResult = commodityDetailDao.insertCommodityDec(commodityDec);
			if(commodityDeatilResult !=1) {
				return ServerResponse.createByErrorMessage("商品添加失败");
			}
			return ServerResponse.createBySuccessMessage("商品添加成功");
		}		
		return ServerResponse.createByErrorMessage("商品添加失败");
	}

	public CommodityDetailVo getCommodityDetailById(Long commodityId) {
		Commodity commodity = commodityDao.selectCommodityById(commodityId);
		if(commodity == null) {
			return null;
		}
		CommodityDetailVo detailVo = assembleCommodityDetailVo(commodity);
		String dec = commodityDetailDao.selectCommodityDecById(commodityId);
		detailVo.setCommodityDesc(dec);
		return detailVo;
	}
	
	private CommodityDetailVo assembleCommodityDetailVo(Commodity commodity) {
		CommodityDetailVo commodityDetailVo = new CommodityDetailVo();
		commodityDetailVo.setCommodityId(commodity.getCommodityId());
		commodityDetailVo.setCid(commodity.getCid());
		commodityDetailVo.setCommodityName(commodity.getCommodityName());
		commodityDetailVo.setCommodityNum(commodity.getCommodityNum());
		commodityDetailVo.setCommodityCurrNum(commodity.getCommodityCurrNum());
		commodityDetailVo.setCommodityPrice(commodity.getCommodityPrice());
		commodityDetailVo.setCommodityProduct(commodity.getCommodityProduct());
		commodityDetailVo.setCommodityStatus(commodity.getCommodityStatus());
		commodityDetailVo.setCommodityTerm(commodity.getCommodityTerm());
		commodityDetailVo.setCommodityVideoUrl(commodity.getCommodityVideoUrl());
		commodityDetailVo.setCommodityMainPho(commodity.getCommodityMainPho());
		commodityDetailVo.setCommoditySubPho1(commodity.getCommoditySubPho1());
		commodityDetailVo.setCommoditySubPho2(commodity.getCommoditySubPho2());
		commodityDetailVo.setCommoditySubPho3(commodity.getCommoditySubPho3());
		commodityDetailVo.setCommoditySubPho4(commodity.getCommoditySubPho4());
		return commodityDetailVo;
	}
	
}
