import sys

input = sys.stdin.readline

N, M = map(int, input().split())

from_ = [list(map(int, input().strip())) for _ in range(N)]
to_ = [list(map(int, input().strip())) for _ in range(N)]

cnt = 0


def flip(arr, r, c):
    for rr in range(r, r + 3):
        for cc in range(c, c + 3):
            arr[rr][cc] ^= 1

if from_ == to_:
    print(0)
    sys.exit()

if N >= 3 and M >= 3:
    for r in range(N - 2):
        for c in range(M - 2):
            if from_[r][c] != to_[r][c]:
                flip(from_, r, c)
                cnt += 1
            if from_ == to_:
                print(cnt)
                sys.exit()

print(-1)
