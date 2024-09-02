package com.ohgiraffers.testapp.repository;

import com.ohgiraffers.testapp.aggregate.BloodType;
import com.ohgiraffers.testapp.aggregate.User;
import com.ohgiraffers.testapp.stream.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

/* 데이터와 입출력(CRUD)를 위해 만들어 지며 성공 또는 실패 여부를 반환 */
public class UserRepository {

    private final ArrayList<User> userList = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/com/ohgiraffers/testapp/db/userDB.dat"; 
    
    public UserRepository() {
        /* 객체 생성 시 동작할 내용 
        * 1. 초기 회원 3명을 넣어 놓는다.
        * 2. 파일로부터 회원 정보를 가져온다. 
        * 3. userList에 담는다.
        * */
        File file = new File(FILE_PATH);
        
        if (!file.exists()) {
            ArrayList<User> users = new ArrayList<>();
            users.add(new User(1, "user01", "pass01", 20, new String[]{"발레", "수영"}, BloodType.A));
            users.add(new User(2, "user02", "pass02", 30, new String[]{"게임"}, BloodType.AB));
            users.add(new User(3, "user03", "pass03", 40, new String[]{"영화감상", "독서", "명상"}, BloodType.O));
            
            saveUsers(file, users);
        }
        
        loadUsers(file);
        
    }

    private void loadUsers(File file) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while(true) {
                userList.add((User)ois.readObject());
            }

        } catch(EOFException e) {
            System.out.println("회원 정보를 모두 로딩하였습니다.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUsers(File file, ArrayList<User> users) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            for (User user : users) {
                oos.writeObject(user);
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> selectAllUsers() {
        return userList;
    }

    public User selectUserByNo(int no) {
        for(User user : userList) {
            if(user.getNo() == no) {
                return user;
            }
        }
        return null;
    }

    public int selectLastUserNo() {

//        return userList.size();
        User lastUser = userList.get(userList.size()-1);
        return lastUser.getNo();

    }

    public int insertUser(User user) {

        int result = 0;

        try (MyObjectOutputStream moos = new MyObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {

            moos.writeObject(user);
            userList.add(user);
            result = 1;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int deleteUser(int no) {

        /* soft delete -> 상태 값 변경을 통해 처리
        * hard delete -> 실제 삭제 수행
        * */

        for(int i = 0 ; i < userList.size() ; i++) {
            if(userList.get(i).getNo() == no) {
                userList.remove(i);

                File file = new File(FILE_PATH);
                saveUsers(file, userList);

                return 1;
            }
        }

        return 0;

    }

    public int updateUser(User user) {

        for(int i = 0 ; i < userList.size() ; i++) {
            if(userList.get(i).getNo() == user.getNo()) {
                userList.set(i, user);

                File file = new File(FILE_PATH);
                saveUsers(file, userList);

                return 1;
            }
        }

        return 0;

    }
}
