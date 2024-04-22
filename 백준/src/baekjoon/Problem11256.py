import heapq

import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    J, N = map(int, input().split())
    boxes = []
    for _ in range(N):
        R, C = map(int, input().split())
        heapq.heappush(boxes, (- R * C))

    cnt = 0
    while J > 0:
        can_put = -heapq.heappop(boxes)
        J -= can_put
        cnt += 1

    print(cnt)
