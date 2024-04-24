import sys

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
numbers.sort()

diff = sys.maxsize
min_candidates = []
for i in range(N):
    target = numbers[i]

    st = i + 1
    en = N - 1
    while st < en:
        left = numbers[st]
        right = numbers[en]

        total = target + left + right

        if abs(total) < diff:
            diff = abs(total)
            min_candidates = [target, left, right]

        if total < 0:
            st += 1
            if st == i:
                st += 1
        else:
            en -= 1
            if en == i:
                en -= 1

print(*sorted(min_candidates))
