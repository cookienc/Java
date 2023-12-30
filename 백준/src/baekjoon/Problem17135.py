# 궁수 3명 배치
# N + 1에 성 위치, 성안에 배치 가능
# 한 성에 최대 1명 궁수
# 턴마다 공격 한 번, 모두 동시에
# 거리에서 가장 가까운 적, 왼쪽에 있는것
# 같은 적이 여러 궁수 타켓 가능
# 적 아래로 한 칸 이동
# 범위 벗어나면 사라짐, 모두 없어지면 종료

import sys
from collections import deque

input = sys.stdin.readline
moves = [(0, -1), (-1, 0), (0, 1)]


def combination(depth, visited):
    global R, C

    if depth == 3:
        count(visited)
        return

    for i in range(C):
        if visited & (1 << i) != 0:
            continue
        combination(depth + 1, visited | (1 << i))


def count(visited):
    global R, C, D, area, answer, moves
    copy_area = [row[:] for row in area]
    people = []
    for i in range(C):
        if (visited & (1 << i)) != 0:
            people.append(i)

    count = 0
    origin = visited
    for RR in range(R - 1, -1, - 1):
        q = deque()
        visited = origin
        enemies = set()
        for pc in people:
            q.append((RR + 1, pc, 0, pc))
        checked = [[[[False] for _ in range(C)] for _ in range(R)] for _ in range(C)]

        while q:
            cr, cc, dist, type = q.popleft()

            if (visited & (1 << type)) == 0:
                continue

            for i in range(3):
                nr = cr + moves[i][0]
                nc = cc + moves[i][1]

                if nr < 0 or nc < 0 or nr >= RR + 1 or nc >= C:
                    continue
                if dist + 1 > D:
                    continue
                if checked[type][nr][nc] == True:
                    continue
                checked[type][nr][nc] = True

                if copy_area[nr][nc] == 1:
                    enemies.add((nr, nc))
                    visited &= ~(1 << type)
                    break

                q.append((nr, nc, dist + 1, type))

        for er, ec in enemies:
            copy_area[er][ec] = 0
            count += 1

    answer = max(answer, count)


R, C, D = map(int, input().split())

area = [list(map(int, input().split())) for _ in range(R)]

answer = 0
combination(0, 0)
print(answer)
