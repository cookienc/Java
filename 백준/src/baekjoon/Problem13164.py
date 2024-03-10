import sys

input = sys.stdin.readline

N, K = map(int, input().split())
heights = list(map(int, input().split()))

diff = []
for i in range(N - 1):
    diff.append(heights[i + 1] - heights[i])

diff.sort(reverse=True)
print(sum(diff[K - 1:]))
