package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1991 {
	private static Map<String, List<String>> tree = new HashMap<>();
	private static StringBuilder stringBuilder = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		for(int i = 0; i < n; i++) {
			String str[] = bufferedReader.readLine().split(" ");
			List<String> list = new ArrayList<>();

			list.add(str[1]);
			list.add(str[2]);
			tree.put(str[0], list);
		}

		preOrder("A");
		stringBuilder.append("\n");
		inOrder("A");
		stringBuilder.append("\n");
		postOrder("A");
		System.out.print(stringBuilder);
	}

	// 전위 순회
	static void preOrder(String word) {
		if(word.equals(".")) {
			return;
		}

		stringBuilder.append(word);
		preOrder(tree.get(word).get(0));
		preOrder(tree.get(word).get(1));
	}

	// 중위 순회
	static void inOrder(String word) {
		if(word.equals(".")) {
			return;
		}

		inOrder(tree.get(word).get(0));
		stringBuilder.append(word);
		inOrder(tree.get(word).get(1));
	}

	// 후위 순회
	static void postOrder(String word) {
		if(word.equals(".")) {
			return;
		}

		postOrder(tree.get(word).get(0));
		postOrder(tree.get(word).get(1));
		stringBuilder.append(word);
	}
}