package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 거스름돈
// https://www.acmicpc.net/problem/14916
public class boj14916 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 거스름돈
    int chanage = Integer.parseInt(reader.readLine());

    // 거슬러 줄 수 없는 경우(1, 3)
    if (chanage == 1 || chanage == 3) System.out.println(-1);
    // 5짜리로 다 거슬러 주면 짝수 금액이 남는 경우
    else if ((chanage % 5) % 2 == 0) {
      // 5짜리로 쓸 수 있는 만큼
      int fives = chanage / 5;
      // 남은 걸 2로
      int twos = (chanage % 5) / 2;
      System.out.println(fives + twos);
    }
    // 5짜리로 다 거슬러 주면 홀수 금액이 남는 경우
    else {
      // 5짜리로 쓸 수 있는 만큼 -1(헤야 남는 돈을 2원으로 거스룰 수 있음)
      int fives = chanage / 5 -1;
      // 남은걸 2로
      int twos = ((chanage % 5) + 5) / 2;
      System.out.println(fives + twos);
    }
  }
}
