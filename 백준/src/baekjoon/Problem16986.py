import sys

input = sys.stdin.readline

N, k = map(int, input().split())
tables = [list(map(int, input().split())) for _ in range(N)]
kyunghee = list(map(int, input().split()))
minho = list(map(int, input().split()))

answer = 0


def dfs(order_k, order_m, win_j, win_k, win_m, winner, next_player, used):
    global tables, kyunghee, minho, answer, N, k, JI, KY, MI
    if win_k == k or win_m == k:
        return

    if win_j == k:
        print(1)
        sys.exit(0)

    if order_k > 20 or order_m > 20:
        return

    if bin(used).count('1') == N:
        return

    kyunghee_ = kyunghee[order_k] - 1
    minho_ = minho[order_m] - 1

    if (winner == JI and next_player == KY) or (winner == KY and next_player == JI):
        for i in range(N):
            if (used & (1 << i)) == 0:
                if tables[i][kyunghee_] == 2:
                    dfs(order_k + 1, order_m, win_j + 1, win_k, win_m, JI, MI, used | (1 << i))
                elif tables[i][kyunghee_] == 1:
                    dfs(order_k + 1, order_m, win_j, win_k + 1, win_m, KY, MI, used | (1 << i))
                else:
                    dfs(order_k + 1, order_m, win_j, win_k + 1, win_m, KY, MI, used | (1 << i))
        return

    if (winner == JI and next_player == MI) or (winner == MI and next_player == JI):
        for i in range(N):
            if (used & (1 << i)) == 0:
                if tables[i][minho_] == 2:
                    dfs(order_k, order_m + 1, win_j + 1, win_k, win_m, JI, KY, used | (1 << i))
                elif tables[i][minho_] == 1:
                    dfs(order_k, order_m + 1, win_j, win_k, win_m + 1, MI, KY, used | (1 << i))
                else:
                    dfs(order_k, order_m + 1, win_j, win_k, win_m + 1, MI, KY, used | (1 << i))
        return

    result = tables[kyunghee_][minho_]
    if (winner == KY and next_player == MI) or (winner == MI and next_player == KY):
        if result == 2:
            dfs(order_k + 1, order_m + 1, win_j, win_k + 1, win_m, KY, JI, used)
        elif result == 1:
            dfs(order_k + 1, order_m + 1, win_j, win_k, win_m + 1, MI, JI, used)
        else:
            dfs(order_k + 1, order_m + 1, win_j, win_k, win_m + 1, MI, JI, used)
        return


JI = -1
KY = 0
MI = 1
used = 0
dfs(0, 0, 0, 0, 0, JI, KY, used)
print(answer)
