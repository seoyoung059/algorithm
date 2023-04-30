import sys
input = sys.stdin.readline

n, k = map(int,input().split())
coin=[]
for _ in range(n):
    coin.append(int(input()))
    
remain=k
cnt=0
for i in range(n-1, -1,-1):
    if coin[i]<=k:
        num=k//coin[i]
        k-=num*coin[i]
        cnt+=num
        
print(cnt)