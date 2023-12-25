import sys
from collections import deque

input = sys.stdin.readline
moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def dfs(sr, sc):
    global map_, visited, moves, N, M
    q = deque()
    q.append((sr, sc))
    visited[sr][sc] = True

    area = 0

    while q:
        cur = q.popleft()
        cr = cur[0]
        cc = cur[1]
        area += 1

        for i in range(4):
            nr = cr + moves[i][0]
            nc = cc + moves[i][1]

            if nr < 0 or nc < 0 or nr >= M or nc >= N:
                continue

            if visited[nr][nc] or map_[nr][nc]:
                continue

            visited[nr][nc] = True
            q.append((nr, nc))

    answers.append(area)


M, N, K = map(int, input().split())
map_ = [[False for _ in range(N)] for _ in range(M)]
for _ in range(K):
    sc, sr, tc, tr = map(int, input().split())
    sr = M - sr
    tr = M - tr
    for r in range(tr, sr):
        for c in range(sc, tc):
            map_[r][c] = True

answers = []
visited = [[False for _ in range(N)] for _ in range(M)]
for r in range(M):
    for c in range(N):
        if not map_[r][c] and not visited[r][c]:
            dfs(r, c)
print(len(answers))
print(*sorted(answers))
