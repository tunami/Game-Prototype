package edu.virginia.engine.tweens;

public class TweenParam {
    private TweenableParam p;
    private double start, end, totaltime;
    private double currTime;
    private boolean compl;
    public TweenParam(TweenableParam paramToTween, double startVal, double endVal, double timeP) {
        p = paramToTween;
        start = startVal;
        end = endVal;
        totaltime = timeP;
        currTime = 0;
        compl = false;
    }
    public TweenableParam getParam(){
        return p;
    }
    public double getStart() {
        return start;
    }
    public void setStart(double start) {
        this.start = start;
    }
    public double getEnd() {
        return end;
    }
    public void setEnd(double end) {
        this.end = end;
    }
    public double getTotaltime() {
        return totaltime;
    }
    public void setTotaltime(double totaltime) {
        this.totaltime = totaltime;
    }
    public double getCurrTime() {
        return currTime;
    }
    public void setCurrTime(double currTime) {
        this.currTime = currTime;
    }
    public void setComplete(boolean complete) {
        compl = complete;
    }
    public boolean isComplete(){
        return compl;
    }
    
    
}
