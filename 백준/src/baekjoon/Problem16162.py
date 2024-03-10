import sys

input = sys.stdin.readline

N, A, D = map(int, input().split())

notes = list(map(int, input().split()))

answer = 0
a = A
for note in notes:
    if note == a:
        answer += 1
        a += D

print(answer)
