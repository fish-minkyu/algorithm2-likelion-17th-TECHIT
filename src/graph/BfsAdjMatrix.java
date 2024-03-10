package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsAdjMatrix {
  public static void bfsAdjMatrix() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] info = reader.readLine().split(" ");
    int nodes = Integer.parseInt(info[0]);
    int edges = Integer.parseInt(info[1]);
    // 인접행렬: 정점들의 갯수를 n이라고 하면 n * n 2차원 배열로 그래프의 연결 관계를 표현하는 방법
    int[][] adjMat = new int[nodes][nodes];
    // 간선의 갯수만큼 반복해서
    for (int i = 0; i < edges; i++) {
      // 간선의 정보를 받는다.
      String[] edgeInfo = reader.readLine().split(" ");
      // 연결된 두 정점을 찾는다.
      int leftNode = Integer.parseInt(edgeInfo[0]);
      int rightNode = Integer.parseInt(edgeInfo[1]);
      // 인접 행렬에 인접했다고 기록한다.
      adjMat[leftNode][rightNode] = 1;
      adjMat[rightNode][leftNode] = 1;
    }

    // DFS에서 사용하던 Stack 대신 Queue를 사용한다.
    Queue<Integer> toVisit = new LinkedList<>();
    List<Integer> visitedOrder = new ArrayList<>();
    // 방문한 정보를 저장한다.
    boolean[] visited = new boolean[nodes];
    // 첫 방문 대상은 0
    toVisit.add(0);
    // 큐가 빌때까지 반복한다.
    while (!toVisit.isEmpty()) {
      // 이번에 방문할 곳을 받아온다.
      int next = toVisit.poll();
      // 만약 방문했다면 스킵
      if (visited[next]) continue;

      // 방문했다고 표시한다.
      visited[next] = true;
      visitedOrder.add(next);

      // 다음 방문할 정점을 확인한다.
      for (int i = 0; i < nodes; i++) {
        if (adjMat[next][i] == 1 && !visited[i]) {
          toVisit.offer(i);
        }
      }
    }

    System.out.println(visitedOrder);
  }

  public static void main(String[] args) throws IOException {
    bfsAdjMatrix();
  }
}
