package com.webdriver.UtilSection;

import java.util.Random;

public class GetRandom {
	/**
	 * Random function to generate random values for use.
	 * 
	 * @param
	 */
	public static int value(int size, int morethan) throws Exception {

		Random rand = new Random();

		int number = 0;

		do {
			number = rand.nextInt(size);
		} while (number <= morethan);

		return number;

	}

}
