package BOJ;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 백준 2206번 벽 부수고 이동하기.

/*
 * NxM의 행렬로 표현된 맵
 * 0은 이동할 수 있는 곳 1은 이동할 수 없는 벽
 * (1,1)에서 (N,M)의 위치까지 이동하려 함
 * 최단경로 시작하는 칸과 끝나는 칸도 포함
 * 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸
 * 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 가능
 */

public class BOJ2206 {

	static int[][] map;
	static boolean[][][] visited;

	static class Path {
		int row;
		int col;
		int path;
		int brokenWall;

		public Path(int row, int col, int path, int brokenWall) {
			this.row = row;
			this.col = col;
			this.path = path;
			this.brokenWall = brokenWall;
		}
	}

	static int bfs(int rowSize, int colSize) {
		int[] deltaRow = { 1, -1, 0, 0 };
		int[] deltaCol = { 0, 0, 1, -1 };

		Deque<Path> queue = new ArrayDeque<>();
		queue.add(new Path(1, 1, 1, 0));
		visited[1][1][0] = true;
		int answer = 1_000_000;

		while (!queue.isEmpty()) {
			Path curPath = queue.pollFirst();
			if (curPath.row == rowSize && curPath.col == colSize) {
				answer = curPath.path > answer ? answer : curPath.path;
				break;
			}

			for (int cnt = 0; cnt < 4; ++cnt) {
				int newRow = curPath.row + deltaRow[cnt];
				int newCol = curPath.col + deltaCol[cnt];
				int brokenWall = curPath.brokenWall;
				int path = curPath.path;

				// 바운더리 체크
				if (newRow < 1)
					continue;
				if (newRow > rowSize)
					continue;
				if (newCol < 1)
					continue;
				if (newCol > colSize)
					continue;

				// 이미 지난 길인지 체크
				if (visited[newRow][newCol][brokenWall] == true)
					continue;

				// 벽인지 체크
				if (map[newRow][newCol] == 1) {
					brokenWall++;
					// 2번째 벽에 충돌이면 뺌
					if (brokenWall > 1) {
						continue;
					}
				}

				// 괜찮다면 큐에 넣기
				visited[newRow][newCol][brokenWall] = true;
				path++;
				queue.add(new Path(newRow, newCol, path, brokenWall));
			}
		}

		if (visited[rowSize][colSize][0] == true || visited[rowSize][colSize][1] == true) {
			return answer;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rowSize = sc.nextInt();
		int colSize = sc.nextInt();

		map = new int[rowSize + 1][colSize + 1];
		visited = new boolean[rowSize + 1][colSize + 1][2];
		for (int row = 1; row <= rowSize; ++row) {
			String input = sc.next();
			for (int col = 1; col <= colSize; ++col) {
				map[row][col] = input.charAt(col - 1) - '0';
			}
		}

		System.out.println(bfs(rowSize, colSize));

		// 최단 거리를 찾기 위한 bfs
		// 이동하면서 내가 벽을 몇 번 부셨는지를 확인
		// 1번까지는 가능
		// 2번 부신 경로는 버린다

	}
}
