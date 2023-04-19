import sys
input=sys.stdin.readline

def size(case, start,end):
    if start==end:
        return case[start]
    
    else:
        mid=(start+end)//2
        left_max = size(case,start,mid)
        right_max = size(case,mid+1,end)
        height = min(case[mid],case[mid+1])

        left=mid
        right=mid+1
   
        width = 2
        mid_size = width*height

        while True:
            if (left==start or case[left]==0) and (right==end or case[right]==0):
                break
            elif (left==start or case[left]==0):
                if case[right+1] < height:
                    height = case[right+1]
                right += 1
            elif (right==end or case[right]==0):
                if case[left-1] < height:
                    height = case[left-1]
                left -= 1
            else:
                if case[left-1] > case[right+1]:
                    if case[left-1] < height:
                        height = case[left-1]
                    left-=1
                else:
                    if case[right+1] < height:
                        height = case[right+1]
                    right+=1
            width += 1
            mid_size=max(mid_size, width*height)
        return max(left_max, right_max, mid_size)

    
n=int(input())
case=[]
for i in range(n):
    case.append(int(input()))

print(size(case,0,n-1))
