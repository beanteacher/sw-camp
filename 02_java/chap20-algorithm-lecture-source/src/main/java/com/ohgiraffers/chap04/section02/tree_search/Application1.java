package com.ohgiraffers.chap04.section02.tree_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 트리 알고리즘을 활용하는 예제를 이해할 수 있다. */
public class Application1 {

    static int N;
    static List<Integer>[] list;    // 연결 노드 저장 배열
    static int[] parent;            // 최종 결과 저장 배열
    static boolean[] visit;         // 방문 결과 저장 배열

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N + 1];
        parent = new int[N + 1];
        list = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        /* N - 1 개 줄의 입력을 처리 */
        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // a 노드가 연결 된 노드를 저장하는 list에 b 노드 추가
            list[b].add(a); // b 노드가 연결 된 노드를 저장하는 list에 a 노드 추가
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        /* dfs 이후 parent 노드에는 각 노드의 부모 노드가 담겨 있다. */
        for(int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append(" ");
        }

        return sb.toString();
    }

    private static void dfs(int parentNode) {
        /* 이미 방문한 노드는 부모 노드이고 부모 노드는 재방문하지 않도록 함 */
        visit[parentNode] = true;

        /* 연결 된 노드를 반복 */
        for(int childNode : list[parentNode]) {
            if(!visit[childNode]) {
                // 부모를 관리하는 배열에 해당 자식 노드의 부모 노드를 담는다.
                parent[childNode] = parentNode;
                // 그 자식 노드를 부모로 하는 자식 노드를 탐색한다.
                dfs(childNode);
            }
        }

    }
}
