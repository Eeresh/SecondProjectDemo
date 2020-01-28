package com.quiz;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test2Demo {

	// Instantiate Scanner class for reading keyboard input
	public static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {

		String orgAmount;
		int orgPences; // pennies part of the amount
		long orgDollars;
		int twenties, tens, fives, twos, ones;

		System.out.println("Enter Monetary Values in Pounds and Pences.");

		orgAmount = kbd.nextLine().trim();
		BigDecimal bdAmount = new BigDecimal(orgAmount);
		bdAmount = bdAmount.setScale(2, BigDecimal.ROUND_UP);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(true);
		String result = df.format(bdAmount);

		System.out
				.println("Amount you entered in Pounds and Pences: £" + result);

		orgDollars = bdAmount.longValue();
		System.out.printf("\nPounds Part of Original Amount: £%,d\n",
				orgDollars);

		BigInteger decimal = bdAmount.remainder(BigDecimal.ONE)
				.movePointRight(bdAmount.scale()).abs().toBigInteger();
		orgPences = decimal.intValue();
		System.out.println("Pences part of orginal amount: " + orgPences + "p");

		twos = (int) orgDollars / 2;
		orgDollars = orgDollars % 2L;
		System.out.println("Number of £2 coin: " + twos);

		ones = (int) orgDollars;
		System.out.println("Number of £1 coin: " + ones);

		twenties = (int) orgPences / 20;
		orgPences = orgPences % 20;
		System.out.println("Number of 20p: " + twenties);

		tens = (int) orgPences / 10;
		orgPences = orgPences % 10;
		System.out.println("Number of 10p: " + tens);

		fives = (int) orgPences / 5;
		orgPences = orgPences % 5;
		System.out.println("Number of 5p: " + fives);
		twos = (int) orgPences / 2;
		orgPences = orgPences % 2;
		System.out.println("Number of 2p: " + twos);

		ones = (int) orgPences;
		System.out.println("Number of 1p: " + ones);

	}
}
