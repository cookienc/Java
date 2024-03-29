import sys

input = sys.stdin.readline

N = int(input())

balls = list(input().strip())

red = 0
blue = 0
diff = False
before = ''
for i in range(N - 1, -1, -1):
    if i == N - 1:
        before = balls[i]
        continue

    if not diff:
        if before != balls[i]:
            diff = True
        else:
            continue

    if balls[i] == 'R':
        red += 1
    else:
        blue += 1
min_ = min(red, blue)

red = 0
blue = 0
diff = False
before = ''
for i in range(N):
    if i == 0:
        before = balls[i]
        continue

    if not diff:
        if before != balls[i]:
            diff = True
        else:
            continue

    if balls[i] == 'R':
        red += 1
    else:
        blue += 1

print(min(min_, min(red, blue)))
