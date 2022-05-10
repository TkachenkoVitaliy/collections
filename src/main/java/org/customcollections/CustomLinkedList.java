package org.customcollections;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T>{

    Node<T> first;
    Node<T> last;

    int count = 0;

    public int size() {
        return count;
    }

    public T getFirst() {
        Node<T> resultNode = first;
        return resultNode.item;
    }

    public T getLast() {
        Node<T> resultNode = last;
        return resultNode.item;
    }

    public void addFirst(T item) {
        if(first == null) {
            Node<T> newNode = new Node<>(item, null, null);
            first = newNode;
            last = newNode;
            count++;
        } else {
            Node<T> newNode = new Node<>(item, first, null);
            first.prev = newNode;
            first = newNode;
            count++;
        }
    }

    public void add (T item, int index) {
        if(index == 0) {
            addFirst(item);
        } else {
            if(index == size()-1) {
                add(item);
            } else {
                Node<T> nextNode = first;
                for (int i = 0; i < index; i++) {
                    nextNode = nextNode.next;
                }
                Node<T> prevNode = nextNode.prev;
                Node<T> newNode = new Node<>(item, nextNode, prevNode);
                prevNode.next = newNode;
                nextNode.prev = newNode;
                count++;
            }
        }
    }

    public void add(T item) {
        if(first == null) {
            Node<T> newNode = new Node<>(item, null, null);
            first = newNode;
            last = newNode;
            count++;
        } else {
            Node<T> newNode = new Node<>(item, null, last);
            last.next = newNode;
            last = newNode;
            count++;
        }
    }

    public T get(int index) {
        Node<T> resultNode = first;
        for (int i = 0; i < index; i++) {
            resultNode = resultNode.next;
        }
        return resultNode.item;
    }

    public T remove(int index) {
        Node<T> resultNode = first;
        for (int i = 0; i < index; i++) {
            resultNode = resultNode.next;
        }
        Node<T> prevNode = resultNode.prev;
        Node<T> nextNode = resultNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        count--;
        return resultNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            Node<T> current = first;
            @Override
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public T next() {
                Node<T> tmp = current;
                current = tmp.next;
                return tmp.item;
            }
        };
        return iterator;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
