function solution(n){
    let min=n;
    // let que = Array.from(Array(1), () => Array(5000).fill([]))
    let que=[[1,1]];
    // que[1].push;
    console.log(que)
    //빈 2중 배열 만들어놓기
    //1은 1번째 인덱스, 1+1 혹은 1*2는 2번째 인덱스에, n+1혹은 n*n은 n+1번째 인덱스에 넣어서 n이 되는 최소번째 인덱스 출력하기
    while(que.length!=0){
        let num=que.length;
        for(let i=0;i<num;i++){
            let now = que[0];
            que.shift();
            let plusN=[now[0]+1,now[1]+1];
            let mulN=[now[0]*2,now[1]];
            if(plusN[0]===n) {
                if(min>plusN[1]){
                    min=plusN[1];
                }
            }else if(plusN[0]<n){
                if(plusN[1]<min)
                    que.push(plusN);
            }
            if(mulN[0]===n) {
                if(min>now[1]){
                    min=now[1];
                }
            }else if(mulN[0]<n){
                if(mulN[1]<min)
                    que.push(mulN);
            }
        }

    }
    console.log(min)
    return min;
}
solution(5); //2
solution(6); //2
solution(5000); //5

//풀이는 맞는데 시간초과..