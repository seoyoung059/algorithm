import heapq
def solution(routes):
    answer = 0
    routes.sort()
    print(routes)
    
    hq = []
    heapq.heappush(hq,(routes[0][1], routes[0][0]))
    
    for car_in, car_out in routes:
        if hq[0][0] >= car_in:
            heapq.heappush(hq, (car_out, car_in))
        else:
            answer += 1
            hq = []
            heapq.heappush(hq, (car_out, car_in))
    answer+=1
    return answer