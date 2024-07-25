package SWEA;

import java.util.Scanner;

// SWEA3307. 최장 증가 부분 수열 D3

/*
 * 주어진 두 수열의 최장 증가 부분 수열의 길이를 계산하는 프로그램
 * 수열의 최장 증가 부분 수열은
 * An의 부분 수열 Bk
 * b1 < b2 < ... < bk 이고
 * Ab1 <= Ab2 <= ... <= Abk 인 최대 k로 구성된 수열
 */

public class SWEA3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCase = sc.nextInt();
		
		for (int testCase = 1; testCase <= totalCase; ++testCase) {
			int size = sc.nextInt();
			
			int[] sequence = new int[size];
			int[] subSequenceLength = new int[size];
			
			for (int index = 0; index < size; ++index) {
				sequence[index] = sc.nextInt();
				// 부분 수열 값은 1로 초기화
				subSequenceLength[index] = 1;
			}
			
			// 같은 크기의 배열 하나 더 만들기
			// 이 배열에는 현재 인덱스까지 최대 부분 순열 길이 구해둠
			// 인덱스 0 부터 끝까지 순회하면
			// 현재 인덱스에서 시작해서 0번째 인덱스까지 순회
			// 만약 현재 인덱스의 값이 더 크다면 다음 부분 순열이 될 수 있음.
			// 그렇다면 모든 작은 값들의 부분 순열의 길이 + 1 중 최대값이
			// 나의 최대 부분 순열 길이가 된다
			
			for (int curIndex = 0; curIndex < size; ++curIndex) {
				for (int index = curIndex - 1; index >= 0; --index) {
					if (sequence[index] < sequence[curIndex]) {
						subSequenceLength[curIndex] = subSequenceLength[curIndex] < subSequenceLength[index] + 1 ? subSequenceLength[index] + 1 : subSequenceLength[curIndex];
					}
				}
			}
			
			// 그러면 subSequenceLength의 값중 최대값이 정답이 된다.
			int answer = 0;
			for (int index = 0; index < size; ++index) {
				answer = answer < subSequenceLength[index] ? subSequenceLength[index] : answer;
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
	}
}
