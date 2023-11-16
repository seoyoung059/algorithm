
n = int(input())

cnt = 0

if n<100:
    print(n)
else:
    cnt = 99
    for i in range(100, n+1):
        tmp = str(i)
        for s in range(len(tmp)-2):
            if int(tmp[s])-int(tmp[s+1]) != int(tmp[s+1])-int(tmp[s+2]):
                break
            if s == len(tmp)-3:
                cnt+=1

    print(cnt)