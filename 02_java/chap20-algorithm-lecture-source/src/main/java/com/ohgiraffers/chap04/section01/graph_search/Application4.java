package com.ohgiraffers.chap04.section01.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application4 {

    static int node, edge, start;
    static int[][] map;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();

    public static String solution(String input) throws IOException {

        /* 테스트 코드로 2번째부터 이전 테스트 케이스 결과 문자열이 유지 되므로 초기화
        * (알고리즘과는 무관) */
        sb.delete(0, sb.length());

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        map = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");

        /* 위의 호출에서 사용 된 방문 배열을 reset */
        visit = new boolean[node + 1];

        bfs(start);
        return sb.toString();
    }

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i <= node; i++) {
            if(map[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");

            for (int i = 1; i <= node; i++) {
                if(map[start][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }












}
