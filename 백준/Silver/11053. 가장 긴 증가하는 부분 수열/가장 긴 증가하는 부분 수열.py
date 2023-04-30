import sys
input = sys.stdin.readline

n=int(input())
arr=list(map(int,input().split()))


arr2=[1]*n
for i in range(n):
    val=0
    for j in range(i):
        if arr[j]<arr[i]:
            val = max(val, arr2[j])
    arr2[i]=val+1
    
print(max(arr2))