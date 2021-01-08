function solution(stones, k) {
    var answer = 0;
    
    let check = true;
    while(check){
        for(let i = 0; i<stones.length; i++){
            if (stones[i]===0){
                let count = 0;
                while(i<stones.length && count<k){
                    if(stones[i]>0){
                        stones[i]--;
                        break;
                    }
                    count++;
                    i++;
                }
                if(count>=k){
                    check = false;
                }
            }else{
                stones[i]--;
            }
        }
        if(check){
            answer++;
        }
    }
    return answer;
}