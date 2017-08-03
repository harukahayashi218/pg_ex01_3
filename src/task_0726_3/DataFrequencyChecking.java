package task_0726_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//英単語頻出度チェッククラス
public class DataFrequencyChecking {

	//処理開始、結果表示
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("英文を入力してください。");
			System.out.println("注1：単語と単語の間は半角スペースで区切ってください。");
			System.out.println("記号はカンマとピリオドのみ使用可能です。");

			String inputSentence = "";
			inputSentence = br.readLine().toLowerCase();

			countWord(inputSentence).entrySet().stream().sorted(java.util.Collections.
					reverseOrder(java.util.Map.Entry.comparingByValue())).forEach(s -> System.out.println(s));
			System.out.println("完了しました。");
		}
		catch(Exception e) {
			System.out.println("エラーが発生しました。");
		}
		finally {
			System.out.println("処理を終了します。");
		}
	}

	//英単語頻出度チェック
	public static Map<String, Integer> countWord(String inputSentence) {

		Map<String, Integer> countMap = new HashMap<String, Integer>();
		String[] words = inputSentence.split(" ", 0);

		for (String word : words) {

			//記号が含まれる場合は除去
			if (word.contains(",")) {
				word = word.replace(",","");
			}
			else if (word.contains(".")) {
				word = word.replace(".","");
			}
			else {
			}

			//マップに同じ文字が存在するかチェック
			if (countMap.containsKey(word)) {
				int currentCnt = countMap.get(word);
				int newCnt = ++currentCnt;
				countMap.put(word, newCnt);
			}
			else {
				countMap.put(word, 1);
			}
		}
		return countMap;
	}
}
