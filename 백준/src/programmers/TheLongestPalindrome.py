def solution(s):
    answer = 1

    length = len(s)

    if length == 0:
        return 0

    if length == 1:
        return 1

    if length == 2:
        if s[0] == s[1]:
            return 2
        return 1

    for i in range(length):
        pa, pb = i - 1, i + 1
        tmp = 1
        answer = max(tmp, answer)

        while 0 <= pa < pb < length:
            if s[pa] == s[pb]:
                tmp += 2
                answer = max(answer, tmp)
                pa -= 1
                pb += 1
                continue
            break

    for i in range(length):
        pa, pb = i - 1, i + 2
        if i + 1 < length and s[i] != s[i + 1]:
            continue
        tmp = 2
        answer = max(tmp, answer)

        while 0 <= pa < pb < length:
            if s[pa] == s[pb]:
                tmp += 2
                answer = max(answer, tmp)
                pa -= 1
                pb += 1
                continue
            break

    return answer

print(solution('aabc'))
