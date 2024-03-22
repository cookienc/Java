from collections import defaultdict

def solution(N, number):
    s = defaultdict(lambda: set())

    if N == number:
        return 1
    idx = 1
    while idx <= 8:
        if idx == 1:
            s[idx].add(N)
            idx += 1
            continue

        n = str(N)
        tmp = n
        cnt = 1
        while cnt < idx:
            tmp += n
            cnt += 1
        s[idx].add(int(tmp))
        for num in s[idx - 1]:
            s[idx].add(num * N)
            s[idx].add(num // N)
            s[idx].add(num + N)
            s[idx].add(num - N)
        for j in range(0, idx):
            for t1 in s[idx - (idx - j)]:
                for t2 in s[idx - j]:
                    s[idx].add(t1 * t2)
                    if t2 != 0:
                        s[idx].add(t1 // t2)
                    s[idx].add(t1 + t2)
                    s[idx].add(t1 - t2)

        if s[idx].__contains__(number):
            return idx

        idx += 1

    return -1
