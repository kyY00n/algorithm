a = [0]*42

count = 0

for i in range(10):
    n = int(input()) % 42
    if a[n] == 0:
        a[n] = 1
        count += 1

print(count)
    
    