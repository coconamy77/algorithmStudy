function pass(num,times){
    let count = 0;
    times.forEach(time=>{
        count+=Math.floor(num/time);
    })
    return count;
}

function solution(n, times) {
    var answer = 0;
    var left = times[0];
    var right = times[0];
    times.forEach(time=>{
        if(time>right){
            right = time;
        }
        if(time<left){
            left = time;
        }
    })
    
    right = right*n;
    left = left;
    while(right-left>1){
        var mid = Math.floor((right+left)/2);
        console.log(left,mid, right)
        if(pass(mid,times)>=n){
            answer = mid;
            right = mid;
        }else{
            left = mid;
        }
    }
    
    return answer;
}