from queue import Queue
EMPTY = '.'
move = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def check(r, c):
    global visited, map, EMPTY

    tmp = Queue()
    q = Queue()
    target = map[r][c]
    tmp.put((r, c))
    q.put((r, c))
    visited[r][c] = True

    while not q.empty():
        cur = q.get()
        for i in range(len(move)):
            nr = cur[0] + move[i][0]
            nc = cur[1] + move[i][1]

            if nr < 0 or nc < 0 or nr >= 12 or nc >= 6 or visited[nr][nc]:
                continue

            next = map[nr][nc]

            if next != target:
                continue

            visited[nr][nc] = True
            q.put((nr, nc))
            tmp.put((nr, nc))

    if tmp.qsize() >= 4 and target != EMPTY:
        while not tmp.empty():
            t = tmp.get()
            map[t[0]][t[1]] = EMPTY
        return True

    return False

def reorder():
    global map
    for c in range(len(map[0])):
        compression = [t[c] for t in map if t[c] != EMPTY]
        bottom = len(map) - 1
        for r in range(bottom, -1, -1):
            next = bottom - r
            if len(compression) != 0 and next < len(compression):
                map[r][c] = compression[len(compression) - 1 - next]
            else:
                map[r][c] = EMPTY


map = [list(map(str, input())) for _ in range(12)]

chain = True
answer = -1
while chain:
    answer += 1
    visited = [[False for _ in range(6)] for _ in range(12)]
    flag = False
    for r in range(len(map)):
        for c in range(len(map[0])):
            if visited[r][c]:
                continue
            if check(r, c):
                flag = True
    reorder()

    if flag:
        chain = True
    else:
        chain = False
print(answer)
