package Multithread;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            BookList bookList = new BookList();
            Reader reader2 = new Reader(2,bookList);
            Reader reader3 = new Reader(3,bookList);

            Writer writer1 = new Writer(1,bookList);
            Writer writer2 = new Writer(2,bookList);
            writer1.start();
            writer2.start();
            reader2.start();
            reader3.start();
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


}

class Reader extends Thread {
    int id;
    BookList bookList;

    public Reader(int n, BookList bookList) {
        currentThread().setName("reader"+n);
        id = n;
        this.bookList = bookList;
    }

    @Override
    public void run() {
        startToRead();
    }

    public void startToRead()  {
        for (int i = 0; i < 10; i++) {
            System.out.println("reader:"+id);
            bookList.read();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Writer extends Thread {
    int id;
    BookList bookList;

    public Writer(int n, BookList bookList) {
        currentThread().setName("writer"+n);
        id = n;
        this.bookList = bookList;
    }

    @Override
    public void run() {
        startToWrite();
    }

    public void startToWrite() {
        for (int i = 0; i < 10; i++) {
            bookList.write(i + id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

class BookList {
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Deque<Integer> bookList = new ArrayDeque<>();

    public void read() {
        rwLock.readLock().lock();
        bookList.forEach(System.out::print);
        System.out.println();
        rwLock.readLock().unlock();
    }

    public void write(Integer n) {
        rwLock.writeLock().lock();
        bookList.push(n);
        rwLock.writeLock().unlock();
    }

    public void clean(){
        bookList.clear();
    }
}