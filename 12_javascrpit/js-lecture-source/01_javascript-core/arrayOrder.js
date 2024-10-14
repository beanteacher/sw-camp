let numbers = [20, 100, 37, 54, 88, 9];
let strings = ['wow', 'js', 'party', 'hello'];

// 코드 작성
console.log(numbers.sort());
console.log(numbers.sort(function(a, b)  {
    return a - b;
}));

console.log(strings.sort());
console.log(strings.sort(function(a, b) {
    if(a < b) return 1;
    if(a > b) return -1;
    if(a === b) return 0;
}));