package com.hiroshige;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Action {
	int b;
	int d;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static int choice1() throws Throwable {
		System.out.println("プレイヤー１は1.グー｜2.チョキ｜3.パーの中から数字を選択してください");
		String a = reader.readLine();
		int b = Integer.parseInt(a);
		switch(b) {
			case 1:
				System.out.println("グー");
				break;
			case 2:
				System.out.println("チョキ");
				break;
			case 3:
				System.out.println("パー");
				break;
		}
		return b;
	}
		public static int choice2() throws Throwable {
		System.out.println("プレイヤー２は1.グー｜2.チョキ｜3.パーの中から数字を選択してください");
		String c = reader.readLine();
		int d = Integer.parseInt(c);
		switch(d) {
		case 1:
			System.out.println("グー");
			break;
		case 2:
			System.out.println("チョキ");
			break;
		case 3:
			System.out.println("パー");
			break;
		}
		return d;
	}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
		public static BufferedReader getReader() {
			return reader;
		}
		public static void setReader(BufferedReader reader) {
			Action.reader = reader;
		}


}
