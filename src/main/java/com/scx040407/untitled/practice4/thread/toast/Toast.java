package com.scx040407.untitled.practice4.thread.toast;

/**
 * 2018/07/17 ÏÂÎç 9:48
 */
public class Toast {
    public Toast(int id) {
        this.id = id;
    }

    public enum Status {DRY, BUTTERED, JAMMED,}

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }

    private Status status = Status.DRY;
    private final int id;

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }


}
