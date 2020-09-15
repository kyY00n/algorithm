#단어 정렬
import sys

N = int(sys.stdin.readline())

wordLen = {}
for _ in range(N):
    newWord = sys.stdin.readline()
    if len(newWord) in wordLen:
        if newWord not in wordLen[len(newWord)]:
            wordLen[len(newWord)].append(newWord)
    else:
        wordLen[len(newWord)] = [newWord]

sortedKeys = sorted(wordLen.keys())

for k in sortedKeys:
    wordLen[k].sort()
    for w in wordLen[k]:
        sys.stdout.write(w)
sys.stdout.flush()

"""
voca_list = []
for i in range(int(input())):               # 테스트케이스 수 입력
    voca_list.append(input())               # 입력하는 단어를 리스트로 저장
 
set_voca_list = list(set(voca_list))        # 리스트의 중복 제거
 
sort_voca_list = []
 
for j in set_voca_list:
    sort_voca_list.append((len(j), j))      # 단어의 길이와 단어를 같이 리스트화 시켜 저장
 
sort_voca_list.sort()                       # sort()는 len(j), j 에서 앞을 먼저 정렬후에 앞의 조건이 일치하면 뒤를 정렬한다!!!!!!
 
for len_voca, voca in sort_voca_list:       # 리스트를 순환시켜 순서대로 출력
    print(voca)
"""