package cn.edu.glut.component.service;

import com.github.pagehelper.PageInfo;

import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.CommodityDetailVo;
import cn.edu.glut.model.CommodityListVo;
import cn.edu.glut.util.ServerResponse;

public interface CommodityService {
	/**
	 *商品列表分页
	 *@author Kuang
	 *@param vo
	 */
	public PageInfo<CommodityListVo> getCommodityList(int pageNum,int pageSize);
	/**
	 * 保存商品
	 * @author Kuang
	 * @param commodity 商品基本信息
	 * @param detail  商品详情
	 * @param photos 商品图片url
	 * @return
	 */
	public ServerResponse saveCommodity(Commodity commodity,String detail,String photos);
	/**
	 * 根据商品id查询该商品的详情
	 * @author Kuang
	 * @param commodityId
	 * @return
	 */
	public CommodityDetailVo getCommodityDetailById(Long commodityId);

}
