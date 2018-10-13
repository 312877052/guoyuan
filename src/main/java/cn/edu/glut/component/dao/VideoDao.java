package cn.edu.glut.component.dao;

import java.util.Set;

import cn.edu.glut.model.Video;

public interface VideoDao {
	
	public Set<Video> selectVideosForVid(Integer vcategoryId);
	public Video selectVideoByPrimaryKey(Integer videoId);

}
