package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static AtomicInteger threadPriority = new AtomicInteger(Thread.MIN_PRIORITY);

    public MyThread() {
        super();
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(Runnable target) {
        super(target);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else if (group.getMaxPriority() <= threadPriority.get()) {
                this.setPriority(group.getMaxPriority());
                threadPriority.incrementAndGet();
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(String name) {
        super(name);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else if (group.getMaxPriority() <= threadPriority.get()) {
                this.setPriority(group.getMaxPriority());
                threadPriority.incrementAndGet();
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else if (group.getMaxPriority() <= threadPriority.get()) {
                this.setPriority(group.getMaxPriority());
                threadPriority.incrementAndGet();
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        synchronized (threadPriority) {
            if (threadPriority.get() == Thread.MAX_PRIORITY) {
                this.setPriority(threadPriority.get());
                threadPriority.set(Thread.MIN_PRIORITY);
            } else if (group.getMaxPriority() <= threadPriority.get()) {
                this.setPriority(group.getMaxPriority());
                threadPriority.incrementAndGet();
            } else {
                this.setPriority(threadPriority.getAndIncrement());
            }
        }
    }
}
