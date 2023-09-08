import heapq

def solution(operations):
    answer = []
    hq1=[]
    hq2=[]
    for o in operations:
        print(hq1, hq2)
        op, num = o.split()
        
        if op == "I":
            heapq.heappush(hq1,int(num))
            heapq.heappush(hq2,-int(num))
        else:
            if not hq1:
                continue
            elif int(num)==1:
                maxpop = heapq.heappop(hq2) * (-1)
                for i in range(len(hq1)-1,-1,-1):
                    if hq1[i]==maxpop:
                        hq1.pop(i)
                        break
            elif int(num)==-1:
                minpop = heapq.heappop(hq1)
                for i in range(len(hq2)-1,-1,-1):
                    if hq2[i]== (-1)*minpop:
                        hq2.pop(i)
                        break
    if not hq1:
        answer=[0,0]
    else:
        answer = [-hq2[0], hq1[0]]
    return answer