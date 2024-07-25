package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1486. 장훈이의 높은 선반 D4
/*
 * 서점에는 높이가 B인 선반이 하나
 * N명의 점원들이 사용해야 함
 * 점원의 키는 Hi, 탑을 쌓아서 물건을 사용
 * 점원들이 쌓는 탑은 점원 1명 이상으로 이루어져 있음
 * 1명일 경우 그 점원의 키, 2명 이상일 경우 모든 점원의 키의 합
 * 높이가 B 이상인 탑 중에 가장 낮은 탑 구하기
 */

public class SWEA1486 {

	static List<Integer> clerkHeights;
	static int numOfClerks;
	static int destHeight;
	static int minHeightDiff;

	public static void dfs(int nowIndex, int sum) {
		if (nowIndex == numOfClerks) {
			if (sum - destHeight < 0) {
				return;
			} else {
				minHeightDiff = minHeightDiff > sum - destHeight ? sum - destHeight : minHeightDiff;
				return;
			}
		}
		sum += clerkHeights.get(nowIndex);
		dfs(nowIndex + 1, sum);
		sum -= clerkHeights.get(nowIndex);
		dfs(nowIndex + 1, sum);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCase = sc.nextInt();

		for (int testCase = 1; testCase <= totalCase; ++testCase) {
			minHeightDiff = 20_000;

			numOfClerks = sc.nextInt();
			destHeight = sc.nextInt();

			clerkHeights = new ArrayList<Integer>();
			for (int cnt = 0; cnt < numOfClerks; ++cnt) {
				clerkHeights.add(sc.nextInt());
			}

			// 조합?
			// 각 점원의 키를 더하는 경우, 더하지 않는 경우로 나누어 진다.
			// N명 반복 했을 때 더한 sum
			// sum - height 값의 최소값 찾기 (0이 최소)
			// 음수가 나오면 도달 하지 못한 것이므로 고려x
			// parameter - 현재 인덱스, 합
			// 그런데 이러면 2^20 = 1024 * 1024 대충 100만번... 시간이 되려나? 일단 해보자
			dfs(0, 0);
			System.out.println("#" + testCase + " " + minHeightDiff);

		}
	}
}
