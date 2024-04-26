from collections import defaultdict

import sys

input = sys.stdin.readline

N, M = map(int, input().split())

words = defaultdict(int)
for _ in range(N):
    word = input().strip()
    if len(word) >= M:
        words[word] += 1

for k, v in sorted(words.items(), key=lambda x: (-x[1], -len(x[0]), x[0])):
    print(k)


