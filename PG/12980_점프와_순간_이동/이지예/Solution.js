function solution(n){
    let min=0;//결과로 나올 값
    while(n>0){ //n을 다 처리하기 전까지 멈추지 않음
        if(n%2===0){ //2의 배수면 
            n/=2; //2로 나누고
        }else{ //2의 배수가 아니면
            n--; //1 빼주고
            min++; //횟수 1 늘려준다.
        }
    }
    return min;
}
solution(5); //2
solution(6); //2
solution(5000); //5

