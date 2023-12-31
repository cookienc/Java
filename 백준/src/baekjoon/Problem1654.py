import sys

input = sys.stdin.readline

K, N = map(int, input().split())

lines = [int(input()) for _ in range(K)]

def countLine(length):
    global lines
    sum = 0
    for l in lines:
        sum += (l // length)
    return sum

st = 1
en = max(lines) + 1

while st < en:
    mid = (st + en) // 2

    if countLine(mid) < N:
        en = mid
    else:
        st = mid + 1

print(st - 1)
