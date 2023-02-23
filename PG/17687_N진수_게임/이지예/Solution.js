function solution(n, t, m, p){
    let answer = '';
    let all='';
    let num=0;
    //toString함수 사용
    while(all.length<t*m){
        all+=num.toString(n);
        num+=1;
    }
    let ind=p-1;
    while(answer.length<t){
        answer+=all.charAt(ind);
        ind+=m;
    }
    return answer.toUpperCase();
}