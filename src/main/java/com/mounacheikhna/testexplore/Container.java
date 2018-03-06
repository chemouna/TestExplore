package com.mounacheikhna.testexplore;

public class Container {

    private Rect bounds;
    private Margin margin;
    private int containerXOffset;

    public void setBounds(Rect bounds) {
        this.bounds = bounds;
    }

    public void setContainerXOffset(int containerXOffset) {
        this.containerXOffset = containerXOffset;
    }

    public void show() {
        int leftMargin = getLeftMargin();
        int rightMargin = getRightMargin();
        Margin margin = new Margin(leftMargin, rightMargin);
        setMargin(margin);
    }

    private int getRightMargin() {
        return bounds.right + containerXOffset; // maybe width - bounds.right + containerXOffset
    }

    private int getLeftMargin() {
        return bounds.left + containerXOffset;
    }

    private void setMargin(Margin margin) {
        this.margin = margin;
    }

}
