package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 인접 행렬(무향 그래프) 만들기
public class AdjMatrix {
  public static void main(String[] args) throws IOException {
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
      adjMat[rightNode][leftNode] = 1; // 유향 그래프는 해당 라인을 주석처리하면 된다.
    }

    // 결과를 출력해보자.
    for (int i = 0; i < nodes; i++) {
      System.out.println(Arrays.toString(adjMat[i]));
    }
  }
}
/*
입력 예제
8 10
0 1
0 2
0 3
1 3
1 4
2 5
3 4
4 7
5 6
6 7
*/