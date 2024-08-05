package SWEA;

import java.util.Scanner;

// SWEA20552. XOR과 합

/*
 * 모든 원소를 XOR한 값이 X, 모든 원소의 합이 S인 음이 아닌 정수로 구성된 배열 A가 존재하는지 판단
 * 존재한다면 그 중 길이가 가장 짧은 것을 하나 출력
 * 길이가 0인 배열의 합과 XOR은 모두 0
 * 길이가 1인 배열의 합과 XOR은 유일한 원소와 같다.
 */

public class SWEA20552 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalCase = scanner.nextInt();
		
		// 0 <= x, s <= 10^18
		long numXOR = scanner.nextLong();
		long numSum = scanner.nextLong();
		
		// xor 같으면 0 다르면 1
		// numXOR - 0010 -> 0001 xor 0011
		// numSum - 0100 -> 0001 + 0011
		// 모든 원소를 xor 해서 numXOR이 되려면
		// numXOR의 비트에서 1이면 1이 홀수번, 0이면 1이 짝수번(0포함) 나와야 함.
		// 
	}
}
