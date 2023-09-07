import math
def solution(progresses, speeds):
    answer = []
    cnt = 1
    max_days = math.ceil((100-progresses[0])/speeds[0])
    for i in range(1,len(progresses)):
        days = math.ceil((100-progresses[i])/speeds[i])
        print(days, max_days)
        if days > max_days:
            max_days = days
            answer.append(cnt)
            cnt=1
            continue
        cnt+=1
    answer.append(cnt)
    return answer