package com.wellnow.investhelper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wellnow.investhelper.app.api.share.GetShareByFigiInbound;

@SpringBootTest
class InvestHelperApplicationTests {
	@Autowired
	GetShareByFigiInbound getShareByFigiInbound;

	@Test
	void contextLoads() {
		
	}
}
