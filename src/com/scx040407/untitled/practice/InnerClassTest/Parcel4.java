package com.scx040407.untitled.practice.InnerClassTest;

public class Parcel4 {

    private class PContents implements Contents {
        int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}
