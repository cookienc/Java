import sys
from itertools import permutations


def solution(n, weak, dist):
    size = len(weak)
    weak = weak + [w + n for w in weak]

    answer = sys.maxsize
    for start in range(size):
        for member in permutations(dist, len(dist)):
            for i in range(start, len(weak)):
                count = 0
                search = 0
                isEnd = False
                for j in range(0, len(dist)):
                    count += 1
                    distance = weak[i] + member[j]

                    while distance >= weak[i]:
                        search += 1
                        i += 1
                        if search >= size:
                            isEnd = True
                            answer = min(answer, count)
                            break

                    if isEnd:
                        break

                if isEnd or i >= len(dist):
                    break

    return answer if answer != sys.maxsize else -1


print(solution(12, [1, 5, 6, 10], [1, 2, 3, 4]))
print(solution(12, [1, 3, 4, 9, 10], [3, 5, 7]))
print(solution(16, [1, 2, 3, 4, 5, 7, 8, 10, 11, 12, 14, 15], [4, 2, 1, 1]))
# print(solution(50, [1, 2, 3, 4, 5, 6, 30, 33, 36], [6, 2, 2]))
# print(solution(50, [1], [6]))
# print(solution(30, [0, 3, 11, 21], [10, 4]))
# print(solution(200, [0, 100], [1, 1]))
# print(solution(6, [1, 2, 4, 5], [1, 1]))
# print(solution(12, [10, 0], [1, 2]))
# print(solution(1, [0], [100]))
