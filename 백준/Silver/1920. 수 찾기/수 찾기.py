n = int(input())
a = list(map(int,input().split()))
m = int(input())
b_list = list(map(int,input().split()))

a.sort()

def sol(a,b_list):
    for b in b_list:
      if binarySearch(a,b,0,len(a)-1):
         print(1)
      else:
         print(0)

def binarySearch(a,b,s,e):
    while s <= e:
        mid=(s+e)//2
        if a[mid]==b:
            return True
        elif a[mid] < b:
            s=mid+1
        else:
            e=mid-1
    return False

sol(a,b_list)