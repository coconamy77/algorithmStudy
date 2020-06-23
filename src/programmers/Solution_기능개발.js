function solution(progresses, speeds) {
    let days = [];
    
    for(let i = 0; i<progresses.length; i++){
        days.push(Math.ceil((100-progresses[i])/speeds[i]));
    }
    
    var answer = [];
    
    let dep = 1;
    let day = days[0];
   for(let i = 1; i<days.length; i++){
        if(day<days[i]){
            answer.push(dep);
            day = days[i];
            dep = 1;
        }else{
            dep++;
        }
    }
    answer.push(dep);
    
    return answer;
}