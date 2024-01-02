import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]
nums.sort()

st = 0
en = 0
minimum = sys.maxsize
while st <= en and en < N:
    diff = nums[en] - nums[st]

    if diff >= M:
        minimum = min(minimum, diff)
        st += 1
        continue

    en += 1
print(minimum)
