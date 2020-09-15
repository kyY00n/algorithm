S = input()

alphaCnt = [-1]*26
for i in range(len(S)):
    idx = ord(S[i]) - ord('a')
    if alphaCnt[idx] == -1:
        alphaCnt[idx] = i

for j in alphaCnt:
    print(j, end=' ')