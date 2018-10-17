package kr.or.ddit.encript.seed;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class KISA_SEED_CBC_Test {


	/**
	* Method : EncryptTest
	* 작성자 : pc03
	* 변경이력 :
	* Method 설명 : seed encrypt 암호화 
	*/
	@Test
	public void EncryptTest() {
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		System.out.println("encrypt : "+ encrypt);
		
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);
		System.out.println("decrypt : "+ decrypt);
		
		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, decrypt);
	}

}
