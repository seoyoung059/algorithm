def check_around(curr_r, curr_c, n, m, room):
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    for i in range(4):
        next_r = curr_r + dy[i]
        next_c = curr_c + dx[i]
        if 0<=next_r<n and 0<=next_c <m:
            if room[next_r][next_c] == 0:
                return True
    return False

n,m = map(int, input().split())
curr_r, curr_c, curr_d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]

running = True

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
cnt = 0
while running:
    if room[curr_r][curr_c] == 0:
        room[curr_r][curr_c]=-1
        cnt+=1
    else:
        # 주변에 청소되지 않은 빈 칸이 있는 경우
        if check_around(curr_r, curr_c, n, m, room):
            curr_d = (curr_d-1)%4
            next_r = curr_r + dy[curr_d]
            next_c = curr_c + dx[curr_d]
            if 0<=next_r<n and 0<=next_c <m:
                if room[next_r][next_c] == 0:
                    curr_r = next_r
                    curr_c = next_c
        else:
            back_r = curr_r + dy[(curr_d+2)%4]
            back_c = curr_c + dx[(curr_d+2)%4]
            if 0<=back_r<n and 0<=back_c <m:
                if room[back_r][back_c]!=1:
                    curr_r = back_r
                    curr_c = back_c
                else:
                    running = False
            else:
                running = False
print(cnt)