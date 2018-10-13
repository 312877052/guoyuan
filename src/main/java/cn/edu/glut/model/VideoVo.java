package cn.edu.glut.model;

import java.io.Serializable;
import java.util.List;

public class VideoVo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer size;
	private List<Vid> vids;
	private List<VideoInfo> videolist;
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<Vid> getVids() {
		return vids;
	}
	public void setVids(List<Vid> vids) {
		this.vids = vids;
	}
	public List<VideoInfo> getVideolist() {
		return videolist;
	}
	public void setVideolist(List<VideoInfo> videolist) {
		this.videolist = videolist;
	}
}
