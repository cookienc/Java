import sys

input = sys.stdin.readline

dr, dc = [-1, -1, 0, 1, 1, 1, 0, -1], [0, 1, 1, 1, 0, -1, -1, -1]

N, M, K = map(int, input().split())

area = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(M):
    r, c, m, s, d = map(int, input().split())
    area[r - 1][c - 1].append((m, s, d))


def move():
    global area, N
    afterArea = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if area[i][j]:
                for m, s, d in area[i][j]:
                    nr = (i + s * dr[d]) % N
                    nc = (j + s * dc[d]) % N
                    afterArea[nr][nc].append((m, s, d))
    area = afterArea


def merge():
    global area, N
    afterArea = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if area[i][j]:
                if len(area[i][j]) >= 2:
                    oddD, evenD = 0, 0
                    totalM = 0
                    totalS = 0
                    for m, s, d in area[i][j]:
                        totalS += s
                        totalM += m
                        if d % 2 == 1:
                            oddD += 1
                        else:
                            evenD += 1
                    count = oddD + evenD
                    makeM = totalM // 5
                    if makeM == 0:
                        continue
                    makeS = totalS // count
                    if oddD == 0 or evenD == 0:
                        afterArea[i][j] = [(makeM, makeS, 0), (makeM, makeS, 2), (makeM, makeS, 4), (makeM, makeS, 6)]
                    else:
                        afterArea[i][j] = [(makeM, makeS, 1), (makeM, makeS, 3), (makeM, makeS, 5), (makeM, makeS, 7)]
                else:
                    afterArea[i][j] = area[i][j]
    area = afterArea


for _ in range(K):
    move()
    merge()

answer = 0
for i in range(N):
    for j in range(N):
        if area[i][j]:
            for m, s, d in area[i][j]:
                answer += m

print(answer)
