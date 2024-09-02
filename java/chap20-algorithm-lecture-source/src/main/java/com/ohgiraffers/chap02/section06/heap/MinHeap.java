package com.ohgiraffers.chap02.section06.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 최소 힙(Min Heap) 예제 */
public class MinHeap<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    // 요소 추가
    public void add(T data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    // 최소값 추출
    public T extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // 최소값 확인
    public T getMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    // 부모 노드로 이동하여 힙 속성 유지 (최소 힙 유지)
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // 자식 노드로 이동하여 힙 속성 유지 (최소 힙 유지)
    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    // 인덱스에 해당하는 요소 교환
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}