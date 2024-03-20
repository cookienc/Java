import heapq
import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    K = int(input())
    files = list(map(int, input().split()))
    heapq.heapify(files)
    size = 0
    while len(files) > 2:
        f1 = heapq.heappop(files)
        f2 = heapq.heappop(files)
        sum_ = f1 + f2
        size += sum_
        heapq.heappush(files, sum_)

    f1 = heapq.heappop(files)
    f2 = heapq.heappop(files)
    sum_ = f1 + f2
    size += sum_
    print(size)

