package cn.edu.glut.model;

import java.util.Set;

public class VideoInfo {
	
	private Integer vid;
	private Set<Video> videos;
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public Set<Video> getVideos() {
		return videos;
	}
	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}	
}
