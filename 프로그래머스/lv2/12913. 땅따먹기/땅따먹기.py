def solution(land):
    answer = 0
    row = len(land)
    for j in range(1,row):
        for i in range(4):
            upper_row = land[j-1][:i]+land[j-1][i+1:]
            land[j][i] = land[j][i] + max(upper_row)
    answer = max(land[row-1])
    return answer