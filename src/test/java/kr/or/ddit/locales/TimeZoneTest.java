package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.AfterClass;
import org.junit.Test;

public class TimeZoneTest {

	@Test
	public void test() {
		
		/***Given***/
		

		/***When***/
		String[] tz = TimeZone.getAvailableIDs();
		for(String time : tz){
			System.out.println(time);
		}
		
		/***Then***/

		
	}

}
