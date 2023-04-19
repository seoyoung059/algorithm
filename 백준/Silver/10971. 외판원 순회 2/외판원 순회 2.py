n = int(input())
ways=[]
for i in range(n):
    city = list(map(int,input().split()))
    ways.append(city)


def solve(n,way,min,ways):
    if len(way)==n:
        price=0
        for i in range(n):
            way_price=ways[way[i-1]][way[i]]
            if way_price==0:
                way_price=min
            price+=way_price
        if price<min:
            min = price
        return min
    for i in range(n):
        if i not in way:
            way.append(i)
            min=solve(n,way,min,ways)
            way.pop()
    return min




min=1000001*n
print(solve(n,[0],min,ways))
        
    
    
    
    