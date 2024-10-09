# BOJ 1947. 선물 전달

[See problem](https://www.acmicpc.net/problem/1947)

## Constraints

- Input:
    - 첫째 줄에 ACM-ICPC 대회에 참가한 학생의 수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
- Time limit: 2초

## Approach
<!-- Describe your approach to solving the problem. -->

선물을 교환하는 전체 경우의 수를 구하는 방법을 간단하게 하기 위해서,
우선 N 명 중 두 명을 A, B 라고 하고 A가 B에게 선물을 주는 경우의 수를 생각해볼 수 있다. 그리고 나서 A가 선물을 줄 사람을 바꿀 수 있다고 생각하면 부분 문제로 나눠 생각할 수 있다. (확률의 곱셈)

1. A가 B에게 선물을 주는 경우의 수: 이 때는 두 가지 경우로 나눠볼 수 있다. B도 A에게 선물을 주는 경우와, B는 다른 사람에게 선물을 주는 경우다.
   - B도 A에게 선물을 주는 경우: A와 B의 선물이 정해지니, 이 2명을 뺀 나머지 N-2명이 선물을 나누는 경우의 수와 같다.
   - B는 다른 사람에게 주는 경우: B만 선물이 정해지니, B만 뺀 나머지 N-1명이 선물을 나누는 경우의 수와 같다.
   - 따라서 A가 B에게 선물을 주는 경우의 수를 $S_n$ 이라고 하면, $S_n = S_{n-1} + S_{n-2}$가 된다.
2. 그리고 A가 선물을 줄 사람을 N-1 명 중에 고를 수 있다. 이 경우의 수는 말그대로 N-1 이다.
3. 따라서 N 명이 선물을 나눠 가지는 수를 `D[N]` 이라고 하면 점화식을 다음과 같이 세울 수 있다.
   ```java
    D[N] = (D[N-1] + D[N-2]) * (N-1)
    ```

## Complexity
- Time complexity: $O(N)$
<!-- Add your time complexity here, e.g. $O(n)$ -->



- Space complexity: $O(N)$
<!-- Add your space complexity here, e.g. $O(n)$ -->


## Trial and Error

boj 이상하다.
왜 배열의 크기를 동적으로 할당하면 런타임에러가 날까? 저번에도 이런 문제가 있어서 동일하게 최대 크기를 할당했더니 문제가 해결됐다. 

```java
int[] dp = new int[N + 1]; // 런타임 에러(ArrayIndexOutOfBounds)
int[] dp = new int[1_000_000 + 1]; // accepted
```
