import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
towers = list(map(int, input().split()))

answer = [0]

stack = deque()
stack.append((1, towers[0]))
for i in range(1, N):
    cur = towers[i]

    check = False
    while stack:
        before = stack.pop()
        if before[1] > cur:
            stack.append(before)
            answer.append(before[0])
            check = True

        if check:
            break

    if not check:
        answer.append(0)

    stack.append((i + 1, cur))
print(*answer)
