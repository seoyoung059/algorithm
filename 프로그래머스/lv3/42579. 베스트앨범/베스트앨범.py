import heapq

def solution(genres, plays):
    answer = []
    genre_sort = {}
    for i in range(len(genres)):
        if genres[i] in genre_sort.keys():
            genre_sort[genres[i]][0]+=plays[i]
            if len(genre_sort[genres[i]][1]) < 2:
                genre_sort[genres[i]][1].append(i)
                genre_sort[genres[i]][1].sort(reverse=True, key = lambda x:plays[x])
            elif plays[genre_sort[genres[i]][1][0]] < plays[i]:
                genre_sort[genres[i]][1][1] = genre_sort[genres[i]][1][0]
                genre_sort[genres[i]][1][0] = i
            elif plays[genre_sort[genres[i]][1][1]] < plays[i]:
                genre_sort[genres[i]][1][1] = i
        else:
            genre_sort[genres[i]]=[plays[i],[i]]
        # print(genre_sort)
    
    ans_arr = sorted(genre_sort.items(), key = lambda x:-x[1][0])
    for a in ans_arr:
        answer = answer + a[1][1]
    return answer