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

	public static String getCookie(String cookieString, String key) {
		//"rememberMe=Y; userId=brown; etc=test"
		String[] cookies = cookieString.split("; ");
		
		String cookieValue="";
		for(String str: cookies){
			System.out.println("str : "+ str);
			
			if(str.startsWith(key+"=")){
				cookieValue = str.substring((key+"=").length());
			}
		}
		
//		int beginIndex =cookieString.indexOf(string);
//		int endIndex =cookieString.lastIndexOf("; ");
//		System.out.println("beginIndex :"+beginIndex);
//		System.out.println("endIndex :"+endIndex);
		
//		String name = cookieString.substring(beginIndex, endIndex);
//		System.out.println("name :"+name);
		
		return cookieValue;
	}
	
	
}
