package com.ohgiraffers.chap04.section01.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BFS와 방문 배열을 활용한 최단거리 문제를 해결할 수 있다. */
public class Application3 {

    static int[][] map;
    static boolean[][] visit;
    static int N, M;    // 가로, 세로

    /* 상하좌우 개념의 좌표 배열들 */
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    /* x와 y 좌표를 가지는 static 내부 클래스 */
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        /* 입력 값 공백 없이 들어오는 문자를 int 배열에 옮겨 담기 */
        for(int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < ch.length; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);   // '1' -> 숫자 1
            }
        }

        bfs(0, 0);

        /* 도착지의 값을 반환 (도착 할 때까지의 최적의 경로 단계 수) */
        return map[N - 1][M -  1];
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;

        while(!q.isEmpty()) {

            Node n = q.poll();

            /* 해당 정점에서 상하좌우를 살펴보는 반복문 */
            for(int i = 0; i < 4; i++) {
                int curX = n.x + dirX[i];
                int curY = n.y + dirY[i];

                /* 좌표가 전체 범위를 넘어간다면 확인이 불필요하므로 다음 방향 확인 */
                if(curX < 0 || curY < 0 || curX >= N || curY >= M) continue;

                /* 방문 했던 좌표이거나 벽이면 확인이 불필요하므로 다음 방향 확인 */
                if(visit[curX][curY] || map[curX][curY] == 0) continue;

                q.offer(new Node(curX, curY));
                visit[curX][curY] = true;
                map[curX][curY] = map[n.x][n.y] + 1;

                System.out.println("curX = " + curX + ", curY = " + curY);
                System.out.println("map[curX][curY] = " + map[curX][curY]);

            }
        }

    }

}
