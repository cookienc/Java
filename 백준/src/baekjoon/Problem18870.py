import sys
from bisect import bisect_left

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))

filtered = []
for n in set(numbers):
    filtered.append(n)
filtered.sort()

answer = []
for i in range(len(numbers)):
    answer.append(bisect_left(filtered, numbers[i]))

print(*answer)

