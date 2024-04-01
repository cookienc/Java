import heapq
import sys

input = sys.stdin.readline

n = int(input())

lectures = [list(map(int, input().split())) for _ in range(n)]

lectures.sort(key=lambda x: (x[1], x[0]))
answer = []

for l in lectures:
    heapq.heappush(answer, l[0])
    if len(answer) > l[1]:
        heapq.heappop(answer)

print(sum(answer))
