package cn.edu.glut.util;

public class DebugOut {
	public static boolean Debug=true;
	
	public static void print(Object message) {
		if(Debug) {
			StackTraceElement[] stack=Thread.currentThread().getStackTrace();
			int line=stack[2].getLineNumber();
			String clazz=stack[2].getClassName();
			System.out.println("\n\n*********************debug*********************\n");
			System.out.println("class:"+clazz+" line:"+line+"\n" +message);
			System.out.println("\n*********************debug*********************\n\n");
		}
	}
}
