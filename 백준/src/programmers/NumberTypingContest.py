import sys

numberpad = {
    1: (0, 0),
    2: (0, 1),
    3: (0, 2),
    4: (1, 0),
    5: (1, 1),
    6: (1, 2),
    7: (2, 0),
    8: (2, 1),
    9: (2, 2),
    '*': (3, 0),
    0: (3, 1),
    '#': (3, 2)
}


def calculateWeights():
    global numberpad

    weights = [[0 for _ in range(10)] for _ in range(10)]

    for i in range(10):
        for j in range(10):
            if i == j:
                weights[i][j] = 1
                continue
            dr, dc = abs(numberpad[i][0] - numberpad[j][0]), abs(numberpad[i][1] - numberpad[j][1])
            if dr == 0 or dc == 0:
                maxMove = max(dr, dc)
                weights[i][j] = maxMove * 2
            else:
                diagonal = min(dr, dc)
                maxMove = max(dr, dc)
                weights[i][j] = diagonal * 3 + (maxMove - diagonal) * 2

    return weights


#                (4, 6)
#       (5, 6)             (4, 5)
# (1, 6)    (5, 1)    (1, 5)    (4, 1)
def solution(numbers):
    weights = calculateWeights()
    n = len(numbers)
    dp = [[[sys.maxsize for _ in range(10)] for _ in range(10)] for _ in range(n)]

    target = int(numbers[0])
    dp[0][target][6] = weights[4][target]
    dp[0][4][target] = weights[target][6]

    for depth in range(1, n):
        target = int(numbers[depth])
        for i in range(10):
            for j in range(10):
                if i == j:
                    continue
                if dp[depth - 1][i][j] == sys.maxsize:
                    continue

                left = dp[depth - 1][i][j] + weights[i][target]
                if dp[depth][target][j] == sys.maxsize:
                    dp[depth][target][j] = left
                else:
                    dp[depth][target][j] = min(dp[depth][target][j], left)

                right = dp[depth - 1][i][j] + weights[j][target]
                if dp[depth][i][target] == sys.maxsize:
                    dp[depth][i][target] = right
                else:
                    dp[depth][i][target] = min(dp[depth][i][target], right)

    answer = sys.maxsize
    for i in range(10):
        for j in range(10):
            if dp[n - 1][i][j] != sys.maxsize:
                answer = min(answer, dp[n - 1][i][j])
    return answer


print(solution("1756"))
print(solution("5123"))
