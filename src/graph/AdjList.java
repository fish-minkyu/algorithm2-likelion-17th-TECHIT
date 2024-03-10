package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 인접 리스트
public class AdjList {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] info = reader.readLine().split(" ");
    int nodes = Integer.parseInt(info[0]);
    int edges = Integer.parseInt(info[1]);

    // 인접 리스트: 각 정점이 도달할 수 있는 정점들을 리스트로 저장하는 방식
    List<List<Integer>> adjList = new ArrayList<>();
    // 내부에 빈 리스트를 먼저 만들어준다.(초기화를 해주지 않으면 null이 들어갈 수 있다.)
    for (int i = 0; i < nodes; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < edges; i++) {
      // 간선의 정보를 입력받는다.
      String[] edgeInfo = reader.readLine().split(" ");
      int leftNode = Integer.parseInt(edgeInfo[0]);
      int rightNode = Integer.parseInt(edgeInfo[1]);
      adjList.get(leftNode).add(rightNode);
      adjList.get(rightNode).add(leftNode);
    }

    // 결과를 출력해보자.
    for (int i = 0; i < nodes; i++) {
      System.out.println(String.format("%d: %s", i, adjList.get(i)));
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