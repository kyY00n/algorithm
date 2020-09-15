N, M, K = map(int, input().split())

frontX = N-M

bothO = K if M > K else M #더 작은 수만큼 O가 겹친다.

#10 6 4이면 둘다 O는 4, 둘다 x는 4
n = K if M < K else M
bothX = N - n

print(bothO+bothX)