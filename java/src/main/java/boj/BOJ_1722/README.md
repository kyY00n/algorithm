## BOJ 1722. 순열의 순서 구하기

[문제 보기](https://www.acmicpc.net/problem/1722)


### 문제 분석

- input:
    - 첫째 줄에 N(1 ≤ N ≤ 20)이 주어진다.
    - 둘째 줄의 첫 번째 수는 소문제 번호이다. 1인 경우 k(1 ≤ k ≤ N!)를 입력받고, 2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다.
    - N개의 수에는 1부터 N까지의 정수가 한 번씩만 나타난다.
- 시간 제한: 2초


### 핵심 아이디어

순열의 특성을 이용해서 풀 수 있었다.
각 자리마다 순열의 값을 미리 계산해서 factorial 배열에 저장해둘 수 있었다.


### 기록해 둘 이야기 (헷갈렸던 것, 모르겠는 것)

N의 범위가 1부터 20까지인데, factorial 을 저장하는 배열의 타입을 int로 해두어서, 20 처럼 큰 수가 들어가면 factorial 계산 시 타입 범위를 벗어나 음수가 되고 제대로 값이 저장되지 못한다는 사실을 디버깅하면서 알게됐다.

그리고 굉장히 문제가 헷갈렸는데 패드로 수도 코드를 작성하고 나서 하니 조금 수월했다. ide 의 도움도 많이 받았던게, 나는 while loop 사용이 서툴어서 loop 안에서 변수를 재할당하는데 해당 변수가 쓰이지 않는 코드라던가.. 하면 하이라이팅을 해주지 않아서 금방 고칠 수 있었다.
반대로 말하면 ide가 없는 경우에 그런 경우를 잘 파악하지 못하는 약점이 있다는 것이다.

> 다시 봐도 헷갈린다.

```java
private static void printK(int[] sequence) {
    int digit = N;
    List<Integer> numbers = IntStream.range(1, N + 1)
            .boxed()
            .collect(Collectors.toList());

    long k = 1; // initialize k to 1 for counting last permutation
    while (digit > 0) {
        for (Integer i : numbers) {
            if (sequence[N - digit] == i) {
                digit--;
                numbers.remove(i);
                break;
            }
            k += factorial[digit - 1];
        }
    }
    System.out.println(k);
}
```

또한 책에 있는 풀이에서는 다음과 같이 사용할 수 있는 숫자를 별도 자료구조에서 직접관리하는게 아니라 (나는 List 로 사용하지 않은 숫자 관리) visited 배열을 사용해서 사용 유무를 체크하는 방식을 사용했다.

```java
int[] visited = new visited[N+1];

// 중략 ..

for(int i = 1; i < N+1; i++) {
    if (visited[i]) {
        continue;
    }
    // 중략..
}
```

이런식으로 하면 관리가 아주 편하고 내가 사용한 방식에서의 요소 삭제 시간이 아주 빠르게 단축된다.
List의 remove 메서드 시간복잡도: $O(N)$
visited 요소 변경 시가복잡도: $O(1)$
