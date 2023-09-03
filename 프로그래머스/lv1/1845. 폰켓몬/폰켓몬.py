def solution(nums):
    answer = 0
    phoneketmon = dict()
    for n in nums:
        # print(phoneketmon.keys())
        if n not in phoneketmon.keys():
            phoneketmon[n]=1
        else:
            phoneketmon[n]+=1
    answer = min(len(nums)//2, len(phoneketmon.keys()))
    return answer