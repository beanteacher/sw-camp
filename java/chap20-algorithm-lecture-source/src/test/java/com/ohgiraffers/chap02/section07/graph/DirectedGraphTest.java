package com.ohgiraffers.chap02.section07.graph;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectedGraphTest {

    private DirectedGraph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new DirectedGraph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
    }

    /* 1 → 2 → 5
    *  ↓     ↘
    *  3 → 4 → 6
    * */
    static Stream<Arguments> provideForDfsStack() {
        // 1 -> 1
        // 2 3 -> 3
        // 2 4 -> 4
        // 2 6 -> 6
        // 2 -> 2
        // 5 -> 5
        return Stream.of(
                Arguments.arguments(1, Arrays.asList(1, 3, 4, 6, 2, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForDfsStack")
    void testDfsStack(Integer start, List<Integer> expected) {
        List<Integer> result = graph.dfsUsingStack(start);
        Assertions.assertEquals(expected, result);
    }

    /*  1 → 2 → 5
     *  ↓     ↘
     *  3 → 4 → 6
     * */
    static Stream<Arguments> provideForDfsRecursive() {
        return Stream.of(
                Arguments.arguments(1, Arrays.asList(1, 2, 5, 6, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForDfsRecursive")
    void testDfsRecursive(Integer start, List<Integer> expected) {
        List<Integer> result = graph.dfsUsingRecursion(start);
        Assertions.assertEquals(expected, result);
    }

    /*  1 → 2 → 5
     *  ↓     ↘
     *  3 → 4 → 6
     * */
    static Stream<Arguments> provideForBfs() {
        return Stream.of(
                Arguments.arguments(1, Arrays.asList(1, 2, 3, 5, 6, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForBfs")
    void testBfs(Integer start, List<Integer> expected) {
        List<Integer> result = graph.bfsUsingQueue(start);
        Assertions.assertEquals(expected, result);
    }

    /*  1 → 2 → 5
     *  ↓     ↘
     *  3 → 4 → 6
     * */
    @Test
    public void testHasPath() {
        assertTrue(graph.hasPath(1, 2));
        assertTrue(graph.hasPath(1, 3));
        assertTrue(graph.hasPath(2, 6));
        assertFalse(graph.hasPath(2, 3));
        assertFalse(graph.hasPath(5, 6));
    }
}