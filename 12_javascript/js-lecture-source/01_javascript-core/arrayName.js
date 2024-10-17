function Student(firstName, lastName, score){
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
}

const studentList = [
    new Student('길동', '홍', 60),
    new Student('보고', '장', 70),
    new Student('관순', '유', 80)
];

sortFromScore(studentList);
console.log(studentList);
console.log(makeFullName(studentList));

function sortFromScore (arr) {
    // 코드 작성
    arr.sort(function (a, b) {
        if(a.score > b.score) return -1;
        else return 1;
    })
}

function makeFullName(arr){
    // 코드 작성
    return studentList.map(student => ({
        name: `${student.lastName}${student.firstName}`,
        score:student.score
    }))
}