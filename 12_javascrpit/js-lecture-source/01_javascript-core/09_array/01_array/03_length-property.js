/* length property는 요소의 개수를 나타내는 0 이상의 정수 값을 가진다. */
console.log([].length);
const arr = [1,2,3,4,5]
console.log(arr.length);

arr.push(6)
arr.pop()

/* length 프로퍼티에 임의의 값을 명시적으로 할당할 수 있다. */
arr.length = 3; // 현재 length 보다 작은 값을 할당하면 배열의 길이가 줄어든다.

arr.length = 10;

const sparse = [,2,,4]

for(let a in arr) {
    console.log(a)
}