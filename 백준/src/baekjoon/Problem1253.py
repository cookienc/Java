import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()));
nums.sort()

cnt = 0
for i in range(N):
    copy_nums = nums[:i] + nums[i + 1:]
    st = 0
    en = N - 2

    while st < en:
        sum = copy_nums[st] + copy_nums[en]

        if sum == nums[i]:
            cnt += 1
            break

        if sum < nums[i]:
            st += 1
        else:
            en -= 1

print(cnt)
