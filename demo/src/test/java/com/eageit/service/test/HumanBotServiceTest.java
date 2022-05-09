package com.eageit.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eageit.service.HumanBotService;

@ExtendWith(MockitoExtension.class)
public class HumanBotServiceTest {

	@InjectMocks
	private HumanBotService botService;

	@Test
	public void testGenerateNumber() {
		Integer[] randomNumL = botService.generateNumber();
		Assertions.assertNotNull(randomNumL);
		Assertions.assertTrue(randomNumL.length>0);
		Assertions.assertEquals(randomNumL.length, 2);
	}

	@Test
	public void testSum() {
		Integer[] randomNumL = { 12, 19 };
		int sum = botService.sum(randomNumL);
		Assertions.assertNotNull(sum);
		Assertions.assertEquals(sum, 31);
	}
}
