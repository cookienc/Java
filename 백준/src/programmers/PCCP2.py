from collections import deque

dr, dc = [0, 0, 1, -1], [1, -1, 0, 0]

def calSize(land, sr, sc, name, visited, info):
    size = 1
    q = deque()
    q.append((sr, sc))
    visited[sr][sc] = True
    land[sr][sc] = name

    n = len(land)
    m = len(land[0])
    while q:
        r, c = q.pop()
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if nr < 0 or nr >= n or nc < 0 or nc >= m:
                continue
            if land[nr][nc] == 0 or visited[nr][nc]:
                continue

            visited[nr][nc] = True
            size += 1
            land[nr][nc] = name
            q.append((nr, nc))

    info.append((name, size))

def calculate(land, info):
    m = len(land[0])
    total = 0
    for i in range(m):
        tmp = 0
        col = [l[i] for l in land]
        s = set(col)
        for ss in s:
            if ss == 0:
                continue
            tmp += info[ss - 1][1]

        total = max(total, tmp)
    return total


def solution(land):
    n = len(land)
    m = len(land[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    info = []
    name = 1
    for r in range(n):
        for c in range(m):
            if not visited[r][c] and land[r][c] == 1:
                calSize(land, r, c, name, visited, info)
                name += 1

    return calculate(land, info)

print(solution([[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]))
