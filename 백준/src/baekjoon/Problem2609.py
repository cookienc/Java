def gcd(a, b):
    n = max(a, b)
    m = min(a, b)
    if n % m == 0:
        return m
    return gcd(m, n - m)

n,m = map(int, input().split())
lcm = gcd(n, m)
gcd = int(n * m / lcm)
print(lcm, gcd, sep="\n")
