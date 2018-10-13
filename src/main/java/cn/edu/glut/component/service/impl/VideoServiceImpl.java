package cn.edu.glut.component.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.glut.component.dao.VideoDao;
import cn.edu.glut.component.service.VideoService;
import cn.edu.glut.model.Video;
@Service("videoService")
public class VideoServiceImpl implements VideoService {
	@Autowired
	private VideoDao videoDao;
	public Video getVideoById(Integer videoId) {
		return videoDao.selectVideoByPrimaryKey(videoId);
	}

	public Set<Video> getVideosByVid(Integer vcategoryId) {
		return videoDao.selectVideosForVid(vcategoryId);
	}

}
