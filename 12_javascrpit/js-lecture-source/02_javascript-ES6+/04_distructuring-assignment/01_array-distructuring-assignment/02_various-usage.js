/* 다양한 사용법 */

// 객체 프로퍼티에 사용하기
let user = {};
[user.firstName, user.lasName] = "Gwansoon Yu".split(" ");
console.log(user)
let student = "학생";
let teacher = "선생님";
[teacher, student] = [student, teacher];
console.log(`student : ${student}, teacher : ${teacher}`);

// rest parameter ...로 나머지 요소를 한번에 가져올 수 있다.
let [sign1, sign2 , ...rest] = ['양자리','황소자리',"쌍둥이자리"];