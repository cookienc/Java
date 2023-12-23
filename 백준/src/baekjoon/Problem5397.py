import sys

input = sys.stdin.readline

N = int(input())
for _ in range(N):
    password = input().strip('\n')

    stack1 = []
    stack2 = []
    for p in password:
        if p == '<':
            if stack1:
                stack2.append(stack1.pop())
            continue

        if p == '>':
            if stack2:
                stack1.append(stack2.pop())
            continue

        if p == '-':
            if stack1:
                stack1.pop()
            continue

        stack1.append(p)

    stack1.extend(reversed(stack2))
    print(''.join(stack1))
