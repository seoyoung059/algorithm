def solve(n):
    ans = 0
    for i in range(n):
        tmp = str(i)
        val = i
        for t in tmp:
            val+=int(t)
        if val == n:
            ans = i
            return ans
    return ans

n = int(input())
print(solve(n))