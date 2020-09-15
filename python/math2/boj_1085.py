x, y, w, h = map(int, input().split())

w = w - x
h = h - y

print(min(x, y, w, h))
