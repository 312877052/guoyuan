package cn.edu.glut.component.service;

import java.util.List;

import cn.edu.glut.model.Vid;

public interface VCategoryService {
	
	/**
	 * 根据视频父节点查询视频该分类下的子分类
	 * @param vcategouryId
	 * @return
	 */
	public List<Vid> getChildParallVCategory(Integer vcategouryId);

}
