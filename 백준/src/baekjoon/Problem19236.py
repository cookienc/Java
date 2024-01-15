import sys

input = sys.stdin.readline
moves = [(-10, -10), (-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)]

area = [[] for _ in range(4)]
for i in range(4):
    a, aa, b, bb, c, cc, d, dd = map(int, input().split())
    area[i].append((a, aa))
    area[i].append((b, bb))
    area[i].append((c, cc))
    area[i].append((d, dd))


def moveFish(copy_area):
    for i in range(1, 17):
        alreadyMove = False
        for r in range(4):
            for c in range(4):
                if copy_area[r][c][0] == i:
                    d = copy_area[r][c][1]
                    retry = 0
                    while retry < 8:
                        nr = r + moves[d][0]
                        nc = c + moves[d][1]

                        if nr < 0 or nc < 0 or nr >= 4 or nc >= 4 or copy_area[nr][nc][0] == -9:
                            d += 1
                            retry += 1
                            if d > 8:
                                d = 1
                            continue

                        copy_area[nr][nc], copy_area[r][c] = (copy_area[r][c][0], d), copy_area[nr][nc]
                        alreadyMove = True
                        break
                if alreadyMove:
                    break
            if alreadyMove:
                break


answer = 0
initial = area[0][0][0]
area[0][0] = (-9, area[0][0][1])


def dfs(copy_area, sr, sc, sd, sum):
    global moves, answer

    answer = max(answer, sum)

    copy = [row[:] for row in copy_area]
    moveFish(copy)
    nr = sr
    nc = sc
    for _ in range(4):
        nr += moves[sd][0]
        nc += moves[sd][1]

        if nr < 0 or nc < 0 or nr >= 4 or nc >= 4:
            break

        if copy[nr][nc] == (-1, -1):
            continue

        prey = copy[nr][nc]
        copy[nr][nc] = (-9, prey[1])
        copy[sr][sc] = (-1, -1)
        dfs(copy, nr, nc, prey[1], sum + prey[0])
        copy[nr][nc] = (prey[0], prey[1])
        copy[sr][sc] = (-9, sd)



answer = 0
dfs(area, 0, 0, area[0][0][1], initial)

print(answer)
