import heapq
import sys

input = sys.stdin.readline

N, a = map(int, input().split())

tmps = [list(map(int, input().split())) for _ in range(a)]
graphs = [[] for _ in range(N + 1)]
connected = [0 for _ in range(N + 1)]
for a, b in tmps:
    graphs[a].append(b)
    connected[b] += 1

waitings = []
for i in range(1, N + 1):
    if connected[i] == 0:
        heapq.heappush(waitings, i)

answers = []
while len(answers) != N:
    idx = heapq.heappop(waitings)
    answers.append(idx)
    for g in graphs[idx]:
        connected[g] -= 1
        if connected[g] == 0:
            heapq.heappush(waitings, g)

print(*answers)
