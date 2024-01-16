MOD = 1_000_000_007
def solution(n, money):
    dp = [0 for _ in range(n + 1)]
    dp[0] = 1

    for coin in money:
        for p in range(coin, n + 1):
            dp[p] += dp[p - coin]
    return dp[n] % MOD

# print(solution(100000, [1]))
print(solution(5, [1, 2, 5]))
print(solution(5, [2, 5]))
