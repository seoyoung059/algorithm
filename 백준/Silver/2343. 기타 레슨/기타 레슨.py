n,m = map(int,input().split())
lectures = list(map(int, input().split()))

def vidCnt(max_len, n, lectures):
    cnt = 1
    sum = 0
    for i in range(0,n):
        if sum+lectures[i] > max_len:
            cnt+=1
            sum = 0
        sum += lectures[i]
    return cnt

def binarySearch(n,lectures):
    answer = 0
    start = max(lectures)
    end = sum(lectures)
    while start <= end:
        mid = (start + end) // 2
        video_count = vidCnt(mid,n,lectures)
        if video_count > m:
            start = mid +1 
        else:
            end = mid -1
            answer = mid
    print(answer)
    
binarySearch(n,lectures)