from collections import defaultdict

import sys

input = sys.stdin.readline

N = int(input())

answer = 0
target = defaultdict(int)
for i in range(N):
    if i == 0:
        for ii in input().strip():
            target[ii] += 1
        continue

    tmp = defaultdict(int)
    for ii in input().strip():
        tmp[ii] += 1

    if abs(sum(target.values()) - sum(tmp.values())) > 1:
        continue

    diff = 0
    is_visited = set()
    for t in target:
        if t in is_visited:
            continue
        is_visited.add(t)
        if t in tmp:
            diff += abs(target[t] - tmp[t])
        else:
            diff += target[t]

    for tt in tmp:
        if tt in is_visited:
            continue
        is_visited.add(tt)
        diff += tmp[tt]

    if diff <= 2:
        answer += 1


print(answer)
