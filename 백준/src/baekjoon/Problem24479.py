import sys
sys.setrecursionlimit(10**5)

input = sys.stdin.readline

N, M, R = map(int, input().split())

edges = [[] for _ in range(N + 1)]
for _ in range(M):
    from_, to_ = map(int, input().split())
    edges[from_].append(to_)
    edges[to_].append(from_)
edges = [sorted(e) for e in edges]


def dfs(edges, start):
    global order

    for edge in edges[start]:
        if answer[edge] == 0:
            answer[edge] = order
            order += 1
            dfs(edges, edge)


answer = [0] * (N + 1)
order = 1
answer[R] = order
order += 1
dfs(edges, R)


print(*answer[1:], sep='\n')
