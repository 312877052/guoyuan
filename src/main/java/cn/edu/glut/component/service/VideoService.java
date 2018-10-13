package cn.edu.glut.component.service;

import java.util.Set;

import cn.edu.glut.model.Video;

public interface VideoService {
	
	public Video getVideoById(Integer videoId);
	
	public Set<Video> getVideosByVid(Integer vcategoryId);

}
