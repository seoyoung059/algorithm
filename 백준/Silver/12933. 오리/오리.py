
sound = list(input())
duck = list('quack')
s_idx = 0
d_idx = 0
cnt = 0
duckexists = True
while sound and duckexists:
  # print("newduck: ",sound)
  duckexists=False
  while s_idx < len(sound):
    if sound[s_idx]==duck[d_idx]:
      sound.pop(s_idx)
      d_idx+=1
      if d_idx ==5:
        duckexists=True
        d_idx = 0
    else:
      s_idx+=1
  # print(duckexists, d_idx, s_idx, sound)
  # if duckexists and d_idx==0:
  if d_idx!=0:
    cnt = -1
    break
  elif duckexists:
    cnt+=1
  if s_idx == len(sound):
    s_idx=0

if sound or cnt == 0:
  print(-1)
else:
  print(cnt)