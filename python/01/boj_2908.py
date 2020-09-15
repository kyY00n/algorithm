n1, n2 = map(int, input().split())

ss1 = (n1%10)*100 + int(n1/10)%10*10 + int(n1/100)
ss2 = (n2%10)*100 + int(n2/10)%10*10 + int(n2/100)

print(max(ss1, ss2))


