import sys
input = sys.stdin.readline

N = int(input())
answer = 0
for _ in range(N):
    l = list(map(str, input().strip('\n')))

    stack = []
    for i in l:
        if not stack:
            stack.append(i)
            continue

        if stack[-1] == i:
            stack.pop()
            continue

        stack.append(i)

    if not stack:
        answer += 1
print(answer)
