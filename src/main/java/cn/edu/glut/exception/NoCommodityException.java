package cn.edu.glut.exception;

public class NoCommodityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoCommodityException(){
		super("商品已下架");
	}

}
