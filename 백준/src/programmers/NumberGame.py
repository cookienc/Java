def solution(A, B):
    A.sort(key=lambda x: -x)
    B.sort(key=lambda x: -x)
    cursorA = 0
    cursorB = 0

    length = len(A)

    answer = 0
    while cursorA < length:
        if A[cursorA] < B[cursorB]:
            answer += 1
            cursorA += 1
            cursorB += 1
            continue
        cursorA += 1

    return answer


print(solution([5, 1, 3, 7], [2, 2, 6, 8]))
print(solution([2, 2, 2, 2], [1, 1, 1, 1]))
