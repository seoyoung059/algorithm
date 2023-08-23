k,n = map(int, input().split())
line =[]
for i in range(k):
    line.append(int(input()))
    
def line_count(arr, length):
    cnt = 0
    for l in arr:
        cnt+= l // length
    return cnt

def binarySearch(arr,n):
    start = 1
    end = max(arr)

    while start <= end:
        mid = (start+end)//2
        line_num = line_count(arr, mid)
        if line_num < n:
            end = mid - 1
        else:
            start = mid + 1
    
    print(end)
    
binarySearch(line, n)