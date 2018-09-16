package cn.edu.glut.component.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.CommodityListVo;
import cn.edu.glut.model.CommodityOrderVo;


/**
 *  操作商品信息的dao
 *  @author Kuang
 *
 */
public interface CommodityDao {
	
	/**
	 * 查询所有商品列表信息
	 * @author Kuang
	 */
	List<CommodityListVo> selectCommodityList();
	/**
	 * 插入商品
	 * @param commodity
	 * @author Kuang
	 * @return 
	 */
	int insertCommodity(Commodity commodity); 
	/**
	 * 根据商品id查询商品基本信息
	 * @param commodityId
	 * @author Kuang
	 * @return 
	 */
	Commodity selectCommodityById(Long commodityId);
	/**
	 * 根据商品id查询商品订单列表信息
	 * @param commodityId
	 * @author Kuang
	 * @return 
	 */
	CommodityOrderVo selectCommodityOrderVoById(Long commodityId);
	/**
	 * 查询商品的总数量（用于检查是否生成订单）
	 * @author Kuang
	 * @param commodityId
	 * @return
	 */
	int selectCommodityNum(Long commodityId);
	/**
	 * 更新商品的数量
	 * @param commodityId
	 * @param num
	 * @return
	 */
	int updataCommodityNum(@Param("commodityId") Long commodityId,@Param("currnum") Integer currnum);
	
}
