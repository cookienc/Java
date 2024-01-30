import sys

input = sys.stdin.readline
n = int(input())

distances = []

stars = []
for i in range(n):
    r, c = map(float, input().split())
    stars.append((r, c))


def calculateDistance(star1, star2):
    r1, c1 = star1
    r2, c2 = star2
    return round((abs(r1 - r2) ** 2 + abs(c1 - c2) ** 2) ** (1 / 2), 2)


def getParent(idx):
    global cycles
    if cycles[idx] == idx:
        return idx

    cycles[idx] = getParent(cycles[idx])
    return cycles[idx]


def union(st, en):
    global cycles
    st = getParent(st)
    en = getParent(en)

    if st < en:
        cycles[en] = st
    else:
        cycles[st] = en


for i in range(n - 1):
    for j in range(i + 1, n, 1):
        distances.append((i, j, calculateDistance(stars[i], stars[j])))

cycles = [i for i in range(n)]
distances.sort(key=lambda d: d[2])
answer = 0

for i in range(len(distances)):
    st, en, weight = distances[i]
    if getParent(st) == getParent(en):
        continue
    union(st, en)
    answer += weight
print(round(answer, 2))
