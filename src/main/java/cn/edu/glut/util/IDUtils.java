package cn.edu.glut.util;

import java.util.Random;

/**
 * 各种id生成策略
 * @author Kuang
 *
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		StringBuffer sb = new StringBuffer().append(millis).append(String.format("%03d", end3));
		return sb.toString();
	}
	
	/**
	 * 订单id生成
	 */
	public static Long genOrderId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上四位随机数
		Random random = new Random();
		int end4 = random.nextInt(9999);
		//如果不足三位前面补0
		StringBuffer sb = new StringBuffer().append(millis).append(String.format("%04d", end4));
		long id = new Long(sb.toString());
		return id;
	}
	
	/**
	 * 商品id生成
	 */
	public static long genCommodityId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		StringBuffer sb = new StringBuffer().append(millis).append(String.format("%02d", end2));
		long id = new Long(sb.toString());
		return id;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genOrderId());
	}
}
