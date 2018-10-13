package cn.edu.glut.component.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.edu.glut.component.dao.VCategoryDao;
import cn.edu.glut.component.service.VCategoryService;
import cn.edu.glut.model.Vid;
import cn.edu.glut.util.ServerResponse;

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
	@Override
	public List<Integer> getCategoryAndChildrenById(Integer vcategouryId) {
		 Set<Vid> vcategorySet = new HashSet<>();
	     findChildCategory(vcategorySet,vcategouryId);
	     List<Integer> vcategoryIdList = new ArrayList<>();
	     if(vcategouryId != null){
	         for(Vid v : vcategorySet){
	             vcategoryIdList.add(v.getId());
	         }
	      }
	     return vcategoryIdList;
	}
	 //递归算法,算出子节点
    private Set<Vid> findChildCategory(Set<Vid> vcategorySet ,Integer vcategoryId){
        Vid vid = vCategoryDao.selectByPrimaryKey(vcategoryId);
        if(vid != null){
        	vcategorySet.add(vid);
        }
        //查找子节点,递归算法一定要有一个退出的条件
        List<Vid> vidList = vCategoryDao.selectVidCategoryByParentId(vcategoryId);
        for(Vid v: vidList){
            findChildCategory(vcategorySet,v.getId());
        }
        return vcategorySet;
    }

}
