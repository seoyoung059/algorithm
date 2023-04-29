import sys
input = sys.stdin.readline

n, k = map(int,input().split())
things=[]
for _ in range(n):
    things.append(list(map(int,input().split())))
    
bag=[0]*(k+1)
things.sort()
for w,v in things:
    for i in range(k,w-1,-1):
        bag[i]=max(bag[i],bag[i-w]+v)
print(bag[-1])