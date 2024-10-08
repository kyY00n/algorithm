# BOJ 1256. 사전

[See problem](https://www.acmicpc.net/problem/1256)

## Constraints

- Input:
    - 첫째 줄에 세 정수 N, M, K가 순서대로 주어진다.
    - 1 ≤ N, M ≤ 100 
    - 1 ≤ K ≤ 1,000,000,000
- Time limit: 2초

## Approach
<!-- Describe your approach to solving the problem. -->

조합을 이용할 수 있다.
그리고 a와 z를 숫자라고 생각하면, a를 0, z를 1라고 할 수 있는데
이는 K번째 문자열이 뭔지 구하기 위해서 가장 작은 값을 이진수로 치환해보면 다음 문제로 바꿔 생각할 수 있다.

M개의 1로 만들 수 있는 숫자 -> 1개
1개의 0과 M개의 1로 만들 수 있는 숫자 -> m+1C1 개
2개의 0과 M개의 1로 만들 수 있는 숫자 -> m+2C2 개
3개의 0과 M개의 1로 만들 수 있는 숫자 -> m+3C3 개
...
N개의 0과 M개의 1로 만들 수 있는 숫자 -> m+nCn 개 tada!

그래서, m+nCn >= K인 최소 n을 찾아서 0과 1을 채워넣으면 된다.

```java
// 마지막 문자열을 만드는 for 문 안에서
if (dp[a + z - 1][z] >= K) {
    sb.append("a");
    a--;
} else {
    sb.append("z");
    K -= dp[a + z - 1][z];
    z--;
}
```
`dp[a + z - 1][z] >= K`는 현재 남아있는 'a'와 'z'로 만들 수 있는 문자열 중에서, 앞에 'a'를 붙인 문자열의 개수가 K보다 크거나 같다는 것을 의미한다.


## Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $O(n)$ -->

$$
O(N+M)
$$

- Space complexity:
<!-- Add your space complexity here, e.g. $O(n)$ -->

$$
O((M + N) \times N)
$$

## Trial and Error


