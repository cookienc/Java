from collections import deque

answer = []

def bfs(tickets):
    pq = deque()
    for i in range(len(tickets)):
        st, en = tickets[i]
        if st == 'ICN':
            visited = [False for _ in range(len(tickets))]
            visited[i] = True
            route = [st, en]
            pq.append((st, en, visited, route))

    while pq:
        cst, cen, visited, route = pq.popleft()

        if len(route) == len(tickets) + 1:
            answer.append(route)
            continue

        for i in range(len(tickets)):
            st, en = tickets[i]

            if visited[i]:
                continue
            if st != route[-1]:
                continue

            copyRoute = route.copy()
            copyRoute.append(en)
            copyVisited = visited.copy()
            copyVisited[i] = True
            pq.append((st, en, copyVisited, copyRoute))

def solution(tickets):
    bfs(tickets)
    answer.sort()
    return answer[0]

print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))
