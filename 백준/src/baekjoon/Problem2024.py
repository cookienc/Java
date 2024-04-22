from collections import deque

import sys

input = sys.stdin.readline

M = int(input())
lines = []
while True:
    L, R = map(int, input().split())
    if (L, R) == (0, 0):
        break

    if R <= 0 or (L < 0 and R < 0) or R == L:
        continue
    lines.append((L, R))
lines = deque(sorted(lines, key=lambda x: (x[0], -x[1])))

if not lines:
    print(0)
    exit(0)

R = 0
answer = 0
candidates = []


def find_candidates(lines, R):
    candidates = []
    while lines:
        l, r = lines.popleft()
        if r <= R:
            continue
        if l <= R < r:
            candidates.append((l, r))
            continue
        lines.appendleft((l, r))
        break

    return candidates


while lines:
    candidates = find_candidates(lines, R)

    if not candidates:
        if not lines:
            print(0)
            exit(0)
        else:
            lines.popleft()
            continue

    R = max(c[1] for c in candidates)
    answer += 1
    candidates.clear()
    if R >= M:
        print(answer)
        exit(0)

print(0)
