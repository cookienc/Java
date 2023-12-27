import sys
from itertools import combinations

input = sys.stdin.readline

N, S = map(int, input().split())
list_ = list(map(int, input().split()))

count = 0
for i in range(1, N + 1):
    coms = combinations(list_, i)
    for c in coms:
        if sum(c) == S:
            count += 1

print(count)

