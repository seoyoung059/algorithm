import sys
input = sys.stdin.readline

n, b = map(int,input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))
    
def multiply(a,b):
    n=len(a)
    result = []
    for i in range(n):
        res=[]
        for j in range(n):
            s = 0
            for k in range(n):
                s+=a[i][k]*b[k][j]
            res.append(s%1000)
        result.append(res)
    return result


def sol(a,b):
    l=len(a)
    if b==1:
        for i in range(l):
            for j in range(l):
                a[i][j]%=1000
        return a
    elif b%2==0:
        half = sol(a,b//2)
        return multiply(half,half)
    else:
        return multiply(sol(a,b-1),a)
 
ans = sol(a,b)
for r in ans:
    print(*r)