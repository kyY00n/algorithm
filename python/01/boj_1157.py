s = input().lower() #입력 문자열을 모두 소문자로 바꿉니다

alphaCnt = [0]*26
max = 0
for i in s:
    idx = ord(i)-ord('a') #아스키코드를 이용해서 a~z(0~25) 해당하는 인덱스 구하기
    alphaCnt[idx] += 1

    if max < alphaCnt[idx]:
        max = alphaCnt[idx]
        maxAlpha = chr( ord('A') + idx ) #아스키코드를 이용해서 대문자로 바꿔서 결과를 저장합니다

    elif max == alphaCnt[idx]:
        maxAlpha = '?'

print(maxAlpha)

""" 모범답안 >_<

words = input().lower()
words_list = list(set(words)) ->딱 보면 존재하는 알파벳만을 추려서 (set메서드) 리스트에 저장했당.
word_count = list() ->리스트 생성하는거넹

for i in words_list:
    count = words.count(i)
    word_count.append(count)

if(word_count.count(max(word_count)) >= 2):
    print('?')
else:
    print(words_list[(word_count.index(max(word_count)))].upper())

"""