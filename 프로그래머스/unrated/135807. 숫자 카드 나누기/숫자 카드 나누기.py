def solution(arrayA, arrayB):
    def arr_uclid(arr):
        n=len(arr)
        tmp = arr[0]
        for i in range(1,n):
            tmp = uclid(arr[i], tmp)
        return tmp

    def uclid(a,b):
        div = a%b
        if div == 0:
            return b
        else:
            return uclid(b,div)
    answer = 0
    arrayA.sort()
    arrayB.sort()
    a_tmp = arr_uclid(arrayA)
    for b in arrayB:
        if b % a_tmp==0:
            a_tmp = 0
            break
    b_tmp = arr_uclid(arrayB)
    for a in arrayA:
        if a % b_tmp==0:
            b_tmp = 0
            break
    answer = max(a_tmp, b_tmp)
    return answer

