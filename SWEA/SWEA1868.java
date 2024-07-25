package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 1868 파핑 파핑 지뢰 찾기 D4
/*
 * 지뢰가 있을 수도 없을 수도
 * 지뢰가 없는 칸이라면 변이 맞닿아 있거나 꼭지점이 맞닿아 있는 최대 8칸에 대해 몇 개의 지뢰가 있는지가 0에서 8사이의 숫자로 클릭한 칸에 표시된다.
 * 만약 이 숫자가 0이라면 근처의 8방향에 지뢰가 없다는 것이 확정된 것이기 때문에 그 8방향의 칸도 자동으로 숫자를 표시해 준다.
 * 지뢰 * 없는 칸 . 클릭한 지뢰가 없는 칸을 'c'
 * 다른 모든 칸의 숫자들이 표시되려면 최소 몇 번의 클릭을 해야 하는지 구하는 프로그램
 */

public class SWEA1868 {

	static final int DELTA = 8;
	static final int[] deltaRow = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static final int[] deltaCol = { -1, 0, 1, -1, 1, -1, -0, 1 };

	static char[][] board;

	static class Position {
		int row;
		int col;

		Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static boolean findBomb(int row, int col) {

		for (int cnt = 0; cnt < DELTA; ++cnt) {
			int newRow = row + deltaRow[cnt];
			int newCol = col + deltaCol[cnt];

			if (newRow < 0)
				continue;
			if (newRow > board[0].length - 1)
				continue;
			if (newCol < 0)
				continue;
			if (newCol > board[0].length - 1)
				continue;

			if (board[newRow][newCol] == '*')
				return true;
		}
		return false;
	}

	public static void fillBoard(int row, int col) {
		Deque<Position> queue = new ArrayDeque<>();
		queue.addLast(new Position(row, col));

		while (queue.isEmpty() == false) {
			Position curPos = queue.getFirst();
			board[curPos.row][curPos.col] = 'd';
			queue.removeFirst();

			if (findBomb(curPos.row, curPos.col))
				continue;
			for (int cnt = 0; cnt < DELTA; ++cnt) {
				int newRow = curPos.row + deltaRow[cnt];
				int newCol = curPos.col + deltaCol[cnt];

				if (newRow < 0)
					continue;
				if (newRow > board[0].length - 1)
					continue;
				if (newCol < 0)
					continue;
				if (newCol > board[0].length - 1)
					continue;

				if (board[newRow][newCol] == 'd')
					continue;

				queue.addLast(new Position(newRow, newCol));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);

		int totalCase = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= totalCase; ++testCase) {
			int size = Integer.parseInt(br.readLine());

			board = new char[size][size];

			for (int row = 0; row < size; ++row) {
				String str = br.readLine();
				for (int col = 0; col < size; ++col) {
					board[row][col] = str.charAt(col);
				}
			}
			
			/*
			 * 1번 아이디어 0,0 부터 탐색 시작, 각 칸에서 지뢰인지 아닌지 확인한다 지뢰가 아니라면 맞닿은 8방향에 지뢰가 있는지 확인한다. 지뢰가
			 * 없다면 8방향으로 진행해 나가면서 숫자를 채운다. n-1,n-1 까지 완료 하면 다시 루프 진행 아직 숫자가 적혀 있지 않다면 클릭 횟수를
			 * 추가
			 */
			int click = 0;

			for (int row = 0; row < size; ++row) {
				for (int col = 0; col < size; ++col) {
					if (board[row][col] == '*' || board[row][col] == 'd') {
						continue;
					}

					if (findBomb(row, col) == true) {
						continue;
					}
					fillBoard(row, col);
					click++;
				}
			}

			for (int row = 0; row < size; ++row) {
				for (int col = 0; col < size; ++col) {
					if (board[row][col] == '.') {
						click++;
					}
				}
			}

			System.out.println("#" + testCase + " " + click);
		}
	}
}
