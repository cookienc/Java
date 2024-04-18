import heapq

import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M = int(input())
    arr = []

    if M // 10 == 0:
        arr = list(map(int, input().split()))
    else:
        times = M // 10 + 1
        while times > 0:
            times -= 1
            tmp = list(map(int, input().split()))
            for t in tmp:
                arr.append(t)
    minHeap = []
    maxHeap = []

    answers = []
    for i in range(len(arr)):
        a = arr[i]
        if len(minHeap) <= len(maxHeap):
            heapq.heappush(minHeap, -a)
        else:
            heapq.heappush(maxHeap, a)

        if minHeap and maxHeap and -minHeap[0] > maxHeap[0]:
            minTop = -heapq.heappop(minHeap)
            maxTop = heapq.heappop(maxHeap)
            heapq.heappush(minHeap, -maxTop)
            heapq.heappush(maxHeap, minTop)

        if (i + 1) % 2 == 1:
            if len(minHeap) <= len(maxHeap):
                answers.append(maxHeap[0])
            else:
                answers.append(-minHeap[0])

    print(len(answers))
    if len(answers) // 10 < 1:
        print(*answers)
    else:
        times = len(answers) // 10
        for i in range(times):
            print(*answers[i * 10:(i + 1) * 10])
        print(*answers[times * 10:])
