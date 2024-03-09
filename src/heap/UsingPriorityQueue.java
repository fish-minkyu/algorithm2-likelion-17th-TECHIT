package heap;

import java.util.PriorityQueue;

// Java의 우선순위 큐를 사용해보자.
public class UsingPriorityQueue {
  private static class Person {
    String name;
    int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String[] args) {
    // mst, 최단거리를 구하는 알고리즘에서 우선순위 큐를 사용하면 편하고 빠르게 만들 수 있다.

    /* minHeap이 기본값(오름차순)
    PriorityQueue<Integer> intPQueue = new PriorityQueue<>();
    */

    // maxHeap (내림차순)
    PriorityQueue<Integer> intPQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    intPQueue.add(5);
    intPQueue.add(2);
    intPQueue.add(7);
    intPQueue.add(1);
    intPQueue.add(3);

    // poll: 데이터를 제거하고 반환한다.
    Integer min = intPQueue.poll();
    System.out.println(min);

    // peek: 다음 데이터가 무엇인지 확인한다.
    Integer peekMin = intPQueue.peek();
    System.out.println(peekMin);

    // Person 객체의 나이 기준 정렬
    PriorityQueue<Person> personPQueue =
      new PriorityQueue<>((p1, p2) -> p1.age - p2.age);
    personPQueue.add(new Person("Alex", 30));
    personPQueue.add(new Person("Brad", 25));
    personPQueue.add(new Person("Chad", 36));
    personPQueue.add(new Person("Dave", 22));

    System.out.println(personPQueue.poll().name); // Dave
    System.out.println(personPQueue.poll().name); // Brad
    System.out.println(personPQueue.poll().name); // Alex
  }
}
