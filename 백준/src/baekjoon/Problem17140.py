import sys
from collections import defaultdict

input = sys.stdin.readline

r, c, k = map(int, input().split())
r -= 1
c -= 1
arr = [list(map(int, input().split())) for _ in range(3)]


def functionR(arr):
    tmp = [[] for _ in range(len(arr))]
    for r in range(len(arr)):
        map_ = defaultdict(lambda: 0)
        for c in range(len(arr[r])):
            value = arr[r][c]
            if value == 0:
                continue
            map_[value] += 1
        for k, v in sorted(map_.items(), key=lambda x: (x[1], x[0])):
            tmp[r].append(k)
            tmp[r].append(v)

    maxLength = max(len(t) for t in tmp)
    for t in tmp:
        while len(t) < maxLength:
            t.append(0)

    return tmp


t = 0


def functionC(arr):
    tmp = [[] for _ in range(len(arr[0]))]
    for c in range(len(arr[0])):
        map_ = defaultdict(lambda: 0)
        for r in range(len(arr)):
            value = arr[r][c]
            if value == 0:
                continue
            map_[value] += 1
        for k, v in sorted(map_.items(), key=lambda x: (x[1], x[0])):
            tmp[c].append(k)
            tmp[c].append(v)

    maxLength = max(len(t) for t in tmp)
    for t in tmp:
        while len(t) < maxLength:
            t.append(0)

    ret = [[] for _ in range(len(tmp[0]))]
    for r in range(len(tmp)):
        for c in range(len(tmp[0])):
            ret[c].append(tmp[r][c])
    return ret


def cutMax(arr):
    if len(arr) > 100:
        for i in range(len(arr)):
            arr[i] = arr[i][:100]


while t <= 100:
    if r < len(arr) and c < len(arr[0]) and arr[r][c] == k:
        print(t)
        exit(0)

    t += 1
    R = len(arr)
    C = len(arr[0])

    if R >= C:
        arr = functionR(arr)
    else:
        arr = functionC(arr)

    cutMax(arr)

print(-1)
