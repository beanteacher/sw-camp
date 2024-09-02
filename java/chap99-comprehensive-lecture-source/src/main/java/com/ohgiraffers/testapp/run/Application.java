package com.ohgiraffers.testapp.run;

import com.ohgiraffers.testapp.aggregate.BloodType;
import com.ohgiraffers.testapp.aggregate.User;
import com.ohgiraffers.testapp.service.UserService;

import java.util.Scanner;

public class Application {

    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: userService.findAllUser(); break;
                case 2: userService.findUserByNo(chooseNo()); break;
                case 3: userService.registUser(signUp()); break;
                case 4:
                    User selected = userService.findUserForModify(chooseNo());
                    if (selected == null) continue;
                    userService.modifyUser(reform(selected));
                    break;
                case 5: userService.removeUser(chooseNo()); break;
                case 9:
                    System.out.println("회원 관리 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘 못 입력했습니다.");
            }

        }

    }

    private static int chooseNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("회원 번호 입력 : ");
        return scanner.nextInt();
    }

    private static User reform(User selected) {
        User modifiedUser = selected;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("==== 수정 서브 메뉴 ====");
            System.out.println("1. 아이디");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("5. 메인 메뉴로 돌아가기");
            System.out.print("내용을 선택하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();
            switch(chooseNo) {
                case 1:
                    System.out.print("수정 할 아이디를 입력하세요: ");
                    modifiedUser.setId(sc.nextLine());
                    break;
                case 2:
                    System.out.print("수정 할 나이를 입력하세요: ");
                    modifiedUser.setAge(sc.nextInt());
                    break;
                case 3:
                    modifiedUser.setHobbies(resetHobbies());
                    break;
                case 4:
                    modifiedUser.setBloodType(resetBloodType());
                    break;
                case 5:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return selected;
                default:
                    System.out.println("번호를 다시 제대로 입력해 주세요: ");
            }

            return modifiedUser;
        }
    }

    private static BloodType resetBloodType() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정 할 혈액형을 입력하세요(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt = switch (bloodType) {
            case "A" -> BloodType.A;
            case "AB" -> BloodType.AB;
            case "B" -> BloodType.B;
            case "O" -> BloodType.O;
            default -> null;
        };

        return bt;
    }

    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);

        System.out.print("수정 할 취미 개수를 입력하세요(숫자로 1 이상): ");
        int length = sc.nextInt();
        sc.nextLine();

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        return hobbies;
    }

    private static User signUp() {
        User newUser = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.print("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("입력 할 취미 개수를 입력하세요(숫자로 1 이상): ");
        int length = sc.nextInt();
        sc.nextLine();          // 버퍼의 개행문자 처리용

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        System.out.print("혈액형을 입력하세요(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt = switch (bloodType) {
            case "A" -> BloodType.A;
            case "AB" -> BloodType.AB;
            case "B" -> BloodType.B;
            case "O" -> BloodType.O;
            default -> null;
        };

        /* 회원으로부터 회원가입을 위한 정보를 입력받아 Member 타입 객체 하나로 가공 처리할 방법이 두 가지가 있다.
         *  1. 생성자 방식(장: 한줄 코딩, 단: 따로 생성자 추가 및 생성자의 매개변수가 다소 늘어날 수 있음(리펙토링 징조)
         *  2. setter 방식(장: 초기화 할 갯수 수정 용이, 가독성이 좋음, 단: 코드의 줄 수가 늘어남)
         * */
        newUser = new User(id, pwd, age, hobbies);

        newUser.setBloodType(bt);

        return newUser;
    }
}
