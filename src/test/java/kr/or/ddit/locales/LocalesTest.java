package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.Test;

public class LocalesTest {

	@Test
	public void localestest() {
		/***Given***/
		

		/***When***/
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale :locales){
			System.out.println( locale);
		}
		
		/***Then***/

	}

}
