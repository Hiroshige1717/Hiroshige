package numeron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
*@author Hiroshige Murakawa
*/
public class Numeron {
	final static int answer_size = 4;
	static int hit = 0;
	static int bite = 0;
	static int challenge = 1;
	//Mainメソッド
	public static void main(String[] args) {
		printExplanation();
		String[] right_answer;
		right_answer = enterRightAnswer();
		
		while(true) {
			String[] user_answer;
			user_answer = readUserAnswer();
			checkAnswer(right_answer, user_answer);
			challenge++;
			if(hit == answer_size) {
				System.out.println("正解です。ゲームを終了します。");
				break;
			}
		}
	}
		
		//説明を出力するメソッド
		public static void printExplanation() {
			System.out.println("Welcome to Numeron in English!!");
			System.out.println("-----------\n" + "ルール説明");
			String explanation = "Numeron in Englishとは、４つのアルファベットが重複しない英単語を推測して当てるゲーム。\n"
					+ "一方のプレイヤーが任意の英単語を入力。解答の英単語が桁まで一致してる場合を、hit\n"
					+ "任意の数字と解答の数字が一致していた場合をbyteとし、それぞれ数を表示する。\n"
					+ "4つのアルファベットの位置が全て完全に一致（hit）した場合に、終了する。\n";
					
			System.out.println(explanation);
		}
		
		//正解を入力するメソッド
		public static String[] enterRightAnswer() {
			String[] right_answer = new String[answer_size];
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("重複しない" + answer_size + "つのアルファベットからなる英単語を入力してください。");
			for(int i = 0; i < right_answer.length; i++) {
				try {
					System.out.print((i+1)+"つ目のアルファベット:");
					String a = r.readLine();
					right_answer[i] = a;
				}catch (IOException e) {
					System.out.println("形式が間違っています。");
					i--;
				}catch(Exception e) {
					System.out.println("アルファベットを入力してください。");
				}
			}
			return right_answer;
		}
			
		//入力された英単語の読み込み
		public static String[] readUserAnswer() {
			hit = 0;
			bite = 0;
			String[] user_answer = new String[answer_size];
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n"+challenge+"回目のチャレンジ");
			for(int i = 0; i < user_answer.length; i++) {
				try {
					System.out.print((i+1)+"つ目のアルファベット:");
					String a = r.readLine();
					user_answer[i] = a;
				}catch (IOException e) {
					System.out.println("形式が間違っています。");
					i--;
				}
			}
			return user_answer;
		}
		
		
		//正解との照らしわせ
		public static void checkAnswer(String[] right_answer,String[] user_answer) {
			for(int i = 0; i < right_answer.length; i++) {
				for(int j = 0; j < user_answer.length; j++) {
					if(right_answer[j].equals(user_answer[i])) {
						if(j==i) {
							hit++;

						}
					}
				}
			}
			System.out.println(hit+" eat  "+bite+" bite");
		}
	}