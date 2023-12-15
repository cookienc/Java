a, b = map(int, input().split())

n = max(a, b)
m = min(a, b)

print(n - 1 + (m - 1) * n)
