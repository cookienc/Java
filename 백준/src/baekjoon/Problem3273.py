n = int(input())
io = list(map(int, input().split()))
numbers = [0] * 2000001
x = int(input())

count = 0
for i in io:
    if numbers[x - i] > 0:
        count += numbers[x - i]
    numbers[i] += 1
print(count)
