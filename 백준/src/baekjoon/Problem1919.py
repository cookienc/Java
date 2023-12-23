import sys

input = sys.stdin.readline

a = input().strip('\n')
b = input().strip('\n')

list_ = [[0, 0] for _ in range(26)]

for w in a:
    list_[ord(w) - ord('a')][0] += 1
for w in b:
    list_[ord(w) - ord('a')][1] += 1

cnt = 0
for i in range(len(list_)):
    max_ = max(list_[i][0], list_[i][1])
    min_ = min(list_[i][0], list_[i][1])
    cnt += max_ - min_

print(cnt)
