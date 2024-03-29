import sys

input = sys.stdin.readline

n, k = map(int, input().split())

s = k * (k + 1) // 2

if s > n:
    print(-1)
    exit(0)

rest = n - s

if rest == 0:
    print(k - 1)
    exit(0)

rest %= k
if rest == 0:
    print(k - 1)
else:
    print(k)
