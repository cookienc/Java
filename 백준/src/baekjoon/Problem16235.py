# N x N
# 처음에 모두 5로 초기화
# M개의 나무를 심음
# 봄 :
# - 자신의 나이만큼 양분을 먹음
# - 나이가 1 증가
# - 같은칸에 여러개 나무가 있으면 어린 나무가 우선순위
# - 못 먹으면 죽음
# 여름 :
# - 죽은 나무 나이 // 2 가 양분으로 변함
# 가을 :
# - 나이가 5의 배수이면 인접한 8개 칸에 나이가 1인 나무 생성
# 겨울 :
# A[r][c]에 양분 추가

import sys
from collections import deque

input = sys.stdin.readline

N, M, K = map(int, input().split())
fertilizer = [[0] * (N + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]
trees = [[deque() for _ in range(N + 1)] for _ in range(N + 1)]
for _ in range(M):
    r, c, age = map(int, input().split())
    trees[r][c].append(age)
breeding = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
deads = deque()
area = [[0] * (N + 1)] + [[0] + [5 for _ in range(N)] for _ in range(N)]



def autumn_winter():
    global area, trees, N
    for r in range(1, N + 1):
        for c in range(1, N + 1):
            ages = trees[r][c]
            tmp_deque = deque()
            while ages:
                age = ages.popleft()
                tmp_deque.append(age)
                if age % 5 == 0:
                    for dr, dc in breeding:
                        nr = r + dr
                        nc = c + dc
                        if nr < 1 or nc < 1 or nr >= N + 1 or nc >= N + 1:
                            continue
                        trees[nr][nc].appendleft(1)
            trees[r][c] = tmp_deque
            area[r][c] += fertilizer[r][c]



def summer():
    global area, deads, N
    while deads:
        r, c, age = deads.pop()
        area[r][c] += age // 2
    deads.clear()


def spring():
    global area, trees, deads
    tmp_set = set()
    for r in range(1, N + 1):
        for c in range(1, N + 1):
            ages = trees[r][c]
            tmp = deque()
            while ages:
                age = ages.popleft()
                if area[r][c] >= age:
                    area[r][c] -= age
                    tmp.append(age + 1)
                    tmp_set.add((r, c))
                else:
                    deads.append((r, c, age))
            trees[r][c] = tmp


while K > 0:
    K -= 1
    spring()
    summer()
    autumn_winter()

cnt = 0
for r in range(1, N + 1):
    for c in range(1, N + 1):
        cnt += len(trees[r][c])
print(cnt)
