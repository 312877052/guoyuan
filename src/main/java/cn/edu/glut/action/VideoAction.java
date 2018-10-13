package cn.edu.glut.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.glut.component.service.VCategoryService;
import cn.edu.glut.component.service.VideoService;
import cn.edu.glut.model.Vid;
import cn.edu.glut.model.Video;
import cn.edu.glut.model.VideoInfo;
import cn.edu.glut.model.VideoVo;

@Controller
@RequestMapping("video")
public class VideoAction {
	@Resource(name="vCategoryService")
	private VCategoryService vCategoryService;
	@Resource(name="videoService")
	private VideoService videoService;
	
	/**
	 * 展示视频列表
	 * @param vcategoryId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showvideos",method=RequestMethod.GET)
	public String showVideosList(Integer vcategoryId,Model model) {
		List<Vid> vids = vCategoryService.getChildParallVCategory(vcategoryId);
		List<VideoInfo> videolist = new ArrayList<>();
		for(Vid v: vids) {
			Integer vid = v.getId();
			Set<Video> videosByVid = videoService.getVideosByVid(vid);
			VideoInfo info = new VideoInfo();
			info.setVid(vid);
			info.setVideos(videosByVid);
			videolist.add(info);
		}
		VideoVo videoVo = new VideoVo();
		videoVo.setVids(vids);
		videoVo.setSize(vids.size());
		videoVo.setVideolist(videolist);
		model.addAttribute("videoVo", videoVo);
		return "videolist";
	}
	
}
