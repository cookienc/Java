import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

info = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    info[A].append((B, C))
    info[B].append((A, C))

from_, to_ = map(int, input().split())


def possible_(weight):
    global info, from_, to_, N
    q = deque()
    q.append(from_)
    visited = [False for _ in range(N + 1)]
    visited[from_] = True

    while q:
        cur = q.popleft()

        if cur == to_:
            return True

        for to, nw in info[cur]:
            if visited[to]:
                continue
            if weight > nw:
                continue

            visited[to] = True
            q.append(to)
    return False


start, end = 1, int(1e9) + 1
while start < end:
    mid = (start + end) // 2
    if possible_(mid):
        start = mid + 1
    else:
        end = mid
print(start - 1)
