import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = [[0 for _ in range(M + 1)]] + [[0] + list(map(int, input().split())) for _ in range(N)]

for r in range(1, N + 1):
    for c in range(1, M + 1):
        arr[r][c] += arr[r][c - 1]

for c in range(1, M + 1):
    for r in range(1, N + 1):
        arr[r][c] += arr[r - 1][c]

answer = -sys.maxsize
for r1 in range(1, N + 1):
    for c1 in range(1, M + 1):
        for r2 in range(r1, N + 1):
            for c2 in range(c1, M + 1):
                tmp = arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1]
                answer = max(answer, tmp)

print(answer)
