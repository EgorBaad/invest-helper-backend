package com.wellnow.investhelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wellnow.investhelper.app.api.share.GetShareByFigiInbound;

import com.wellnow.investhelper.domain.DShare;

@SpringBootTest
class InvestHelperApplicationTests {
	@Autowired
	GetShareByFigiInbound getShareByFigiInbound;

	@Test
	void contextLoads() {
		DShare share = getShareByFigiInbound.execute("BBG000B9XRY4");
		assertEquals(share.getName(), "Apple");
	}
}
