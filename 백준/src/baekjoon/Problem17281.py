# 타순은 이닝이 끝나도 변경 안 됨
# 3아웃이면 이닝이 종료, 공/수 교대, 이닝이 끝나면 주자 리셋
# 안타 - 타자와 주자 한 루씩 진루 2루타, 3루타, 홈런(4루타), 아웃 : 모든 주자 진루 x
# 1번 선수를 4 타자로 정해짐 나머지 결정. 최대한 많은 득점 하는 순으로
import sys
from collections import deque
from itertools import permutations

input = sys.stdin.readline

N = int(input())
players = [list(map(int, input().split())) for _ in range(N)]

sum = -1


def calculate(order, inning, st):
    global players
    curInning = players[inning]

    pq = deque()
    score = 0
    out = 0
    st -= 1
    while out < 3:
        st += 1
        if st >= 9:
            st = 0
        curPlayer = None
        if st < 3:
            curPlayer = curInning[order[st] - 1]
        elif st == 3:
            curPlayer = curInning[0]
        else:
            curPlayer = curInning[order[st - 1] - 1]

        if curPlayer == 0:
            out += 1
            continue

        times = len(pq)
        while times > 0:
            times -= 1
            runner = pq.popleft()
            runner += curPlayer
            if runner >= 4:
                score += 1
                continue
            pq.append(runner)
        if curPlayer == 4:
            score += 1
        else:
            pq.append(curPlayer)

    return (st, score)


for o in permutations(list(range(2, 10)), 8):
    points = 0
    st = 0
    for n in range(N):
        next, earns = calculate(o, n, st)
        points += earns
        st = next + 1 if next + 1 < 9 else 0
    sum = max(sum, points)

print(sum)
