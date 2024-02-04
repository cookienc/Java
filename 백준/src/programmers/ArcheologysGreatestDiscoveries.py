def rotate(clockHands, r, c, roationCount):
    moves = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    clockHands[r][c] = (clockHands[r][c] + roationCount) % 4
    for i in range(4):
        nr = r + moves[i][0]
        nc = c + moves[i][1]
        if nr < 0 or nc < 0 or nr >= len(clockHands) or nc >= len(clockHands):
            continue
        clockHands[nr][nc] = (clockHands[nr][nc] + roationCount) % 4


def solution(clockHands):
    n = len(clockHands)
    answer = 3 ** n + 1
    origin = clockHands
    for rotations in range(4 ** n):
        clockHands = [row[:] for row in origin]
        totalRotations = 0
        for c in range(n):
            rotationCount = rotations % 4
            totalRotations += rotationCount
            rotate(clockHands, 0, c, rotationCount)
            rotations >>= 2

        for r in range(1, n):
            for c in range(n):
                rotationCount = abs(clockHands[r - 1][c] - 4) % 4
                if rotationCount == 0:
                    continue
                totalRotations += rotationCount
                rotate(clockHands, r, c, rotationCount)

        if sum(clockHands[-1]) == 0:
            answer = min(answer, totalRotations)

    return answer


print(solution([[0, 3, 3, 0], [3, 2, 2, 3], [0, 3, 2, 0], [0, 3, 3, 3]]))
# print(solution([[3, 3, 0, 0], [3, 0, 0, 0], [0, 3, 0, 0], [0, 0, 0, 0]]))
