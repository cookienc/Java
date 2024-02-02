def turn(clockHands, r, c, cnt):
    dr, dc = [0, 1, 0], [1, 0, -1]
    clockHands[r][c] = (clockHands[r][c] + cnt) % 4

    for d in range(3):
        nr, nc = r + dr[d], c + dc[d]
        if nr < 0 or nr >= len(clockHands) or nc < 0 or nc >= len(clockHands):
            continue
        clockHands[nr][nc] = (clockHands[nr][nc] + cnt) % 4


def solution(clockHands):
    n = len(clockHands)
    origin = clockHands
    answer = 3 ** (n * n)
    for case in range(4 ** n):
        clockHands = [row[:] for row in origin]
        total_cnt = 0
        for c in range(n):
            cnt = case % 4
            total_cnt += cnt
            turn(clockHands, 0, c, cnt)
            case >>= 2

        for r in range(1, n):
            for c in range(n):
                prev_row = clockHands[r - 1][c]
                cnt = (4 - prev_row) % 4
                total_cnt += cnt
                if cnt == 0:
                    continue
                turn(clockHands, r, c, cnt)

        if sum(clockHands[-1]) == 0:
            answer = min(answer, total_cnt)

    return answer


print(solution([[0, 3, 3, 0], [3, 2, 2, 3], [0, 3, 2, 0], [0, 3, 3, 3]]))
# print(solution([[3, 3, 0, 0], [3, 0, 0, 0], [0, 3, 0, 0], [0, 0, 0, 0]]))
