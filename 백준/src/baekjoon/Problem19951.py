import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

S = [0 for _ in range(N + 1)]
for _ in range(M):
    l, r, h = map(int, input().split())
    S[l - 1] += h

    if r >= N:
        continue
    S[r] += -h

for i in range(1, N):
    S[i] += S[i - 1]

for i in range(N):
    arr[i] += S[i]

print(*arr)
