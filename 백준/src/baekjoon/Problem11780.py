import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
M = int(input())
INF = sys.maxsize
area = [[INF for _ in range(N + 1)] for _ in range(N + 1)]
nxt = [[-1 for _ in range(N + 1)] for _ in range(N + 1)]
for _ in range(M):
    a, b, c = map(int, input().split())
    if area[a][b] > c:
        area[a][b] = c
        nxt[a][b] = b

for i in range(1, N + 1):
    area[i][i] = 0

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if area[i][k] + area[k][j] < area[i][j]:
                area[i][j] = area[i][k] + area[k][j]
                nxt[i][j] = nxt[i][k]

for i in range(1, N + 1):
    print(' '.join(str(num) if num <= 1e+7 else str(0) for num in area[i][1:]))

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j or nxt[i][j] == -1:
            print(0)
            continue

        q = deque()
        st = i
        while st != j:
            q.append(st)
            st = nxt[st][j]
        q.append(j)
        print(len(q), end=' ')
        print(' '.join(map(str, q)))
