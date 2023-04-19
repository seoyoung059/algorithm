n=int(input())

def sol(n):
    sum = 0
    if n<0:
        return 0
    elif n<2:
        return 1
    else:
        return sol(n-3)+sol(n-2)+sol(n-1)

for i in range(n):
    k=int(input())
    print(sol(k))