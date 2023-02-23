function solution(m, n, board) {
    board = board.map(v=>v.split(''));
    // map : map함수를 적용하는 변수의 길이만큼 반복해서 실행되는데, board의 n번째 값을 한 글자씩 나눈다.
    while(true){
        let founded = [];
        // 4블록이 같은 경우 마지막 블록의 좌표를 넣기 위한 배열
        for(let i=1;i<m;i++){
            for(let j=1;j<n;j++){
                if(board[i][j] && board[i][j]===board[i][j-1]&&board[i][j]===board[i-1][j]&&board[i][j]=== board[i-1][j-1]){
                    founded.push([i,j]);
                }
            }
        }
        // founded에 아무것도 없다면
        // concat : 인자로 주어진 값들을 기존 배열에 합쳐서 새 배열을 반환한다.
        // ... : 전개구문. 배열이나 문자열같이 반복 가능한 문자를 0개 이상의 인수로 확장하여 0개 이상의 키-값 쌍으로 확장할 수 있다.
        // ...하면, 배열의 인덱스마다 각각의 값이 드러나는데, 그냥 배열 이름만 적으면 각 배열의 값이 배열인 경우 Array(n)으로만 나타난다.
        // filter : 주어진 함수의 테스트를 완료하는 모든 요소를 모아 새로운 배열로 반환한다.
        //여기서는 v를 반전시켜서 내보내는듯. 글자가 있으면 말고, 글자가 없이 0값만 있으면 !!0은 false로 나오는거 보니
        //, !0은 true로 나와서 0만 걸러서 나오게 되고, 그 길이를 return
        if(!founded.length) {
            console.log(...board)
            board[0]=0
            console.log(board)
            return [].concat(...board).filter(v=>!v).length;
        }
        //4블록 같은 애들 값을 다 0으로 바꾸기
        founded.forEach(a=>{
            board[a[0]][a[1]]=0;
            board[a[0]][a[1]-1]=0;
            board[a[0]-1][a[1]-1]=0;
            board[a[0]-1][a[1]]=0;
        });

        //맨 마지막줄부터
        for(let i=m-1;i>0;i--){
            // some : 배열안의 어떤 요소라도, 판별 함수를 하나라도 통과하는지 테스트하고, true or false를 반환한다.
            //        배열의 값은 변환시키지 않는다.
            // 해당 줄의 값이 없는 경우는 패스
            if(!board[i].some(v=>!v)) continue;
            //한칸씩
            for(let j=0;j<n;j++){
                //윗 줄부터 점점 위를 탐색하는데, 현재값이 없는 경우에 계속 탐색한다.
                for(let k=i-1;k>=0&&!board[i][j];k--){
                    //탐색 값이 있는 경우
                    if(board[k][j]){
                        //탐색 값을 현재 값으로 보내고
                        board[i][j]=board[k][j];
                        //탐색 값을 없앤다.
                        board[k][j]=0;
                        break;
                    }
                }
            }
        }
    }
}