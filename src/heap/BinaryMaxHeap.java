package heap;

// Heap이 어떻게 동작하는지 이해하기 위한 코드
public class BinaryMaxHeap {
  private int[] heap;
  // 데이터 총 크기
  private int size;

  public BinaryMaxHeap() {
    heap = new int[32];
    size = 0;
  }

  public void insert(int item) {
    if (size == heap.length) {
      throw new RuntimeException("Heap is full");
    }

    // 제일 끝에 데이터를 넣어준다.
    heap[size] = item;
    // 해당 데이터를 부모와 비교해가며 힙의 조건을 만족시키게 만든다.
    siftUp(size);
    // 다음에 데이터가 들어갈 위치를 갱신한다.
    size++;
  }

  // siftUp
  // : 아래쪽에 있는 원소를 부모 원소와 비교해서 올릴지 말지 결정하는 메서드
  private void siftUp(int index) {
    // 루트가 아닌 동안
    while (index > 0) {
      int parentIndex = (index -1) / 2; // index가 0으로 시작하니 -1을 해준다.

      // 부모보다 자식이 더 작거나 같다.
      if (heap[index] <= heap[parentIndex]) {
        // 더 작업 필요 없음
        break;
      }
      // 부모보다 자식이 더 크다
      else {
        // 부모와 자식을 교환한다.
        int temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
        // 다음에는 부모 index에서 확인한다.
        index = parentIndex;
      }
    }
  }

  public int remove() {
    if (size == 0) {
      throw new RuntimeException("Heap is empty");
    }

    // 돌려줄 데이터 준비
    int root = heap[0];
    // 루트에 제일 끝의 데이터 넣어주기
    heap[0] = heap[size - 1];
    size--; // 마지막 데이터가 더 이상 heap의 영역이 아니다.

    // 바뀐 root를 자식들과 비교한다.
    siftDown(0);

    return root;
  }

  private void siftDown(int index) {
    // 비교 노드들이 Heap의 내부에 존재할때까지 반복
    while (index < size) {
      // 왼쪽 자식 index
      int leftChild = 2 * index + 1;  // 루트가 0이므로 2 * 0 + 1 = 1이니 왼쪽 자식을 가리킨다.
      // 오른쪽 자식 index
      int rightChild = 2 * index + 2;
      // 최종적으로 최대값을 비교하기 위한 index
      int largest = index;

      if (
        // 왼쪽 자식이 존재하고,
        leftChild < size &&
          // 왼쪽 자식이 부모보다 크다
          heap[leftChild] > heap[largest]
      ) largest = leftChild;

      if (
        // 오른쪽 자식이 존재하고,
        rightChild < size &&
          // 오른쪽 자식이 왼쪽 + 부모 보다 크다
          heap[rightChild] > heap[largest]
      ) largest = rightChild;

      // 제일 큰 노드가 부모였다.
      if (largest == index) {
        break;
      }

      // 제일 큰 자식과 부모를 교체한다.
      int temp = heap[index];
      heap[index] = heap[largest];
      heap[largest] = temp;
      index = largest;
    }
  }

  public static void main(String[] args) {
    BinaryMaxHeap maxHeap = new BinaryMaxHeap();
    for (int i = 1; i < 17; i++) {
      maxHeap.insert(i);
    }

    for (int i = 0; i< 16; i++) {
      System.out.print(maxHeap.remove() + ", ");
    }
  }
}
// 부등호만 바꾸면 maxHeap이 minHeap으로 바뀌게 된다.