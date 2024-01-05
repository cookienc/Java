def solution(lines):
    times = []

    for line in lines:
        date, time, t = map(str, line.split(' '))
        t = int(float(t[:-1]) * 1000)

        h, m, s = time.split(':')
        ss, ms = s.split('.')
        formating_time = (int(h) * 3600 + int(m) * 60 + int(ss)) * 1000 + int(ms)
        times.append((formating_time - t, formating_time))

    answer = 0
    for i in range(len(lines)):
        cnt = 0
        cur_end = times[i][1]
        for j in range(i, len(lines)):
            if cur_end + 999 > times[j][0]:
                cnt += 1
        answer = max(answer, cnt)
    return answer


lines = [
    "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
]
print(solution(lines))
