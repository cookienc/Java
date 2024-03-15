import sys

input = sys.stdin.readline

N, Q = map(int, input().split())

arr = [0] + list(map(int, input().split()))
arr.sort()

for i in range(1, N + 1):
    arr[i] += arr[i - 1]

for _ in range(Q):
    L, R = map(int, input().split())
    print(arr[R] - arr[L - 1])
