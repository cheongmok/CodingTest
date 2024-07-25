package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 18799. 평균의 평균 D4
/*
 * n개의 서로 다른 정수로 구성된 집합 S
 * 이 집합의 공집합이 아닌 부분집합은 총 2^n - 1가지
 * 각각의 부분집합마다 그 평균을 구한 뒤, 이 2^n-1개의 평균들의 평균을 구하는 프로그램
 */

public class SWEA18799 {
	
	static int size;
	static List<Integer> set;
	static double avgSum;
	static double subSetSize;
	
	static void dfs(int curIndex, int cnt, int sum) {
		// 종료 조건
		if (curIndex == size) {
			if (cnt == 0) { // 공집합 제외
				subSetSize--;
				return;
			}
			if (sum == 0) {
				//subSetSize--;
				return;
			}
			// avg 계산
			double avg = 1.0 * sum / cnt;
			avgSum += avg;
			return;
		}
		
		// 안넣는 경우
		dfs(curIndex+1, cnt, sum);
		// 넣는 경우
		sum += set.get(curIndex);
		dfs(curIndex+1, cnt+1, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalCase = sc.nextInt();
		for(int testCase = 1; testCase <= totalCase; ++testCase) {
			avgSum = 0;
			
			size = sc.nextInt();
			subSetSize = Math.pow(2, size);
			set = new ArrayList<>();
			for (int cnt = 0; cnt < size; ++cnt) {
				set.add(sc.nextInt());
			}
			
			// parameter - curIndex, cnt, sum
			// set의 모든 원소를 돌면서
			// 넣을지 안넣을지 재귀 호출
			// 끝에 도달 했다면 공집합을 제외한 모든 부분집합의 평균 계산
			dfs(0,0,0);
			
			double avg = avgSum / subSetSize;
			if (avg % 1 == 0.0) {
				System.out.printf("#%d %d\n", testCase, (int)avg);
			} else {
				System.out.printf("#%d %.20f\n", testCase, avg);
			}
		}
	}
}
