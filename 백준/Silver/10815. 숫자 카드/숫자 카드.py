n = int(input())
sanggeun = list(map(int, input().split()))

m = int(input())
cards = list(map(int,input().split()))

sanggeun.sort()

ans=[]
for c in cards:
    find = False
    s = 0
    e = len(sanggeun)
    while s<e:
        m = (s+e)//2
        if sanggeun[m] > c:
            e = m
        elif sanggeun[m] < c:
            s = m + 1
        else:
            find = True
            break
    if find:
        ans.append(1)
    else:
        ans.append(0)

print(' '.join(map(str,ans)))