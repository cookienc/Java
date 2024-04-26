from collections import defaultdict

import sys

input = sys.stdin.readline

words = defaultdict(int)
word = input().strip()
for w in word:
    words[w] += 1

odd = 0
even = 0
for k, v in words.items():
    if v % 2 == 0:
        even += 1
    else:
        odd += 1

even_length = len(word) % 2 == 0
if odd > 1:
    print("I'm Sorry Hansoo")
    exit()
elif odd == 1 and even_length:
    print("I'm Sorry Hansoo")
    exit()

if even_length:
    result = ''
    for k, v in sorted(words.items()):
        cnt = v // 2
        result += k * cnt
    result += result[::-1]
    print("".join(result))
else:
    result = ''
    tmp = ''
    for k, v in sorted(words.items()):
        if v % 2 == 1:
            cnt = v // 2
            result += k * cnt
            tmp = k
            continue

        cnt = v // 2
        result += k * cnt
    print(result + tmp + result[::-1])
