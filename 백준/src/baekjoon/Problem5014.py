from queue import PriorityQueue

answer = 1_000_001
f, s, g, u, d = map(int, input().split())
isVisited = [answer] * (f + 1)
isVisited[0] = 0

def bfs(f, s, g, u, d):
    global answer
    pq = PriorityQueue()
    pq.put((s, 0))
    isVisited[s] = 0

    while not pq.empty():
        cur = pq.get()
        position = cur[0]
        distance = cur[1]

        if position == g:
            answer = distance
            break

        next = position + u
        nextDistance = distance + 1
        if next <= f and isVisited[next] > nextDistance:
            isVisited[next] = nextDistance
            pq.put((next, nextDistance))
        next = position - d
        if next >= 0 and isVisited[next] > nextDistance:
            isVisited[next] = nextDistance
            pq.put((next, nextDistance))

bfs(f, s, g, u, d)
print(answer if answer != 1_000_001 else 'use the stairs')
