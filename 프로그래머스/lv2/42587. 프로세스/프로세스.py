import heapq

def solution(priorities, location):
    answer = 0
    hq = []
    for i in range(len(priorities)):
        heapq.heappush(hq, -priorities[i])
    idx = 0
    while priorities:
        if priorities[idx] == -hq[0]:
            answer+=1
            if idx == location:
                return answer
            priorities.pop(idx)
            heapq.heappop(hq)
            if idx < location:
                location -= 1
        else:
            idx += 1
        if idx == len(priorities):
            idx = 0
    
    return answer