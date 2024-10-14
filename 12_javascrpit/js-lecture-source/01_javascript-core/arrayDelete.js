function filterRange(arr, a, b) {
    // 코드 작성
    for(let i = 0; i < arr.length; i++) {
        if(arr[i] < a || arr[i] > b) {
            arr.splice(i, 1);
        }
    }
}

const arr = [5, 3, 8, 1, 10, 4];

filterRange(arr, 1, 5);

console.log(arr);