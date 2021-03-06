package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import sun.awt.datatransfer.DataTransferer.IndexOrderComparator;

public class StringUtilTest {


	@Test
	public void StringUtiltest() {
		/***Given***/
		String contentDispostion = "form-data; name=\"profile\"; filename=\"brown.png\"";

		/***When***/
		//login
//		int start = contentDispostion.indexOf("filename=\"");
//		System.out.println(start);
//		int end=contentDispostion.lastIndexOf(ch);
//		System.out.println(end);

		String fileName="";
		String[] splits = contentDispostion.split("; ");
		
		for(String str:splits){
			if(str.indexOf("filename=")>=0){
				System.out.println(str);
				System.out.println("str.length : "+str.length());
				//System.out.println(str.substring(10, 19));
				System.out.println(str.substring(10, str.lastIndexOf("\"")));
				
				fileName=str.substring(10, str.lastIndexOf("\""));
			}
		}
		
		/***Then***/
		assertEquals("brown.png", fileName);
	}

}
