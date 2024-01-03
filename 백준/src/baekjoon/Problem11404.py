import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
INF = sys.maxsize

area = [[INF for _ in range(N + 1)] for _ in range(N + 1)]
for _ in range(M):
    a, b, c = map(int, input().split())
    area[a][b] = min(area[a][b], c)

for i in range(1, N + 1):
    area[i][i] = 0

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if area[i][k] + area[k][j] < area[i][j]:
                area[i][j] = area[i][k] + area[k][j]

for r in range(1, N + 1):
    for c in range(1, N + 1):
        element = area[r][c]
        if element == sys.maxsize:
            print(0, end=' ')
        else:
            print(element, end=' ')
    print()
