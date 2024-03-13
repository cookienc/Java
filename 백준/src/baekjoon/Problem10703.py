import sys

input = sys.stdin.readline

R, S = map(int, input().split())

area = [list(map(str, input().strip())) for _ in range(R)]

minHeight = R
for c in range(S):
    x = -1
    ground = 0
    for r in range(R):
        if area[r][c] == 'X':
            x = r
        if area[r][c] == '#':
            ground = r
            break
    if x != -1:
        minHeight = min(minHeight, ground - x - 1)

for c in range(S):
    for r in range(R - 1, -1, -1):
        if area[r][c] == 'X':
            area[r][c] = '.'
            area[r + minHeight][c] = 'X'

for r in range(R):
    print(''.join(area[r]))
