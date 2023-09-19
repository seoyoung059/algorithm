from collections import deque
def solution(order):
    answer = 0
    n = len(order)
    order = deque(order)
    main = deque([i for i in range(1,n+1)])
    sub = deque()
    
    while True:
        # print(main, sub, order)
        if len(main)>0:
            if main[0] == order[0]:
                order.popleft()
                main.popleft()
                answer+=1
                continue
        if len(sub)>0:
            if sub[-1] == order[0]:
                order.popleft()
                sub.pop()
                answer+=1
                continue
        if len(main)>0:
            sub.append(main.popleft())
        else:
            break
            
    return answer