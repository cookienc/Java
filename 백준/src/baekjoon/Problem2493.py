import sys

input = sys.stdin.readline
N = int(input())
towers = list(map(int, input().split()))

stack = []
answers = []

for i in range(N):
    height = towers[i]
    if not stack:
        stack.append((i + 1, height))
        answers.append(0)
        continue

    if stack[-1][1] > height:
        answers.append(stack[-1][0])
        stack.append((i + 1, height))
    else:
        while stack and stack[-1][1] <= height:
            stack.pop()
        if not stack:
            answers.append(0)
        else:
            answers.append(stack[-1][0])
        stack.append((i + 1, height))

print(*answers)
