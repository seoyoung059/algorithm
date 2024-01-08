def solution(n):
    answer = [[0] * i for i in range(1, n+1)]
    move = [(1,0), (0,1), (-1,-1)]
    y, x = 0, 0
    tmp = 0
    cnt, limit = 1, n
    for i in range(1,n*(n+1)//2+1):
        answer[y][x] = i
        y += move[tmp][0]
        x += move[tmp][1]
        cnt+=1
        if cnt >= limit:
            cnt = 0
            limit -=1
            tmp = (tmp+1)%3
            print(i, cnt, limit, tmp)
    return sum(answer,[])