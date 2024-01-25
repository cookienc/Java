none = [-1]
def solution(n, s):
    quotient = s // n
    answer = []
    if quotient != 0:
        for _ in range(n):
            answer.append(quotient)
        remainder = s % n
        for i in range(remainder):
            answer[i] += 1
    answer.sort()

    return answer if answer else none

print(solution(2, 9))
print(solution(2, 1))
print(solution(2, 8))
