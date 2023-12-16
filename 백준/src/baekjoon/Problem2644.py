answer = 101

n = int(input())
relation, isVisited = [[] for _ in range(n)], [False] * n
start, end = map(int, input().split())


def dfs(start, end, depth):
    global answer, relation, isVisited

    if depth >= answer:
        return

    if start == end:
        answer = min(answer, depth)
        return

    if isVisited[start]:
        return

    isVisited[start] = True
    for n in relation[start]:
        if isVisited[n]:
            continue
        dfs(n, end, depth + 1)
    isVisited[start] = False

m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    relation[a - 1].append(b - 1)
    relation[b - 1].append(a - 1)

dfs(start - 1, end - 1, 0)
print(answer if answer != 101 else -1)
