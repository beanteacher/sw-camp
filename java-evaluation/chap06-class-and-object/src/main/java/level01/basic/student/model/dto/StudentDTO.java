package level01.basic.student.model.dto;

public class StudentDTO {

    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO() {}

    public StudentDTO(int grade, int classroom, String name, int kor, int eng, int math) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getClassroom() {
        return this.classroom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setKor(int kor) {
        this.kor = kor;

        if(kor > 100 || kor < 0) {
            System.out.println("점수는 0점과 100점 사이의 수 입니다. 이외의 값 입력하여 국어 점수는 0점입니다.");
            this.kor = 0;
        }
    }

    public int getKor() {
        return this.kor;
    }

    public void setEng(int eng) {
        this.eng = eng;

        if(eng > 100 || eng < 0) {
            System.out.println("점수는 0점과 100점 사이의 수 입니다. 이외의 값 입력하여 영어 점수는 0점입니다.");
            this.eng = 0;
        }
    }

    public int getEng() {
        return this.eng;
    }

    public void setMath(int math) {
        this.math = math;

        if(math > 100 || math < 0) {
            System.out.println("점수는 0점과 100점 사이의 수 입니다. 이외의 값 입력하여 수학 점수는 0점입니다.");
            this.math = 0;
        }
    }

    public int getMath() {
        return this.math;
    }

    public String getInformation(StudentDTO student) {

        return "학년="+student.grade+", "+
                    "반="+student.classroom+", "+
                    "이름="+student.name+", "+
                    "국어="+student.kor+", "+
                    "영어="+student.eng+", "+
                    "수학="+student.math+", "+
                    "평균="+(student.kor+student.eng+student.math)/3;
    }
}
