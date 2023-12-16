t = int(input())
for _ in range(t):
    N = int(input())
    answer = ""
    tmp = 0
    for _ in range(N):
        s, l = map(str, input().split())
        l = int(l)
        if tmp < l:
            answer = s
            tmp = l
    print(answer)
