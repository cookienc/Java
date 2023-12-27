import sys

input = sys.stdin.readline

N = int(input())


def dfs(depth):
    global N, count, isUsed, diagonal_right, diagonal_left
    if depth == N:
        count += 1
        return

    for c in range(N):
        left = depth + c
        right = depth - c + N - 1
        if isUsed[c] or diagonal_right[right] or diagonal_left[left]:
            continue

        isUsed[c] = True
        diagonal_right[right] = True
        diagonal_left[left] = True
        dfs(depth + 1)
        isUsed[c] = False
        diagonal_right[right] = False
        diagonal_left[left] = False


isUsed = [False for _ in range(N)]
diagonal_right = [False for _ in range(2 * N - 1)]
diagonal_left = [False for _ in range(2 * N - 1)]
count = 0
dfs(0)
print(count)
