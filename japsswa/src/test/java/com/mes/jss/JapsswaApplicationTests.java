package com.mes.jss;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JapsswaApplicationTests {

	@Test
	void contextLoads() {
	}
	

	@Autowired
	StringEncryptor jasyptStringEncryptor;	
	
	@Test
	public void jasyt_test() {
		String[] plaintTestList = {"jdbc:oracle:thin:@13.236.94.13:1521/xe","jss","jss"};
		for(String plainText : plaintTestList) {
			String encyptText = jasyptStringEncryptor.encrypt(plainText);
			System.out.println(encyptText);
		}
	}

}
