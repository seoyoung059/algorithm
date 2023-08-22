function solution(name, yearning, photo) {
    var answer = [];
    var yearningDict = {};
    name.map((n, idx)=>{
        yearningDict[n] = yearning[idx];
    });
    photo.forEach((arr)=>{
        var score = 0;
        arr.forEach((n)=>{
            if (yearningDict[n]){
            score+=yearningDict[n];}
        })
        answer.push(score);
    })
    return answer;
}