import sys

YES = 'YES'

NO = 'NO'

input = sys.stdin.readline

N = int(input())

heights = list(map(int, input().split()))

if sum(heights) % 3 != 0:
    print(NO)
    exit()


share = 0
rest = 0
for h in heights:
    share += h // 2
    rest += h % 2

diff = share - rest
if diff >= 0 and diff % 3 == 0:
    print(YES)
else:
    print(NO)
