a = int(input())
b = input()

print(*[a * int(c) for c in b][::-1], sep='\n')
print(a * int(b))
