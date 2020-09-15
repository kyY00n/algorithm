"""
소수찾기: 주어진 수 N개 중에서 소수가 몇 개인지 출력하는 프로그램을 작성하시오.
입력: 첫 줄에 수의 개수 N(N <= 100)이 주어진다. 다음 줄에 N개의 수가 주어진다. (1000이하)
"""
N = int(input())
nums = list(map(int, input().split()))
cnt = len(nums)

if N == cnt: # 헐 ^_^... 테스트 케이스와 입력 수가 같은지 확인 해야 정답입니다.
    for i in nums:
        if i == 1:
            cnt -= 1
        for j in range(2, i):
            if i % j == 0:
                cnt -= 1
                break
    print(cnt)

