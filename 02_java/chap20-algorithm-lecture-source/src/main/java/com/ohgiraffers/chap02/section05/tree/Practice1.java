package com.ohgiraffers.chap02.section05.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Practice1 {

    public String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());    // 연산의 수
            TreeMap<Integer, Integer> map = new TreeMap<>();    // 이중 우선순위 큐의 역할을 할 TreeMap

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                char cmd = st.nextToken().charAt(0);            // 연산 명령 (I or D)
                int value = Integer.parseInt(st.nextToken());   // insert 할 값 또는 delete 할 방식

                if(cmd == 'I') {    // 삽입
                    // 해당 값을 가지고 있다면 기존 값 + 1, 가지고 있지 않다면 0(default) + 1
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (!map.isEmpty()){            // 삭제 + 저장 된 값이 있을 때만 수행
                    int key = (value == 1) ? map.lastKey() : map.firstKey();

                    // computeIfPresent : 키가 존재하지 않으면 아무런 작업 수행하지 않고 null 반환
                    // 키가 존재하면 remappingFunction 호출하여 null 반환 시 제거,
                    // 다른 반환 값이면 해당 값으로 업데이트 처리
                    map.computeIfPresent(key, (k1, v) -> (v == 1) ? null : v - 1);
                }
            }

            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }

        }

        return sb.toString().trim();
    }
}
