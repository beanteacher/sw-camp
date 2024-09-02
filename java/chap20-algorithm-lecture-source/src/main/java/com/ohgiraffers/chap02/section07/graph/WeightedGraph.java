package com.ohgiraffers.chap02.section07.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 3. 가중치 그래프 (인접 리스트) */
public class WeightedGraph<T> {

    // 정점과 이웃 정점을 저장할 map, 가중치는 Map의 Integer 타입으로 표기
    private Map<T, Map<T, Integer>> adjList;

    public WeightedGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    /* 간선 추가 시 가중치도 함께 추가 됨 */
    public void addEdge(T from, T to, int weight) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).put(to, weight);
    }

    public void removeVertex(T vertex) {
        adjList.values().forEach(edge -> edge.remove(vertex));  // 제거할 정점과 연결 된 간선 제거
        adjList.remove(vertex); // 정점 제거
    }

    public void removeEdge(T from, T to) {
        Map<T, Integer> edges = adjList.get(from);
        if(edges != null) edges.remove(to);
    }

}
