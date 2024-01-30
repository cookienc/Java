import sys

input = sys.stdin.readline
while True:
    m, n = map(int, input().split())

    if (m, n) == (0, 0):
        break

    distances = []
    total = 0
    for _ in range(n):
        st, en, weight = map(int, input().split())
        total += weight
        distances.append((st, en, weight))
    distances.sort(key=lambda x: x[2])

    cycles = [i for i in range(m)]
    answer = 0


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


    for i in range(n):
        st, en, weight = distances[i]

        if getParent(st) == getParent(en):
            continue

        union(st, en)
        answer += weight

    print(total - answer)
