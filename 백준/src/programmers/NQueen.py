def get_right_diagonal_idx(n, r, c):
    return (n - 1) + c - r


def get_left_diagonal_idx(n, r, c):
    return r + c


def dfs(n, r):
    global vertical, horizontal, left_diagonal, right_diagonal, answer

    if r == n:
        answer += 1
        return

    if vertical[r]:
        return

    for c in range(n):
        if horizontal[c]:
            continue
        left_idx = get_left_diagonal_idx(n, r, c)
        if left_diagonal[left_idx]:
            continue
        right_idx = get_right_diagonal_idx(n, r, c)
        if right_diagonal[right_idx]:
            continue

        vertical[r] = True
        horizontal[c] = True
        left_diagonal[left_idx] = True
        right_diagonal[right_idx] = True
        dfs(n, r + 1)
        vertical[r] = False
        horizontal[c] = False
        left_diagonal[left_idx] = False
        right_diagonal[right_idx] = False

def solution(n):
    global vertical, horizontal, left_diagonal, right_diagonal, answer

    vertical = [False] * n
    horizontal = [False] * n
    left_diagonal = [False] * (2 * n - 1)
    right_diagonal = [False] * (2 * n - 1)

    answer = 0
    dfs(n, 0)
    return answer

print(solution(1))
print(solution(2))
print(solution(3))
print(solution(4))
