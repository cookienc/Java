# 승리 조건: 0점을 만들면 승리, 같은 라운드에 0점이면, 싱글 또는 불이 많으면 승리, 선공이 승리 / 0점보다 더 크면 실격
def solution(target):
    dp = initializeDp(target)
    dp[0] = (0, 0)

    for i in range(21, 61):
        for j in range(1, i):
            if dp[i][0] > dp[i - j][0] + dp[j][0]:
                dp[i] = (dp[i - j][0] + dp[j][0], dp[j][1] + dp[i - j][1])
            elif dp[i][0] == dp[i - j][0] + dp[j][0] and dp[i][1] < dp[i - j][1] + dp[j][1]:
                dp[i] = (dp[i][0], dp[i - j][1] + dp[j][1])

    for i in range(61, target + 1):
        sixty = i - 60
        fifty = i - 50

        if dp[sixty][0] > dp[fifty][0]:
            dp[i] = (dp[fifty][0] + 1, dp[fifty][1] + 1)

        if dp[sixty][0] < dp[fifty][0]:
            dp[i] = (dp[sixty][0] + 1, dp[sixty][1])

        if dp[sixty][0] == dp[fifty][0]:
            if dp[sixty][1] > dp[fifty][1]:
                dp[i] = (dp[sixty][0] + 1, dp[sixty][1])
            else:
                dp[i] = (dp[fifty][0] + 1, dp[fifty][1] + 1)

    return dp[target]


def initializeDp(target):
    scores = [i for i in range(1, 21)]
    dp = [(100000, 100000) for _ in range(100_001)]
    for i in scores:
        dp[i] = (1, 1)

        if i * 2 < 61:
            dp[i * 2] = (1, 0)

        if i * 3 < 61:
            dp[i * 3] = (1, 0)

    if target >= 50:
        dp[50] = (1, 1)
    return dp

print(solution(21))
print(solution(58))
