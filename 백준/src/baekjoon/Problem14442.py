import sys
from collections import deque

moves = [(0, 1), (0, -1), (1, 0), (-1, 0)]
input = sys.stdin.readline

R, C, K = map(int, input().split())
map_ = [list(map(int, input().strip('\n'))) for _ in range(R)]
distances = [[[R * C for _ in range(K + 1)] for _ in range(C)] for _ in range(R)]

q = deque()
q.append((0, 0, 0, 0))
distances[0][0][0] = 0
while q:
    cur = q.popleft()
    cr = cur[0]
    cc = cur[1]
    ck = cur[2]
    cd = cur[3]

    if cr == R - 1 and cc == C - 1:
        print(cd + 1)
        exit(0)

    for i in range(4):
        nr = cr + moves[i][0]
        nc = cc + moves[i][1]

        if nr < 0 or nc < 0 or nr >= R or nc >= C:
            continue

        if map_[nr][nc] == 0:
            if distances[nr][nc][ck] <= cd + 1:
                continue

            distances[nr][nc][ck] = cd + 1
            q.append((nr, nc, ck, cd + 1))

        elif ck + 1 <= K:
            if distances[nr][nc][ck + 1] <= cd + 1:
                continue

            distances[nr][nc][ck + 1] = cd + 1
            q.append((nr, nc, ck + 1, cd + 1))

print(-1)
