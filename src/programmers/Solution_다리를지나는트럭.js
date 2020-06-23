function solution(bridge_length, weight, truck_weights) {
    let bw = 0;
    let bTrucks = [];
    var answer = 0;
    
    for(let i = 0;i<truck_weights.length; ){
        if(bw+truck_weights[i]<=weight && bTrucks.length+1<=bridge_length){
            answer++;
            bw += truck_weights[i];
            let arr = [answer,truck_weights[i]];
            bTrucks.push(arr);
            i++;
        }else{
            let t = bTrucks.shift();
            answer = t[0]+bridge_length-1;
            bw -= t[1];
        }
        if(bTrucks.length>0 && bTrucks[0][0]+bridge_length===answer){
            let t = bTrucks.shift();
            bw -= t[1];
        }
    }
    return bTrucks.pop()[0]+bridge_length;
}