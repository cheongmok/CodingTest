package SWEA;

import java.util.Scanner;

// SWEA 20731. 서로소 그리드 D4

/*
 * NxN 크기의 격자판
 * 격자판의 각 칸에는 '1' 또는 '?'
 * 음이 아닌 정수 k를 정한다.
 * 격자판의 i행 j열에는 gcd(i+K,j+K) = 1이면 '1'이 적혀 있고, 그렇지 않다면 '?'이 적혀 있다.
 * 이 격자판이 위의 과정을 거쳐 만들어졌을 가능성이 있는지 판단하는 프로그램
 */

// 유클리드 호제법
// a를 b로 나눈 나머지를 r이라고 할 때 (단 a > b)
// a와 b의 최대공약수는 b와 r의 최대 공약수와 같다.

//GCD(A, B) = GCD(B, A%B)
//if A%B = 0 -> GCD = B
//    else GCD(B, A%B)


public class SWEA20731 {
	
	// 유클리드 호제법
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCase = sc.nextInt();
		
		for (int testCase = 1; testCase <= totalCase; ++testCase) {
			int size = sc.nextInt();
			
			char[][] board = new char[size][size];
			
			for (int row = 0; row < size; ++row) {
				String input = sc.next();
				for (int col = 0; col < size; ++col) {
					board[row][col] = input.charAt(col);
				}
			}
			
			// gcd(i + k, j + k) = 1 이면 1 아니면 ?
			// 를 만족하는 k가 있느냐??
			// 단순 생각 -> 모든 원소를 돌면서 gcd를 돌려본다
			// 결과가 같다면 okay
			// --> c++로 풀었을때도 1000개를 다 해본거라 모르겠따....
//			for (int k = 1)
		}
	}

}
