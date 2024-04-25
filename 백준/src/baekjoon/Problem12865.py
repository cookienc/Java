import sys

input = sys.stdin.readline

N, K = map(int, input().split())
items = [list(map(int, input().split())) for _ in range(N)]
items.append([0, 0])
items.sort()

dp = [[0] * (N + 1) for _ in range(K + 1)]

for c in range(1, N + 1):
    w, v = items[c]
    for r in range(1, K + 1):
        if w <= r:
            dp[r][c] = max(dp[r][c - 1], dp[r - w][c - 1] + v)
        else:
            dp[r][c] = dp[r][c - 1]

print(dp[K][N])

