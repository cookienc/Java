import sys
from collections import deque
input = sys.stdin.readline

LEFT = 'L'
RIGHT = 'D'
BACK = 'B'
WRITE = 'P'

front = deque(map(str, input().strip('\n')))
n = int(input())
behind = deque()

for _ in range(n):
    commands = list(input().split())
    command = commands[0]
    if command == LEFT:
        if front:
            behind.appendleft(front.pop())
        continue

    if command == RIGHT:
        if behind:
            front.append(behind.popleft())
        continue

    if command == BACK:
        if front:
            front.pop()
        continue

    front.append(commands[1])

print(''.join(front) + ''.join(behind))
