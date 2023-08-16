n = int(input())
sanggeun = list(map(int, input().split()))
m = int(input())
arr = list(map(int, input().split()))
sanggeun.sort()

ans=[]
for i in arr:
    found = False
    start = 0
    end = len(sanggeun)
    while start < end:
        mid = (start+end)//2
        if sanggeun[mid] == i:
            found=True
            break
        elif sanggeun[mid] < i:
            start = mid+1
        elif sanggeun[mid] > i:
            end = mid
    if found:
        ans.append(1)
    else:
        ans.append(0)
print(' '.join(map(str,ans)))