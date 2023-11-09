def solve():
    heights = []
    for i in range(9):
        heights.append(int(input()))
    heights.sort()
    sum_val = sum(heights)

    for i in range(9):
        for j in range(i+1, 9):
            if sum_val-heights[i]-heights[j]==100:
                for k in range(9):
                    if k != i and k != j:
                        print(heights[k])
                return
                        
                        
                        
solve()