let arr = ["1080px", "$100", "+200", "60kg", "6m", "-15"];
console.log(removeChar(arr));

function removeChar(arr){
    // 코드 작성
    return arr.map(item => {
        return Number(item.replace(/[^0-9.-]+/g, ''));
    })
}