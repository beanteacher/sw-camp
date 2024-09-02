package com.ohgiraffers.chap05.section01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/*
최소 신장 트리
프림 알고리즘 (Priority Queue 방식)
시작 정점에서 시작하여, 최소 가중치 간선을 추가하면서 최소 스패닝 트리를 확장하는 방법
우선순위 큐를 사용하여 가장 적은 가중치의 간선을 효율적으로 선택
*/
public class Application7 {

    static class Edge {
        int vertex, weight;
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static Long solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, weight));
            graph[v].add(new Edge(u, weight));
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        long totalWeight = 0;

        // 정점 1에서 시작
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currentVertex = edge.vertex;
            int weight = edge.weight;

            if (visited[currentVertex]) continue;

            visited[currentVertex] = true;
            totalWeight += weight;

            for (Edge neighbor : graph[currentVertex]) {
                if (!visited[neighbor.vertex]) {
                    pq.add(neighbor);
                }
            }
        }

        return totalWeight;
    }
}