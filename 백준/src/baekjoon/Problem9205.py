from queue import PriorityQueue


class Node:
    def __init__(self, p, v):
        self.p = p
        self.v = v

    def __lt__(self, other):
        return self.p < other.p


def bfs(st, en, line):
    visited = [False] * (n + 2)
    visited[st] = True

    pq = PriorityQueue()
    pq.put(Node(st, visited))

    while not pq.empty():
        cur = pq.get()
        cr = line[cur.p][0]
        cc = line[cur.p][1]

        if cur.p == en:
            return True

        for i in range(len(line)):
            if i == cur.p or cur.v[i]:
                continue
            nr = line[i][0]
            nc = line[i][1]

            if abs(cr - nr) + abs(cc - nc) <= 1000:
                cur.v[i] = True
                pq.put(Node(i, cur.v))

    return False


t = int(input())
for _ in range(t):
    n = int(input())
    con = []
    con.append(list(map(int, input().split())))
    for _ in range(n):
        con.append(list(map(int, input().split())))
    con.append(list(map(int, input().split())))

    if not con[n + 1]:
        print("sad")
        continue

    print("happy" if bfs(0, n + 1, con) else "sad")
