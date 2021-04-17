function isSuc(stones, k, pass){
    let count = 0;
    for(let i = 0; i<stones.length; i++){
        let stone = stones[i]-pass;
        if (stone<=0){
            count++;
            if(count>=k){
                return false;
            }
        }else{
            count = 0;
        }
    }
    return true;
}

function solution(stones, k) {
    let max = stones[0];
    let min = stones[0];
    stones.forEach(function(stone){
        if(max<stone){
            max = stone;
        }
        if(min>stone){
            min = stone;
        }
    });
    
    let pass = max;
    while(max>=min){
        pass = parseInt((max+min)/2);
        if(isSuc(stones,k,pass)){
            min = pass+1;
        }else{
            max = pass-1;
        }
    }
    
    return min;
}