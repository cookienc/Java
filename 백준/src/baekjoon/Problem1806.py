import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))

st = 0
en = 0
minimum = sys.maxsize
tmp = nums[0]
while st <= en and en < N:
    if tmp < M:
        en += 1
        if en < N:
            tmp += nums[en]
        continue

    if tmp >= M:
        minimum = min(en - st, minimum)
        tmp -= nums[st]
        st += 1
        continue

print(minimum + 1 if minimum != sys.maxsize else 0)
