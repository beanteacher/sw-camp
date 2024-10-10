/* in 연산자 : 프로퍼티 존재여부 확인 */
var student = {
    name : "유관순",
    age : 16,
    test : undefined
}

console.log(student.name === undefined)
console.log(student.age === undefined)
console.log(student.test === undefined)

console.log("name" in student);
