import sys
from queue import Queue

input =sys.stdin.readline

moves = [(-1, 2), (-2, 1), (-1, -2), (-2, -1), (1, -2), (2, -1), (2, 1), (1, 2)]

for _ in range(int(input())):
    l = int(input())
    sr, sc = map(int, input().split())
    tr, tc = map(int, input().split())

    direction = int((tc - sc) / (tr - sr)) if tr != sr else 0

    visited = [[False for _ in range(l)] for _ in range(l)]
    q = Queue()
    q.put((sr, sc, 0))
    while not q.empty():
        cur = q.get()
        if cur[0] == tr and cur[1] == tc:
            print(cur[2])
            break

        for i in range(8):
            nr = cur[0] + moves[i][0]
            nc = cur[1] + moves[i][1]

            if nr < 0 or nc < 0 or nr >= l or nc >= l:
                continue

            if visited[nr][nc]:
                continue

            if tr - nr != 0 and int((tc - nc) / (tr - nr)) * direction < 0:
                continue

            visited[nr][nc] = True
            q.put((nr, nc, cur[2] + 1))

