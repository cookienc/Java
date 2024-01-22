def countWorks(cores, time):
    sum = len(cores)
    if time == 0:
        return sum

    for c in cores:
        if c == 1:
            sum += time
            continue
        sum += time // c
    return sum


def findAnswer(cores, time, work):
    sum = countWorks(cores, time - 1)
    for i in range(len(cores)):
        if time % cores[i] == 0:
            sum += 1
        if sum == work:
            return i + 1


def solution(n, cores):
    if n <= len(cores):
        return n

    st = 1
    en = max(cores) * n

    while st < en:
        mid = (st + en) // 2

        works = countWorks(cores, mid)
        if works >= n:
            en = mid
        else:
            st = mid + 1

    return findAnswer(cores, st, n)


# print(findLastZero([1,2,3], 2))
# print(solution(7, [1, 2, 3]))
# print(solution(6, [1, 2, 3]))
# print(solution(6, [1, 1, 1]))
print(solution(12, [1, 2, 3, 4]))
# print(countWorks([1, 2, 3, 4], 5))
