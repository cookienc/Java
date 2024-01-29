def getParent(cycles, a):
    if cycles[a] == a:
        return a
    cycles[a] = getParent(cycles, cycles[a])
    return cycles[a]


def union(cycles, st, en):
    st = getParent(cycles, st)
    en = getParent(cycles, en)

    if st < en:
        cycles[en] = st
    else:
        cycles[st] = en


def solution(n, costs):
    costs.sort(key=lambda x: x[2])

    cycles = [i for i in range(n)]
    answer = 0
    for i in range(len(costs)):
        st, en, w = costs[i]

        if getParent(cycles, st) == getParent(cycles, en):
            continue
        union(cycles, st, en)
        answer += w

    return answer

print(solution(4, [[0,1,1],[1,0,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]))
