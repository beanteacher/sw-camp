package com.ohgiraffers.chap04.section01.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* DFS와 x, y좌표를 활용한 문제를 해결할 수 있다.*/
public class Application2_2 {

    /* 상하좌우 개념의 좌표 배열들 */
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    /* 배추밭 */
    static int map[][];

    /* 방문한 배추 좌표 배열 */
    static boolean visit[][];

    /* 현재 좌표 */
    static int cx, cy;

    /* 배추밭의 크기(너비/높이), 심어진 배추의 수 */
    static int M, N, K;

    /* 필요한 배추흰지렁이의 수 */
    static int count;


    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visit = new boolean[M][N];

        /* 배추밭에 배추 심기 */
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        // 출력 확인
/*        System.out.println("배추밭");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        count = 0;

        /* 배추 찾기 */
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                /* 방문 안한 위치에 배추가 심어져 있다면 지렁이를 심자 */
                if(map[i][j] == 1 && !visit[i][j]) {
                    count++;
                    /* 해당 위치 및 붙어있는 배추밭을 방문체크(붙어있는 배추 묶음 파악) */
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    /* 재귀적으로 호출하면서 방문 체크 */
    static void dfs(int x, int y) {
        visit[x][y] = true;

        /* 상하좌우 살펴보기 */
        for(int i = 0; i < 4; i++) {
            cx = x + dirX[i];
            cy = y + dirY[i];

            /* 지금 보는 방향이 좌표로써 존재하면서 방문한 적이 없고 배추가 심어져 있다면 */
            if(range_check() && !visit[cx][cy] && map[cx][cy] == 1) {
                visit[cx][cy] = true;
                dfs(cx, cy);
            }
        }
    }

    private static boolean range_check() {
        return cx >= 0 && cx < M && cy >= 0 && cy < N;
    }
}
