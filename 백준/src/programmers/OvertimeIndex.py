import heapq


def solution(n, works):
    pq = []
    for w in works:
        heapq.heappush(pq, (-w, w))
    for _ in range(n):
        priority, cur = heapq.heappop(pq)
        heapq.heappush(pq, (-(cur - 1), cur - 1))

    sum = 0
    while pq:
        p, w = heapq.heappop(pq)
        if w < 0:
            continue
        sum += w ** 2
    return sum


print(solution(4, [4, 3, 3]))
print(solution(1, [2, 1, 2]))
print(solution(3, [1, 1]))
