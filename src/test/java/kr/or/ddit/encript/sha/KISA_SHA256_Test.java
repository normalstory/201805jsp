package kr.or.ddit.encript.sha;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class KISA_SHA256_Test {

	//복후화가 안됨
	@Test
	public void encrpytTest() {
		/***Given***/
		String pass = "sallypass";
		String pass1 = "brownpasst";

		/***When***/
		String encrpyt = KISA_SHA256.encrypt(pass);
		String encrpyt1 = KISA_SHA256.encrypt(pass1);
		System.out.println("Encrpyt  : "+ encrpyt);
		System.out.println("Encrpyt1 : "+ encrpyt1);

		/***Then***/
		assertEquals("65c8b7874e6e1d2bc0978232e2274f7764ac156926db381f74f7b46fc5dc", encrpyt);
	}

}
