package com.eageit.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.eageit.util.Constants;

/**
 * @author satyam
 *
 */
@Service
public class HumanBotService {

	/**
	 * This method will generate and return the list of integers
	 * 
	 * @return
	 */
	public Integer[] generateNumber() {
		int randomNum1 = generateRandom();
		int randomNum2 = generateRandom();
		Integer[] randomNumL = { randomNum1, randomNum2 };
		return randomNumL;
	}

	/**
	 * This method will generate random integer
	 * 
	 * @return
	 */
	private int generateRandom() {
		return ThreadLocalRandom.current().nextInt(Constants.min, Constants.max + 1);
	}

	/**
	 * this method will return the sum of given integers.
	 * 
	 * @param randomNumL
	 * @return
	 */
	public int sum(Integer[] randomNumL) {
		int sum = 0;
		for (int i = 0; i < randomNumL.length; i++) {
			sum = sum + randomNumL[i];
		}
		return sum;
	}
}
