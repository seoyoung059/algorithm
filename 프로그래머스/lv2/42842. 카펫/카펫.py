def solution(brown, yellow):
    answer = []
    ans_tmp = 2+brown/2
    ans_tmp2 = (4+brown**2/4-2*brown-4*yellow)**0.5
    answer = [int((ans_tmp+ans_tmp2)/2),int((ans_tmp-ans_tmp2)/2)]
    return answer