package com.ohgiraffers.chap04.section02.tree_search;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {
    static class Node {
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] tree = new Node[26]; // A~Z 총 26개의 노드
    static StringBuilder sb = new StringBuilder();

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[parent - 'A'] = new Node(left, right);
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        return sb.toString();
    }

    static void preorder(char current) {
        if (current == '.') return;
        sb.append(current);
        preorder(tree[current - 'A'].left);
        preorder(tree[current - 'A'].right);
    }

    static void inorder(char current) {
        if (current == '.') return;
        inorder(tree[current - 'A'].left);
        sb.append(current);
        inorder(tree[current - 'A'].right);
    }

    static void postorder(char current) {
        if (current == '.') return;
        postorder(tree[current - 'A'].left);
        postorder(tree[current - 'A'].right);
        sb.append(current);
    }
}
