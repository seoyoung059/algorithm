import sys
input = sys.stdin.readline

def fib(n):
    if n<2:
        return ans[n]
    elif n < len(ans):
        return ans[n]
    else:
        ans.append(fib(n-1)+fib(n-2))
        return ans[n]

n=int(input())
ans=[0,1]
print(fib(n))