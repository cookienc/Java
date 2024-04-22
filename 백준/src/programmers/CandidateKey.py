from itertools import combinations


def is_subtuple(subtuple, target_keys):

    return False


def is_minimal_key(key, candidate_keys):
    for candidate_key in candidate_keys:
        if len(candidate_key) > len(key):
            continue

        duplicate = 0
        for k in candidate_key:
            if k in key:
                duplicate += 1

        if duplicate == len(candidate_key):
            return False
    return True


def solution(relation):
    R = len(relation)
    C = len(relation[0])

    keys = set()

    for c in range(C):
        keys.add(c)

    candidate_key = set()
    for i in range(1, C + 1):
        for combi in combinations(keys, i):
            compare = set()
            already_in = False
            for r in range(R):
                tmp = []
                for cc in combi:
                    tmp.append(relation[r][cc])
                if tuple(tmp) in compare:
                    already_in = True
                    break
                else:
                    compare.add(tuple(tmp))

            # 유일성 만족
            if not already_in:
                # 최소성 만족
                if is_minimal_key(tuple(combi), candidate_key):
                    candidate_key.add(tuple(combi))

    return len(candidate_key)


print(solution([["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"],
                ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]))
print(solution(
    [['a', 1, 'aaa', 'c', 'ng'], ['b', 1, 'bbb', 'c', 'g'], ['c', 1, 'aaa', 'd', 'ng'], ['d', 2, 'bbb', 'd', 'ng']]))
print(solution(
    [  [ "a","1","aaa","c","ng" ],
      [ "a","1","bbb","e","g" ],
      [ "c","1","aaa","d","ng" ],
      [ "d","2","bbb","d","ng" ] ]
))
