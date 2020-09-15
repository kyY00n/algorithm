natural_number_set = set(range(1, 10001))
generated_number_set= set()

#d(n)을 계산해서 모아 놓고(generated_number_set) 전체(natural_nuber_set)에서 빼줌 - '에라토스테네스의 체' 응용

for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    generated_number_set.add(i)

self_number_set = natural_number_set - generated_number_set

for i in sorted(self_number_set):
    print(i)