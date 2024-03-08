import sys

EMPTY = (-1, -1)

input = sys.stdin.readline

N, T, P = map(int, input().split())
reservations = []
for _ in range(T):
    st, en = map(str, input().split())
    if st == en:
        continue
    st = int(st[:2]) * 60 + int(st[2:])
    en = int(en[:2]) * 60 + int(en[2:])
    reservations.append((st, en))

reservations.sort(key=lambda x: (x[0], x[1] - x[0]))
reservations.append((0, 0))

answer = 0
occupied = [EMPTY for _ in range(N)]


def out(time):
    global occupied
    for i in range(N):
        if occupied[i][1] <= time:
            occupied[i] = EMPTY


def sit(name):
    global occupied, N, reservations
    distance = [0 for _ in range(N)]
    for i in range(N):
        d = N - 1
        for j in range(N):
            if occupied[j] != EMPTY:
                d = min(d, abs(i - j))
        distance[i] = d

    idx = 0
    d = 0
    for i in range(N):
        if d < distance[i]:
            d = distance[i]
            idx = i

    occupied[idx] = reservations[name]


def check():
    global occupied, P, answer, time
    if occupied[P - 1] == EMPTY:
        answer += 1


name = 0
for time in range(540, 1260):
    out(time)
    while time == reservations[name][0]:
        sit(name)
        name += 1
    check()

print(answer)
