def solution(arr):
    answer = 0
    tmp = arr[0]
    for i in range(1, len(arr)):
        if tmp < arr[i]:
            tmp2 = uclid(tmp, arr[i])
        else:
            tmp2 = uclid(arr[i], tmp)
        tmp = (tmp*arr[i])/tmp2
    answer = int(tmp)
        
    return answer


def uclid(a,b):
    tmp = b % a
    if tmp == 0:
        return a
    else:
        return uclid(tmp, a)