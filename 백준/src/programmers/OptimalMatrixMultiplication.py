import sys

def solution(matrix_sizes):
    N = len(matrix_sizes)
    dp = [[sys.maxsize for _ in range(N)] for _ in range(N)]

    for i in range(N):
        dp[i][i] = 0

    for l in range(1, N):
        for i in range(N - l):
            j = i + l
            for k in range(i, j):
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + matrix_sizes[i][0] * matrix_sizes[k + 1][0] * matrix_sizes[j][1])

    return dp[0][N - 1]


print(solution([[5, 3], [3, 10], [10, 6]]))
