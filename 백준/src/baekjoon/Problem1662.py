from collections import deque

import sys

input = sys.stdin.readline

s = str(input().strip())

stack = deque()

length = 0
before = 0
for c in s:
    if c == '(':
        stack.append((length - 1, before))
        length = 0
    elif c == ')':
        c, b = stack.pop()
        length = length * b + c
    else:
        length += 1
        before = int(c)

print(length)
