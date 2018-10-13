package cn.edu.glut.component.dao;

import java.util.List;

import cn.edu.glut.model.Vid;

public interface VCategoryDao {

	/**
	 * 根据视频的父类id查找子类类别
	 * @param parentId
	 * @return
	 */
	List<Vid> selectVidCategoryByParentId(Integer parentId);
	/**
	 * 根据主id查询分类
	 * @param primaryKey
	 * @return
	 */
	Vid selectByPrimaryKey(Integer primaryId);
}
