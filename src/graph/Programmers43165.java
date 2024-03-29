package graph;

import java.util.LinkedList;
import java.util.Queue;

// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// => 재귀함수 DFS로 풀기(BFS로도 풀 수가 있다. 하지만 효율적이지 않음)
public class Programmers43165 {
  private int answer = 0;

  // dfs 재귀함수 풀이
  private void dfs(
    // 부호를 정해야 하는 숫자들
    int[] numbers,
    // 만들고자 하는 숫자
    int target,
    // 다음에 고려해봐야 하는 숫자
    int next,
    // 여태까지 합한 숫자
    int sum
  ) {
    // 모든 숫자를 고려했으면
    if (next == numbers.length) {
      // 타겟넘버인지 확인한다.
      if (sum == target) this.answer++;
    }
    else {
      // 이번 숫자는 더하고 다음 숫자를 결정하자
      dfs(numbers, target, next + 1, sum + numbers[next]);
      // 이번 숫자는 빼고 다음 숫자를 결정하자
      dfs(numbers, target, next + 1, sum - numbers[next]);
    }
  }

  private void bfs(int[] numbers, int target) {
    // 다음에 시도해볼 조합
    Queue<int[]> toTry = new LinkedList<>();
    // 다음에 시도해볼 숫자: numbers[0], 여태까지 숫자의 합: 0
    toTry.offer(new int[]{0, 0});
    // BFS 시작
    while (!toTry.isEmpty()) {
      // 이번에 살펴볼 상태
      int[] nextTry = toTry.poll();
      int next = nextTry[0];
      int sum = nextTry[1];
      // 모든 숫자를 고려했다면,
      if (next == numbers.length) {
        // 총합이 타겟 넘버일 경우 기록
        if (sum == target) this.answer++;
      }
      // 아니라면 다음 숫자를 고려한다.
      else {
        // 이번 숫자는 더한다.
        toTry.offer(new int[]{next + 1, sum + numbers[next]});
        // 이번 숫자는 뺀다.
        toTry.offer(new int[]{next + 1, sum - numbers[next]});
      }
    }
  }

  public int solution(int[] numbers, int target) {
    dfs(numbers, target, 0, 0);
//    bfs(numbers, target);
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new Programmers43165().solution(new int[]{1, 1, 1, 1, 1}, 3));
  }
}
