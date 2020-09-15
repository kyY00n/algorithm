import sys
N = int(sys.stdin.readline())

members = {} #나이: "이름" 을 원소로 갖는 딕셔너리를 선언

for _ in range(N):
    year, name = sys.stdin.readline().split()
    year = int(year)
    if year not in members:
        members[year] = [name] #튜플이든 리스트든 상관없지?
    else:
        members[year].append(name)

for p in sorted(members.items()): #items()는 (키, 값) 쌍의 튜플을 반환한다.
    for n in p[1]:
        sys.stdout.write(str(p[0])+" "+n+"\n")
