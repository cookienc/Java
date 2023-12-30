import sys
from bisect import bisect_left

input = sys.stdin.readline

N = int(input())
numbers = [int(input()) for _ in range(N)]
numbers.sort()
twoSum = []
for i in range(N):
    for j in range(N):
        twoSum.append(numbers[i] + numbers[j])

twoSum.sort()

for i in range(N - 1, -1, -1):
    for j in range(i):
        idx = bisect_left(twoSum, numbers[i] - numbers[j])
        if idx < 0 or idx >= len(twoSum):
            continue
        if twoSum[idx] == numbers[i] - numbers[j]:
            print(numbers[i])
            exit(0)
