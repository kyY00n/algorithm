dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ'] #오오 오오오오
a = input()
ret = 0
for j in range(len(a)):
    for i in dial:
        if a[j] in i: #파이썬은 이런것도 된다. in
            ret += dial.index(i)+3
print(ret)
