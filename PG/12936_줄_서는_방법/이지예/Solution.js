function solution(n,k){
    var answer = [];
    var arr= new Array(n).fill(1);
    for(let i=1;i<n;i++)
        arr[i]=arr[i-1]+1;
    //var arr = [];
    //for(let i=0;i<=n;i++){
    //  arr.push(i);
    // } 이게 더 느림
    
    //k-1해주는 이유는 고려하는 수의 갯수가 (n-1)개이기 때문이다.
    //(n-1)!을 기준으로 맨 앞자리 수가 변경되므로 n=k라고 했을 때 k-1개의 수를 고려한다.
    let nth = k-1;
    while(arr.length){
        //nth가 0인 경우는 나누어 떨어진 경우로, 지금 배열 그대로가 순번 그 자체임을 의미한다.
        if(nth===0){
            answer.push(...arr);
            break;
        }
        const fact = factorial(arr.length-1);
        const index = nth/fact>>0; //소수점 제거를 위한 비트연산자
        //현재 값을 정하려면 현재 인덱스 이후의 숫자들을 이용한 순열(n-1)!이 몇 번까지 가능한지 알아야 한다.
        //그래서 fact는 (n-1)!이고 nth는 (n-1)!이 몇 번 나올 수 있는지 체크한다.
        //배열의 인덱스는 0부터 시작하므로, (n-1)!이 나오는 번째의 인덱스를 체크한다.

        //index는 다음번째 순번을 위해 갱신 되어야 한다.
        //지난 횟수만큼 없애기 위해 나머지연산을 해준다.
        nth = nth%fact;

        answer.push(arr[index]);
        //splice함수를 배웠다. 이건 index번째부터 뒤에 적힌 수 만큼의 배열을 잘라낸다는 의미이다.
        arr.splice(index,1);
    }
    return answer;
}
const factorial=(n)=>{
    let res=1;
    for(let i=2;i<=n;i++) res*=i;
    return res;
}
// function solution(n, k) {
//     var answer = [];
//     var notVisit = [];
//     for(let i=0;i<=n;i++){
//         notVisit.push(i);
//         // console.log(notVisit)
//     }
//     //splice(index,1) 이거로 특정 배열 숫자 배기
//     let nextNumLen = 0;
//     while(notVisit.length>2 && nextNumLen<k){
//         let ind = 0;
//         // if(nextNumLen==k) {
//         //     answer.push(notVisit[1]);
//         //     notVisit.splice(1,1);
//         // }
//         while(nextNumLen<k){
//             ind+=1;
//             let recurNum = (recursive(notVisit.length-2))
//             if(recurNum+nextNumLen<=k)
//                 nextNumLen += recurNum;
//             else{
//                 break;
//             }
//         }
//         answer.push(notVisit[ind]);
//         notVisit.splice(ind,1);
//     }
//     for(let i=1;i<notVisit.length;i++){
//         answer.push(notVisit[i])
//     }
//     console.log(answer)
//     return answer;
// }

// function recursive(n){
//     if(n==1) return 1;
//     return recursive(n-1)*n;
// }
solution(5,9);

//순열문제
//n명이 줄을 설 수 있는 모든 경우의 수는 팩토리얼이다.
//근데 n의 최댓값은 20이라서 모든 순열을 구해서 k번째 방법을 찾는 방법으로는 시간복잡도를 통과할 수 없다
//그래서 k번째 순열만 구하는 방법을 생각해야 한다.

