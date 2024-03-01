import sys

input = sys.stdin.readline

N = int(input())
bridges = [0] + list(map(int, input().split()))
dp = [sys.maxsize] * (N + 1)
dp[1] = 0

for i in range(2, N + 1):
    for j in range(1, i + 1):
        dp[i] = min(dp[i], max(dp[j], ((i - j) * (1 + abs(bridges[i] - bridges[j])))))
print(dp[-1])
