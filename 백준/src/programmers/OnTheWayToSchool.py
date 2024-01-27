MOD = 1_000_000_007


def solution(m, n, puddles):
    dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    for r, c in puddles:
        dp[c][r] = -9

    dp[1][1] = 1
    for c in range(1, n + 1):
        for r in range(1, m + 1):
            if (r == 1 and c == 1) or dp[c][r] == -9:
                continue
            top = dp[c - 1][r]
            if top == -9:
                top = 0

            left = dp[c][r - 1]
            if left == -9:
                left = 0
            dp[c][r] = (left + top) % MOD

    return dp[n][m]


print(solution(4, 3, [[2, 2]]))
