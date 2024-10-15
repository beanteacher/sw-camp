/* 스프레드 문법(전개 문법)
* 하날 뭉쳐져 있는 여러 값들의 집합을 전개해서 개별적인 값들의 목록으로 만든다. */
let arr = [10,20,30];

console.log(`가장 큰 값 : ${Math.max(10,20,30)}`)
// 배열이 아닌 숫자 목록을 인수로 받기 때문에 동작하지 않는다.
console.log(`가장 큰 값 : ${Math.max(arr)}`)
// 스프레드 문법을 사용하면 arr이 인수 목록으로 확장 된다.
console.log(`가장 큰 값 : ${Math.max(...arr)}`)

let arr1 = [10,30,20];
let arr2 = [100,300,200];
console.log(`가장 큰 값 : ${Math.max(...arr1, ...arr2)}`); // 배열 객체 여러 개 인수목록으로 확장
console.log(`가장 큰 값 : ${Math.max(0,...arr1,2,...arr2)}`); // 일반 값과 혼합해서 사용

let merged = [0, ...arr1, 2, ...arr2];
console.log(merged);

let str = "JavaScript";
console.log([...str]);