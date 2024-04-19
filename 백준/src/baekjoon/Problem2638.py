import sys

input = sys.stdin.readline
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]


def checkHole(arr, isVisited, r, c, color):
    global N, M

    isVisited[r][c] = True
    arr[r][c] = color
    dr, dc = [0, 0, 1, -1], [1, -1, 0, 0]
    q = []
    q.append((r, c))

    while q:
        cr, cc = q.pop()
        for i in range(4):
            nr, nc = cr + dr[i], cc + dc[i]

            if nr < 0 or nc < 0 or nr >= N or nc >= M:
                continue

            if isVisited[nr][nc]:
                continue

            if arr[nr][nc] == 1:
                continue

            isVisited[nr][nc] = True
            arr[nr][nc] = color
            q.append((nr, nc))


def color():
    global arr, N, M
    out = -1
    isVisited = [[False] * M for _ in range(N)]
    for r in range(N):
        for c in range(M):
            if not isVisited[r][c] and arr[r][c] <= 0:
                checkHole(arr, isVisited, r, c, out)
                out -= 1


time = 0


def findCheese(arr, r, c, isVisited, wq):
    global N, M

    isVisited[r][c] = True
    dr, dc = [0, 0, 1, -1], [1, -1, 0, 0]
    q = []
    q.append((r, c))

    while q:
        cr, cc = q.pop()
        air = 0
        for i in range(4):
            nr, nc = cr + dr[i], cc + dc[i]

            if nr < 0 or nc < 0 or nr >= N or nc >= M:
                continue

            if isVisited[nr][nc]:
                continue

            if arr[nr][nc] == 1:
                isVisited[nr][nc] = True
                q.append((nr, nc))
                continue

            if arr[nr][nc] == -1:
                air += 1

        if air >= 2:
            wq.append((cr, cc))


def melt():
    global arr, N, M

    isVisited = [[False] * M for _ in range(N)]
    wq = []
    for r in range(N):
        for c in range(M):
            if not isVisited[r][c] and arr[r][c] == 1:
                findCheese(arr, r, c, isVisited, wq)
    if wq:
        for r, c in wq:
            arr[r][c] = -1
        return True
    return False


while True:
    color()
    if melt():
        time += 1
        continue
    break
print(time)
