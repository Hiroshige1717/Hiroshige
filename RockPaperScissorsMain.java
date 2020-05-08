package com.hiroshige;

public class RockPaperScissorsMain {
	int b;
	int d;
	static Action action = new Action();
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		explain();
		Action.choice1();
		Action.choice2();
		judge();
	}

	static void explain() {
		System.out.println("今からジャンケンを行います。"
				+ "プレイヤー１が何を出すか選択を終えた後にプレイヤー２が何を出すか選択してください");
	}



	static void judge() throws Throwable{
		if(action.b == 1 && action.d == 2) {
			System.out.println("プレイヤー１の勝ちです");
		}else if(action.b == 1 && action.d == 3) {
			System.out.println("プレイヤー２の勝ちです");
		}else if(action.b == 2 && action.d == 1) {
			System.out.println("プレイヤー２の勝ちです");
		}else if(action.b == 2 && action.d == 3) {
			System.out.println("プレイヤー１の勝ちです");
		}else {
			System.out.println("あいこです、もう1回");
			action.choice1();
			action.choice2();
			judge();

		}
	}


}
