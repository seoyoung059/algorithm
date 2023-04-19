n=int(input())

def movetime(k):
    if k==1:
        return 1
    else:
        return 1+2*movetime(k-1)

def move(n, a, b, c):
    if n==1:
        print(a,c)
    else:
        move(n-1, a, c, b)
        print(a,c)
        move(n-1, b, a, c)
    

print(movetime(n))

if n <= 20:
    move(n,1,2,3)
    