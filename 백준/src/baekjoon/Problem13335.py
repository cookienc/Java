import sys

input = sys.stdin.readline
n, w, L = map(int, input().split())
trucks = list(map(int, input().split()))
ages = [w] * len(trucks)

i = 0
load = 0
c1 = 0
c2 = 0
for t in range(1, 100001):
    if i < n and load + trucks[i] <= L:
        load += trucks[i]
        i += 1
        c2 = i

    for j in range(c1, c2):
        ages[j] -= 1
        if ages[j] <= 0:
            load -= trucks[j]
            c1 = j + 1

    if c1 == n:
        print(t + 1)
        break
