from collections import defaultdict

import sys

input = sys.stdin.readline

N, K = map(int, input().split())

names = []
for _ in range(N):
    names.append(input().strip())
for _ in range(K):
    names.append('')

answers = [0 for _ in range(N)]

st = 0
en = 1
d = defaultdict(int)

while st < en and st < N:
    before = names[st]

    if en - st <= K:
        current = names[en]
        d[len(current)] += 1
        en += 1
    else:
        answers[st] += d[len(before)]
        if st + 1 < N:
            d[len(names[st + 1])] -= 1
        st += 1

print(sum(answers))
