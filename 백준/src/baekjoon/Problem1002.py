import math

i = int(input())

for _ in range(i):
    l = list(map(int, input().split()))
    distance = math.sqrt(abs(l[0] - l[3]) ** 2 + abs(l[1] - l[4]) ** 2)
    diffPlus = abs(l[2] + l[5])
    diffMinus = abs(l[2] - l[5])
    if diffPlus == distance or diffMinus == distance:
        print(1)
    elif diffMinus < distance and diffPlus > distance:
        print(2)
    else:
        print(0)
