// length property 는 요소의 개수를 나타내는 0 이상의 정수 값을 가진다.
console.log([].length);
const arr = [1, 2, 3, 4, 5];
console.log(arr.length);

// length property 값은 배열에 요소를 추가하거나 삭제하면 자동으로 갱신 된다.
arr.push(6);
console.log(arr);
console.log(arr.length);
arr.pop();
console.log(arr);
console.log(arr.length);

// length 프로퍼티에 임의의 값을 명시적으로 할당할 수 있다.
arr.length = 3; // 현재 length 보다 작은 값을 할당하면 배열의 길이가 줄어든다.
console.log(arr);
console.log(arr.length);

// 현재 length 보다 큰 값을 할당하면 length 프로퍼티의 값은 변경 되지만 배열의 길이가 늘어나지는 않는다.
arr.length = 10;
console.log(arr);
console.log(arr.length);
console.log(Object.getOwnPropertyDescriptors(arr));

// 자바스크립트는 배열의 요소가 연속적으로 위치하지 않고 일부가 비어있는 희소 배열을 허용한다.
const sparse = [, 2, , 4];
console.log(sparse);
console.log(sparse.length);
console.log(Object.getOwnPropertyDescriptors(sparse));

// key 값 순회 (length property 미포함)
for(let a in arr) {
    console.log(a);
}
console.log('-------------------');
// value 값 순회 (length 만큼 반복)
for(let a of arr) {
    console.log(a);
}


