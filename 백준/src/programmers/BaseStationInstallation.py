def findEmpty(n, stations, w):
    empty = []
    for i in range(len(stations)):
        if i == 0:
            cur = stations[i]
            left = cur - w
            if left > 1:
                empty.append((1, left - 1))
        if i == len(stations) - 1:
            cur = stations[i]
            right = cur + w
            if right < n:
                empty.append((right + 1, n))
        before = stations[i - 1]
        cur = stations[i]
        if before + w < cur - w:
            empty.append((before + w + 1, cur - w - 1))
    return empty


def solution(n, stations, w):
    empty = findEmpty(n, stations, w)

    rangeSize = 2 * w + 1
    station = 0
    for e in empty:
        window = e[1] - e[0] + 1
        station += window // rangeSize
        if window % rangeSize != 0:
            station += 1

    return station


print(solution(11, [4, 11], 1))
print(solution(16, [9], 2))
