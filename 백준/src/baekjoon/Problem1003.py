n = int(input())

for _ in range(n):
    i = int(input())
    zero, one = 1, 0
    for _ in range(i):
        zero, one = one, zero + one
    print(zero, one)
