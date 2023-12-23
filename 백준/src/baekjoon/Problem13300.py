import sys
input = sys.stdin.readline

N, K = map(int, input().split())

students = [[0, 0] for _ in range(7)]
for _ in range(N):
    s, y = map(int, input().split())
    students[y][s] += 1

room = 0
for s in students:
    for ss in s:
        if ss == 0:
            continue
        if ss % K == 0:
            room += int(ss / K)
        else:
            room += int((ss / K)) + 1

print(room)
