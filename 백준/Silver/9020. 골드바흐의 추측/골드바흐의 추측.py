import math
t = int(input())


def prime(n):
    for i in range(2,n):
        if n%i==0:
            return False
    return True
   

for i in range(t):
    n=int(input())
    for j in range(n//2, 1,-1):
        if prime(j) and prime(n-j):
            print(j, n-j)
            break
        