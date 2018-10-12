package kr.or.ddit.util;

public class StringUtil {
	public static String getFileNameFromHeader(String contentDispostion){
		String fileName="";
		String[] splits = contentDispostion.split("; ");
		for(String str:splits){
			if(str.indexOf("filename=")>=0){
				fileName=str.substring(10, str.lastIndexOf("\""));
			}
		}
		return fileName;
	}
}
