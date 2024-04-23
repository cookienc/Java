import heapq


def solution(book_time):
    rooms = []
    book_time.sort(key=lambda x: x[0])

    maxCnt = -1
    for start, end in book_time:
        start = int(start[0:2]) * 60 + int(start[3:5])
        end = int(end[0:2]) * 60 + int(end[3:5]) + 10
        if not rooms:
            heapq.heappush(rooms, end)
            maxCnt = max(maxCnt, 1)
        else:
            top_end = heapq.heappop(rooms)
            if top_end > start:
                heapq.heappush(rooms, top_end)
                heapq.heappush(rooms, end)
                maxCnt = max(maxCnt, len(rooms))
            else:
                heapq.heappush(rooms, end)
                maxCnt = max(maxCnt, len(rooms))

    return maxCnt

print(solution([["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]))
print(solution([["15:00", "17:00"]]))
print(solution([["09:10", "10:10"], ["10:10", "12:20"]]	))
print(solution([["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	))
