import sys
from collections import deque

input = sys.stdin.readline
priorities = {
    '(': 1, ')': 1,
    '+': 2, '-': 2,
    '*': 3, '/': 3
}

s = input().strip('\n')
answers = deque()
ops = deque()
bracket = 0
for v in s:
    if 'A' <= v <= 'Z':
        answers.append(v)
        continue

    if v == '(':
        ops.append(v)
        continue

    if v == ')':
        while ops and ops[-1] != '(':
            answers.append(ops.pop())
        ops.pop()
        continue

    while ops and priorities[v] <= priorities[ops[-1]]:
        answers.append(ops.pop())

    ops.append(v)

while ops:
    answers.append(ops.pop())

print(''.join(answers))
