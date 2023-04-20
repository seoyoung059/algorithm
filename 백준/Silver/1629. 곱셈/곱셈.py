import sys
input=sys.stdin.readline

a,b,c=map(int,input().split())

def sol(a,b,c):
  if b<2:
    return a%c
  else:
    if b%2 == 0:
      return (sol(a,b//2,c)**2)%c
    else:
      return (sol(a,b-1,c)*sol(a,1,c))%c

print(sol(a,b,c))