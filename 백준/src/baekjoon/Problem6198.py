import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
buildings = [int(input()) for _ in range(N)]

watching = deque()
watching.appendleft((N - 1, buildings[N - 1]))
answers = [0]
for i in range(N - 2, -1, -1):
    check = False
    cur = buildings[i]

    while watching and cur > watching[0][1]:
        check = True
        watching.popleft()

    if not watching and check:
        answers.append(N - 1 - i)
        watching.appendleft((i, cur))
        continue

    if cur <= watching[0][1] and check:
        next = watching.popleft()
        answers.append(next[0] - 1 - i)
        watching.appendleft(next)
        watching.appendleft((i, cur))
        continue

    answers.append(0)
    watching.appendleft((i, cur))

print(sum(answers))
