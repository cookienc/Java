from collections import deque

import sys

input = sys.stdin.readline

s = str(input().strip())

stack = deque()

for ss in s:
    stack.append(ss)
    if len(stack) >= 4:
        if stack[-4] == 'P' and stack[-3] == 'P' and stack[-2] == 'A' and stack[-1] == 'P':
            stack.pop()
            stack.pop()
            stack.pop()
            stack.pop()
            stack.append('P')

if len(stack) >= 4:
    if stack[-4] == 'P' and stack[-3] == 'P' and stack[-2] == 'A' and stack[-1] == 'P':
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        stack.append('P')

if len(stack) == 0 or (len(stack) == 1 and stack[0] == 'P'):
    print("PPAP")
else:
    print("NP")
