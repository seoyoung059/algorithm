import sys
input = sys.stdin.readline

n=int(input())

def mooLength(n):
    l=0
    k=0
    while True:
        if n<l*2+k+3:
            break
        l=2*l+k+3
        k+=1
    return k,l

def sol(n):
    k,prev_l=mooLength(n)
    if n-prev_l < k+3:
        if n-prev_l-1==0:
            print('m')
        else:
            print('o')
    else:
        sol(n-prev_l-k-3)

sol(n)
