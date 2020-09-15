a = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
alpha = input()

for t in a:
    alpha = alpha.replace(t, '*') #하나의 문자를 다 별로 바꿔버림!

print(len(alpha))
