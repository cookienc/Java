import heapq
import sys

input = sys.stdin.readline
n, m = map(int, input().split())

info = []
for _ in range(m):
    st, en, weight = map(int, input().split())
    heapq.heappush(info, (weight, st, en))
parents = [i for i in range(n + 1)]

if n == 2:
    print(0)
    exit(0)


def getParent(idx):
    global parents
    if parents[idx] == idx:
        return idx
    parents[idx] = getParent(parents[idx])
    return parents[idx]


def union(st, en):
    global parents
    st = getParent(st)
    en = getParent(en)

    if st < en:
        parents[en] = st
    else:
        parents[st] = en


connected = 0
answer = []
while info:
    if connected == n - 1:
        break
    weight, st, en = heapq.heappop(info)
    if getParent(st) == getParent(en):
        continue
    union(st, en)
    answer.append(weight)
    connected += 1

answer.sort()
print(sum(answer[:-1]))
