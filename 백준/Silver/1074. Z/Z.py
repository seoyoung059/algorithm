n, r, c = map(int, input().split())


ans = 0

while n  > 0:
    tmp = 0
    if r >= 2**(n-1):
        tmp += 2
        r %= 2**(n-1)
    if c >= 2**(n-1):
        tmp += 1
        c %= 2**(n-1)
    ans = 4*ans + tmp
    n -= 1

print(ans)