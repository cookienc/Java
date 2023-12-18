words = list(map(str, input()))
answer = [0] * 26
for w in words:
    index = ord(w) - ord('a')
    answer[index] += 1
print(*answer)
