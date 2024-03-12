package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2667
public class boj2667 {
  private static final int[] dy = {-1, 1, 0, 0};
  private static final int[] dx = {0, 0, -1, 1};
  private static int n;
  private static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(reader.readLine());
    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      String line = reader.readLine();
      for (int j = 0; j < n; j++) {
        char col = line.charAt(j);
        map[i][j] = col - '0';
      }
    }

    // 모든 집이 있을 수 있는 지도의 칸을 반복해서 방문하는데,
    // 만약 해당하는 칸에 집이 있을 경우,
    // 해당 칸을 시작점으로 BFS 또는 DFS를 한다.
    // 그리고 그 과정에서 방문할 수 있었던 집의 갯수를 반환하고,
    // 1이었던 해당하는 칸을 방문하면서 0으로 바꿔준다.

    // todo BFS를 하면서 몇개의 칸을 돌았는지 반환하고 여기 스코프에 저장
  }

  // y, x를 시작점으로 BFS를 하고 최종적으로 방문한 집의 갯수를
  // 반환하는 메서드
  private static int bfs(int y, int x) {
    // 강사님은 visited 배열을 만들지 않았음
    // maze에서 한 걸 잘 살펴보고 bfs 냐부에다가 넣어주면 됨
    return 1;
  }
}
