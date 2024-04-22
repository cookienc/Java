from collections import deque

import sys

input = sys.stdin.readline

N = int(input())
flowers = []
for _ in range(N):
    st_month, st_day, end_month, end_day = map(int, input().split())
    if st_month == end_month and st_day == end_day:
        continue
    flowers.append((st_month, st_day, end_month, end_day))

flowers = deque(sorted(flowers, key=lambda x: (x[0], x[1], -x[2], -x[3])))

cnt = 0
last_month = 3
last_day = 1
candidates = []

def find_candidates(flowers, last_month, last_day):
    candidates = []
    while flowers:
        st_month, st_day, en_month, en_day = flowers.popleft()

        # 더 작을 경우
        if en_month < last_month or (en_month == last_month and en_day <= last_day):
            continue

        if ((st_month < last_month or (st_month == last_month and st_day <= last_day)) and
                (last_month < en_month or (last_month == en_month and last_day < en_day))):
            candidates.append((st_month, st_day, en_month, en_day))
        else:
            flowers.appendleft((st_month, st_day, en_month, en_day))
            break

    return candidates


while flowers:
    candidates = find_candidates(flowers, last_month, last_day)

    if not candidates:
        flowers.popleft()
        continue

    candidates.sort(key=lambda x: (-x[2], -x[3]))
    st_month, st_day, en_month, en_day = candidates[0]
    last_month = en_month
    last_day = en_day
    cnt += 1

    if last_month >= 12:
        print(cnt)
        exit(0)

print(0)
