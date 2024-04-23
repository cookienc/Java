import sys

input = sys.stdin.readline

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort(key=lambda x: x[0])

total = sum([x[1] for x in arr])
cnt = 0
for idx, people in arr:
    cnt += people
    if cnt >= round(total / 2):
        print(idx)
        break

