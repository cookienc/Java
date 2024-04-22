import heapq

import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
total = sum(arr)
heapq.heapify(arr)

cost = 0
while arr:
    first = heapq.heappop(arr)
    total -= first
    cost += first * total
print(cost)
