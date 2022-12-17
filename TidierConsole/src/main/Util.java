package main;

import java.util.Random;
import java.util.Scanner;

public class Util {
	
		//Static Attributes
		private static Scanner scan = new Scanner(System.in);
		private static Random rand = new Random();
		
		//Static Methods
		public static Integer scanInt() {
			try {
				int c = scan.nextInt();
				scan.nextLine();
				return c;
			} catch (Exception e) {
				scan.nextLine();
				return -1;
			}
		}
		
		public static String scanString() {
			try {
				String s = scan.nextLine();
				return s;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		
		public static void cls() {
			for (int i=0; i<30; ++i)
				System.out.println();
		}
		
		public static void pause() {
			System.out.println("[i] Press any key to continue...");
			scan.nextLine();
		}
		
		//Setters and Getters
		public static Scanner getScan() {
			return scan;
		}

		public static void setScan(Scanner scan) {
			Util.scan = scan;
		}

		public static Random getRand() {
			return rand;
		}

		public static void setRand(Random rand) {
			Util.rand = rand;
		}
		
}
