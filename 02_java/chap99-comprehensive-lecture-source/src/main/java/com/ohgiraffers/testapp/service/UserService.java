package com.ohgiraffers.testapp.service;

import com.ohgiraffers.testapp.aggregate.User;
import com.ohgiraffers.testapp.repository.UserRepository;

import java.util.ArrayList;

/* 트랜잭션 처리(성공 실패에 따른 commit/rollback) 및 비즈니스 로직 처리 */
public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void findAllUser() {
        ArrayList<User> findUsers = userRepository.selectAllUsers();

        for(User user : findUsers) {
            System.out.println("user = " + user);
        }
    }

    public void findUserByNo(int no) {
        User selectedUser = userRepository.selectUserByNo(no);

        if(selectedUser != null) {
            System.out.println(selectedUser);
        } else {
            System.out.println("해당 번호를 가진 회원은 없습니다.");
        }
    }

    public void registUser(User user) {

        int lastMemberNo = userRepository.selectLastUserNo();
        user.setNo(lastMemberNo + 1);

        int result = userRepository.insertUser(user);

        if(result == 1)
            System.out.println(user.getId() + "님 회원 가입이 완료 되었습니다.");
            /* DBMS와의 연동을 할 경우 commit, rollback 등의 처리 */

    }

    public void removeUser(int no) {
        int result = userRepository.deleteUser(no);

        if(result == 1) {
            System.out.println("회원 탈퇴가 완료 되었습니다.");
        } else {
            System.out.println("입력하신 회원 번호에 해당하는 회원이 없습니다.");
        }
    }

    public User findUserForModify(int no) {

        User selectedUser = userRepository.selectUserByNo(no);

        if(selectedUser != null) {
            User newInstance = new User();
            newInstance.setNo(selectedUser.getNo());
            newInstance.setId(selectedUser.getId());
            newInstance.setPwd(selectedUser.getPwd());
            newInstance.setAge(selectedUser.getAge());
            newInstance.setBloodType(selectedUser.getBloodType());
            newInstance.setHobbies(selectedUser.getHobbies().clone());
            return newInstance;
        }

        System.out.println("입력하신 회원 번호에 해당하는 회원이 없습니다.");
        return null;
    }

    public void modifyUser(User user) {
        int result = userRepository.updateUser(user);

        if(result == 1) {
            System.out.println("회원 정보 수정이 완료 되었습니다.");
        } else {
            System.out.println("입력하신 회원 번호에 해당하는 회원이 없습니다.");
        }
    }
}
