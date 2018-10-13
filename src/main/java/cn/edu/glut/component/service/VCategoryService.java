package cn.edu.glut.component.service;

import java.util.List;

import cn.edu.glut.model.Vid;
import cn.edu.glut.util.ServerResponse;

public interface VCategoryService {
	
	/**
	 * 根据视频父节点查询视频该分类下的子分类
	 * @param vcategouryId
	 * @return
	 */
	public List<Vid> getChildParallVCategory(Integer vcategouryId);
	/**
	 * 递归查询本节点的id及孩子节点的id
	 * @param vcategouryId
	 * @return
	 */
	public List<Integer> getCategoryAndChildrenById(Integer vcategouryId);

}
