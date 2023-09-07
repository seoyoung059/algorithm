def solution(phone_book):
    answer = True
    phone_book.sort()
    num_dict = {}
    prev_len = 0
    for phone_num in phone_book:
        if prev_len >= len(phone_num):
            num_dict={}
        for k in num_dict.keys():
            if k == phone_num[:len(k)]:
                return False
        num_dict[phone_num]=1
        prev_len = len(phone_num)
            
    return answer