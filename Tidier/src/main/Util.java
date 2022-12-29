package main;

import java.util.Random;
import java.util.Scanner;

public class Util {
	
	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	
	public static Integer scanInt() {
		try {
			return scan.nextInt();
		} catch (Exception e) {
			return -1;
		} finally {
			scan.nextLine();
		}
	}
	
	public static String scanString() {
		try {
			return scan.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String generateRandomDigitsAsString(int n) {
		StringBuilder s = new StringBuilder();
		for (int i=0; i<n; ++i) {
			s.append(rand.nextInt());
		}
		return s.toString();
	}
	
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			System.out.println("[!] Session interrupted.");
		}
	}
	
	public static void cls() {
		for (int i=0; i<30; ++i)
			System.out.println();
	}
	
	public static void pause() {
		System.out.print("[i] Press any key to continue...");
		scan.nextLine();
	}
}
