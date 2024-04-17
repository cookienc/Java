import sys

input = sys.stdin.readline

N = int(input())
S = input().strip()

stack = []

arr = [False for _ in range(N)]
sum = 0
for i in range(len(S)):
    c = S[i]

    if c == '(':
        stack.append((i, c))
        continue

    if c == ')':
        if not stack:
            continue

        if stack and stack[-1][1] == '(':
            idx, c = stack.pop()
            arr[i] = True
            arr[idx] = True

st = 0
en = 0
answer = 0

while st <= en < len(S):
    if not arr[en]:
        answer = max(answer, en - st)
        st = en + 1
        en = st
    else:
        en += 1

answer = max(answer, en - st)
print(answer)
