import sys

input = sys.stdin.readline

S = input().strip()
T = input().strip()

while S != T and len(S) < len(T):
    if T[-1] == "A":
        T = T[:-1]
        continue

    if T[-1] == "B":
        T = T[::-1]
        T = T[1:]
        continue

    break

if S == T:
    print(1)
else:
    print(0)
