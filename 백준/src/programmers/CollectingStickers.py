def solution(sticker):
    if len(sticker) == 1:
        return sticker[0]
    if len(sticker) == 2:
        return max(sticker[0], sticker[1])

    dp = [0 for _ in range(len(sticker))]
    dp[0] = 0
    dp[1] = sticker[1]
    for i in range(2, len(sticker)):
        dp[i] = max(sticker[i] + dp[i - 2], dp[i - 1])

    dp2 = [0 for _ in range(len(sticker))]
    dp2[0] = sticker[0]
    dp2[1] = sticker[0]
    for i in range(2, len(sticker) - 1):
        dp2[i] = max(sticker[i] + dp2[i - 2], dp2[i - 1])

    return max(dp[len(sticker) - 1], dp2[len(sticker) - 2])


print(solution([14, 6, 5, 11, 3, 9, 2, 10]))
print(solution([1, 3, 2, 5, 4]))
print(solution([1]))
