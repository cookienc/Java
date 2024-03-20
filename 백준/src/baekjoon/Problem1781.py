import heapq
import sys

input = sys.stdin.readline

n = int(input())
problems = []
for _ in range(n):
    deadline, cup = map(int, input().split())
    problems.append((deadline, cup))

problems.sort()

solved = []

for deadline, cup in problems:
    heapq.heappush(solved, cup)
    if deadline < len(solved):
        heapq.heappop(solved)

print(sum(solved))
