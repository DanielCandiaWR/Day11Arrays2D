package com.day11arrays2d.app;

import java.util.Scanner;

/*
 * HackerRank 30 Days of Code
 * ========== Day 11 2D Arrays ===========
 * Given a 6 x 6 2D Array A:
 * 111000
 * 010000
 * 111000
 * 000000
 * 000000
 * 000000
 * We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
 * abc
 *  d
 * efg
 * The are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass value.
 * Task: 
 * Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
 */
public class Arrays2D {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		final int MAX_ROW_EVALUATE = 4;
		final int MAX_COL_EVALUATE = 4;
		int[][] arr = new int[6][6];
		int maxHourglass = 0;
		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		for (int i = 0; i < MAX_ROW_EVALUATE; i++) {
			for (int j = 0; j < MAX_COL_EVALUATE; j++) {
				int temSum = 0;
				// top hourglass
				temSum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
				// middle hourglass
				temSum += arr[i + 1][j + 1];
				// botton hourglass
				temSum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (temSum > maxHourglass || i == 0 && j == 0) {
					maxHourglass = temSum;
				}
			}
		}
		System.out.println(maxHourglass);
		scanner.close();
	}
}
