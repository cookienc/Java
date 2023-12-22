import sys

input = sys.stdin.readline

words = list(map(str, input().strip('\n')))

stack = []
update = False
sum = 0
tmp = 1
for w in words:
    if not stack:
        tmp = 1

    if w == '(':
        update = True
        tmp *= 2
        stack.append('(')
        continue

    if w == '[':
        update = True
        tmp *= 3
        stack.append('[')
        continue

    if w == ')':
        if stack and stack[-1] == '(':
            stack.pop()
            if update:
                sum += tmp
                update = False
            tmp //= 2
            continue
        print(0)
        exit(0)

    if w == ']':
        if stack and stack[-1] == '[':
            stack.pop()
            if update:
                sum += tmp
                update = False
            tmp //= 3
            continue
        print(0)
        exit(0)
if stack:
    print(0)
else:
    print(sum)
