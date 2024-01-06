import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())

cnt = 0
for a in A:
    cnt += 1
    a -= B
    if a < 0:
        a = 0

    cnt += a // C
    if a % C != 0:
        cnt += 1
print(cnt)
import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
B, C = map(int, input().split())

cnt = 0
for a in A:
    cnt += 1
    a -= B
    if a < 0:
        a = 0

    cnt += a // C
    if a % C != 0:
        cnt += 1
print(cnt)
