import sys
input = sys.stdin.readline

n=int(input())
arr=list(map(int,input().split()))
arr2=[[0]*(n) for _ in range(n)]


max_val=0
for i in range(n):
    for j in range(i,n):
        if i==j:
            arr2[i][j]=1
        else:
            val=0
            for k in range(j-1,i-1,-1):
                if arr[k]<arr[j]:
                    val = max(val,arr2[i][k])
            arr2[i][j]=val+1
    max_val=max(max_val, max(arr2[i]))
    
print(max_val)