package level01.basic.student.run;

import level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDTO[] students = new StudentDTO[10];

        int i = 0;
        int yn = 89;
        try {
            while(yn == 89 || yn == 121) {

                System.out.print("학년 : ");
                int grade = scanner.nextInt();

                System.out.print("반 : ");
                int classroom = scanner.nextInt();

                System.out.print("이름 : ");
                String name = scanner.next();

                System.out.print("국어점수 : ");
                int kor = scanner.nextInt();

                System.out.print("영어점수 : ");
                int eng = scanner.nextInt();

                System.out.print("수학점수 : ");
                int math = scanner.nextInt();

                System.out.print("계속 추가할 겁니까? (y / n) : ");
                yn = scanner.next().charAt(0);

                students[i] = new StudentDTO(grade, classroom, name, kor, eng, math);
                i++;

                if(i == 10) break;
            }

            for(int j = 0; j < i; j++) {
                System.out.println(students[j].getInformation(students[j]));
            }

        } catch (Exception e ) {
            System.out.println(e);
        }

    }
}
