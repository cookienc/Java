import heapq
import sys

input = sys.stdin.readline
n = int(input())
m = int(input())
cities = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    cities[u].append((w, v))

st, en = map(int, input().split())
INF = 100_000_001
distance = [INF for _ in range(n + 1)]
distance[st] = 0
route = [0 for _ in range(n + 1)]

pq = []
heapq.heappush(pq, (0, st))
while pq:
    cw, cv = heapq.heappop(pq)

    if distance[cv] < cw:
        continue

    for nw, nv in cities[cv]:
        if distance[cv] + nw < distance[nv]:
            distance[nv] = distance[cv] + nw
            route[nv] = cv
            heapq.heappush(pq, (nw, nv))
print(distance[en])
cur = en
answer = []
while cur != st:
    answer.append(cur)
    cur = route[cur]
answer.append(cur)
print(len(answer))
print(*reversed(answer))
