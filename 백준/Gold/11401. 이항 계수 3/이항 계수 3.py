n,k = map(int, input().split())
div = 1000000007

def factorial(n):
    ans = 1
    for i in range(2, n+1):
        ans = (ans*i)%div
    return ans

def square(n,k):
    if k == 0:
        return 0
    elif k==1:
        return n
    
    tmp = square(n, k//2)
    if k%2:
        return tmp*tmp*n%div
    else:
        return tmp*tmp%div
    
upper = factorial(n)
lower = factorial(n-k)*factorial(k)%div

print(upper * square(lower, div-2)%div)