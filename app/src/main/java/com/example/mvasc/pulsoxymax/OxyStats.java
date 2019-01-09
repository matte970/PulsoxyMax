package com.example.mvasc.pulsoxymax;

public class OxyStats {

    private int recordedValues;
    private int minOxyValue;
    private int maxOxyValue;
    private float averageOxyValue;
    private int criticalValues;
    private float averageCriticalValue;
    private int minCriticalValue;
    private int maxCriticalValue;

    @Override
    public String toString() {
        return "OxyStats{" +
                "recordedValues=" + recordedValues +
                ", minOxyValue=" + minOxyValue +
                ", maxOxyValue=" + maxOxyValue +
                ", averageOxyValue=" + averageOxyValue +
                ", criticalValues=" + criticalValues +
                ", averageCriticalValue=" + averageCriticalValue +
                ", minCriticalValue=" + minCriticalValue +
                ", maxCriticalValue=" + maxCriticalValue +
                '}';
    }

    public int getMinOxyValue() {
        return minOxyValue;
    }

    public void setMinOxyValue(int minOxyValue) {
        this.minOxyValue = minOxyValue;
    }

    public int getMaxOxyValue() {
        return maxOxyValue;
    }

    public void setMaxOxyValue(int maxOxyValue) {
        this.maxOxyValue = maxOxyValue;
    }

    public int getMaxCriticalValue() {
        return maxCriticalValue;
    }

    public void setMaxCriticalValue(int maxCriticalValue) {
        this.maxCriticalValue = maxCriticalValue;
    }

    public int getRecordedValues() {
        return recordedValues;
    }

    public void setRecordedValues(int recordedValues) {
        this.recordedValues = recordedValues;
    }

    public float getAverageOxyValue() {
        return averageOxyValue;
    }

    public void setAverageOxyValue(float averageOxyValue) {
        this.averageOxyValue = averageOxyValue;
    }

    public int getCriticalValues() {
        return criticalValues;
    }

    public void setCriticalValues(int criticalValues) {
        this.criticalValues = criticalValues;
    }

    public float getAverageCriticalValue() {
        return averageCriticalValue;
    }

    public void setAverageCriticalValue(float averageCriticalValue) {
        this.averageCriticalValue = averageCriticalValue;
    }

    public int getMinCriticalValue() {
        return minCriticalValue;
    }

    public void setMinCriticalValue(int minCriticalValue) {
        this.minCriticalValue = minCriticalValue;
    }

}