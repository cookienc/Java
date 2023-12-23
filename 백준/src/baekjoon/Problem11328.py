import sys
input = sys.stdin.readline
N = int(input())

for _ in range(N):
    from_, to_ = map(str, input().strip('\n').split())

    isRight = True
    for w in set(from_):
        if from_.count(w) != to_.count(w):
            isRight = False
            break

    if isRight:
        print('Possible')
    else:
        print('Impossible')
