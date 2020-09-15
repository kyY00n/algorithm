#한수: 각 자릿 수가 등차수열을 이루는 수

N = int(input())
if N<100:
    print(N)

else:
    cnt = 99
    for i in range(100, N+1):
        nums = list(map(int, str(i))) #문자열 리스트로 바꾼 다음에 int로 바꿔주고 다시 그걸 리스트로 만듦.
        if nums[0]-nums[1] == nums[1]-nums[2] :
            cnt += 1
    print(cnt)