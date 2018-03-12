package bean;

import java.util.HashMap;
import java.util.Map;

public class Schedule{
    private boolean booleanValue;
    private int intergerValue;
    private Map<String, String> mapValue;

    public Schedule(){}

    public Schedule(boolean booleanValue, int intergerValue, Map<String, String> mapValue) {
        this.booleanValue = booleanValue;
        this.intergerValue = intergerValue;
        this.mapValue = mapValue;
    }

    public void addMapValue(String s1, String s2){
        if(this.getMapValue() == null){
            this.mapValue = new HashMap<String, String>();
        }
        this.mapValue.put(s1, s2);
    }

    public int getIntergerValue() {
        return intergerValue;
    }

    public Map<String, String> getMapValue() {
        return mapValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public void setIntergerValue(int intergerValue) {
        this.intergerValue = intergerValue;
    }

    public void setMapValue(Map<String, String> mapValue) {
        this.mapValue = mapValue;
    }

    @Override
    public String toString() {
        return "booleanValue["+booleanValue+"] integerValue["+intergerValue+"] mapValue["+mapValue+"]";
    }


}
