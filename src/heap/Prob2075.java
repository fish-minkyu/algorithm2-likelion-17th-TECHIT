package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// N번째 큰 수
// https://www.acmicpc.net/problem/2075
public class Prob2075 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    // 최솟값이 우선적으로 나오는 우선순위 큐
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    // 숫자를 입력받는다.
    for (int i = 0; i < n; i++) {
      String[] lineNums = reader.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        // 숫자를 우선순위 큐에 넣어준다.
        priorityQueue.offer(Integer.parseInt(lineNums[j]));
        // 만약 우선순위 큐의 크기가 n보다 커지면,
        if (priorityQueue.size() > n) {
          // 하나 빼서 n개로 유지한다.
          priorityQueue.poll();
        }
      }
    }
    System.out.println(priorityQueue.peek());
  }
}
// java에선 BufferedReader의 readLine()과 split이 입력 처리가 제일 빠르다.
// 최소 Heap으로 N번째 큰 수를 뽑는다고 하면, 우선순위 큐가 n개 이상 넘을 때
// 가장 작은 숫자는 버려서 n개를 유지해준다.
// 데이터를 다 넣은 후, n번째 큰 수는 우선순위 큐에서 가장 작은 수이므로
// poll 또는 peek를 해서 값을 구해준다.