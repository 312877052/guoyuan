package cn.edu.glut.component.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.edu.glut.component.dao.VCategoryDao;
import cn.edu.glut.component.service.VCategoryService;
import cn.edu.glut.model.Vid;

@Service("vCategoryService")
public class VCategoryServiceImpl implements VCategoryService {
	
	Logger log = LogManager.getLogger();
	@Autowired
	VCategoryDao vCategoryDao;
	@Override
	public List<Vid> getChildParallVCategory(Integer vcategouryId) {
		List<Vid> vids = vCategoryDao.selectVidCategoryByParentId(vcategouryId);
        if(CollectionUtils.isEmpty(vids)){
        	log.debug("未找到当前分类的子分类");
            return null;
        }
        return vids;
	}

}
