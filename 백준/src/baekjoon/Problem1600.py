import sys
from collections import deque

input = sys.stdin.readline
moves = [(1, 0), (-1, 0), (0, 1), (0, -1), (-1, 2), (-2, 1), (-1, -2), (-2, -1), (1, -2), (2, -1), (2, 1), (1, 2)]
K = int(input())
C, R = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(R)]
distance = [[[False for _ in range(K + 1)] for _ in range(C)] for _ in range(R)]

q = deque()
q.append((0, 0, 0, 0))
distance[0][0][0] = True
while q:
    cur = q.popleft()
    cr = cur[0]
    cc = cur[1]
    ck = cur[2]
    cm = cur[3]

    if cr == R - 1 and cc == C -1:
        print(cm)
        exit(0)

    for i in range(12):
        nr = cr + moves[i][0]
        nc = cc + moves[i][1]

        if nr < 0 or nc < 0 or nr >= R or nc >= C:
            continue

        if map[nr][nc] == 1:
            continue

        if i < 4:
            if distance[nr][nc][ck]:
                continue

            distance[nr][nc][ck] = True
            q.append((nr, nc, ck, cm + 1))
            continue

        if ck < K:
            if distance[nr][nc][ck + 1]:
                continue

            distance[nr][nc][ck + 1] = True
            q.append((nr, nc, ck + 1, cm + 1))
print(-1)
