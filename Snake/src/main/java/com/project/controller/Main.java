package com.project.controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int snakesCount = sc.nextInt();

		int player1 = 0;
		int player2 = 0;

		ArrayList<Integer> cells = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			cells.add(i);
		}

		for (int i = 0; i < snakesCount; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			cells.set(from, to);
		}

		int ladderCount = sc.nextInt();

		for (int i = 0; i < ladderCount; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			cells.set(from, to);
		}

		while (true) {
			int dice = throwDice();
			if (inLimit(player1, dice, n)) {
				int nextPosition = player1 + dice;
				while (cells.get(nextPosition) != nextPosition) {
					nextPosition = cells.get(nextPosition);
				}
				player1 = nextPosition;
			}
			System.out.println(player1);
			if (player1 == n) {
				System.out.println("player1 Wins");
				break;
			}

			dice = throwDice();
			if (inLimit(player2, dice, n)) {
				int nextPosition = player2 + dice;
				while (cells.get(nextPosition) != nextPosition) {
					nextPosition = cells.get(nextPosition);
				}
				player2 = nextPosition;
			}

			System.out.println(player2);
			if (player2 == n) {
				System.out.println("player2 Wins");
				break;
			}

		}
	}

	private static boolean inLimit(int player1, int dice, int n) {
		if (player1 + dice <= n)
			return true;
		return false;
	}

	private static int throwDice() {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(6) + 1;
		System.out.println(rand_int1);
		return rand_int1;
	}
}
