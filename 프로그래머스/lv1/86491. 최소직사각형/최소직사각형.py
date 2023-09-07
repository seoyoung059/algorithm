def solution(sizes):
    answer = 0
    # width is always longer than height
    max_w = 0
    max_h = 0
    for s in sizes:
        s.sort()
        max_w = max(max_w, s[1])
        max_h = max(max_h, s[0])
    answer = max_w * max_h
    return answer