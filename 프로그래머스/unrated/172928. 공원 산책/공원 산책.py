def solution(park, routes):
    answer = []
    h = len(park)
    w = len(park[0])
    direction = {"E":[0,1], "W":[0,-1],"N":[-1,0], "S":[1,0]}
    
    for i in range(len(park)):
        idx = park[i].find("S")
        if idx!=-1:
            start = [i,idx]
            break

    now = start
    for r in routes:
        d, move = r.split()
        dir = direction[d]
        start = now
        for i in range(int(move)):
            next = [now[0]+dir[0], now[1]+dir[1]]
            if -1<next[0] and next[0]<h and -1<next[1] and next[1]<w:
                if park[next[0]][next[1]]!="X":
                    now = next
                else:
                    now = start
                    break
            else:
                now = start
                break
    return now