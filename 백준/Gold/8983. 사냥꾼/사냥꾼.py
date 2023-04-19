import sys
input = sys.stdin.readline

m,n,l = map(int,input().split())
mx = list(map(int, input().split()))
animal = []
for _ in range(n):
    animal.append(list(map(int,input().split())))
    
mx.sort()

cnt=0
for a in animal:
    # print('<----',a,'----->')
    s = 0
    e = m-1
    res = 0
    while s <= e:
        mid=(s+e)//2
        if mx[mid] >= a[0]:
            res = mid
            e = mid-1
        else:
            s = mid+1
    # print(mx[res])
    if abs(mx[res]-a[0])+a[1] <= l:
        cnt+=1
print(cnt)