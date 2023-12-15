h, m = map(int, input().split())

time = h * 60 + m + int(input())
if time > 1440:
    time -= 1440

h, m = 0, 0
while time >= 60:
    time -= 60
    h += 1
print(h if h < 24 else 0, time)
