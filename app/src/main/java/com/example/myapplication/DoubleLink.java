package com.example.myapplication;

public class DoubleLink<T> {
    private DNode<T> mHead;

    private int mCount;

    private class DNode<T> {
        public DNode prev;
        public DNode next;
        public T value;

        public DNode(T value, DNode prev, DNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoubleLink() {
        mHead = new DNode<T>(null, null, null);
        mHead.prev = mHead.next = mHead;
        mCount = 0;
    }

    public int size() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }

    public DNode<T> getNode(int index) {
        if (index < 0 || index >= mCount)
            throw new IndexOutOfBoundsException();

        if (index < mCount / 2) {
            DNode node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        DNode<T> rnode = mHead.prev;
        int rindex = mCount - index - 1;
        for (int j = 0; j < rindex; j++) {
            rnode = rnode.prev;
        }

        return rnode;
    }

    // 获取第index位置的节点的值
    public T get(int index) {
        return getNode(index).value;
    }


    public T getFirst(){
        return getNode(0).value;
    }

    public void insert(int index,T t){

        if (index == 0){
            DNode node = new DNode(t,mHead,mHead.next);
            mHead.next.prev = node;
            mHead.next = node;
            mCount++;
            return;
        }

        DNode inode =  getNode(index);
        DNode tnode = new DNode(t,inode.prev,inode);
        inode.prev.next = tnode;
        inode.prev = tnode;
        mCount ++;
        return;
    }

    public void insertFirst(T t){
        insert(0,t);
    }


    public void appendLast(T t){
        DNode node = new DNode(t,mHead.prev,mHead);
        mHead.prev.next = node;
        mHead.prev = node;
        mCount++;
    }

    public void delete(int index){
        DNode node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        mCount --;
    }

    public void deleteFirst(){
        delete(0);
    }

    public void deleteLast(){
        delete(mCount-1);
    }

}
