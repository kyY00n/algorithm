N = int(input())

for i in range(N):
    sum = count = 0
    s = input()

    for j in range(len(s)):
        if s[j] == 'O':
            count += 1
            sum += count
        else:
            count = 0
    """
    여기 for문도 이제 이렇게 써줄 수 있겠지
    
    for j in s:
        if j =='O':
            count+=1
            ...
    
    """
    
    print(sum)
    