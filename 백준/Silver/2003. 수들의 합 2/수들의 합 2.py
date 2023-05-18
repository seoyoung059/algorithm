import sys
input = sys.stdin.readline

n,m=map(int,input().split())
a=list(map(int,input().split()))

s=0
e=0
cnt=0
ans=a[0]

while (e<n):
    if ans <= m:
        e+=1
        if ans==m:
            cnt+=1
        if e==n:
            break
        ans+=a[e]
    else:
        ans-=a[s]
        s+=1

print(cnt)