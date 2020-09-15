N = int(input())
cnt = 0

for i in range(N):
    alpha = [0] * 26
    cmp = '*'
    s = input()
    for j in s:
        if cmp != j: #앞의 알파벳 != 현재 알파벳
            if alpha[ord(j)-ord('a')] == 1:
                N -= 1
                break
            else:
                alpha[ord(j)-ord('a')] = 1
            cmp = j

print(N)

""" 대박
result = int(input())
for _ in range(result):
    word = input()
    for i in range(1, len(word)):
        if word.find(word[i-1]) > word.find(word[i]): #find()는 제일 처음 등장하는 인덱스를 반환한다.
            result -= 1
            break
print(result)
"""