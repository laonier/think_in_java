package chapter17.section9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {
    private static List<String> container = new ArrayList<>();
    private final String value;
    private int id;
    public CountedString(String value){
        this.value = value;
        container.add(value);
        for(String v: container){
            if (value.equals(v)){
                id++;
            }
        }
    }
    public String toString(){
        return "[value: " + value + ",id: " + id + ",hashCode:" + hashCode()+ "]";
    }
    public int hashCode(){
        int result = 17;
        if (value != null){
            result = 37 * result + value.hashCode();
        }
        return result * 37 + id;
    }
    public boolean equals(Object obj) {
        return this == obj || obj instanceof CountedString &&
                value.equals(((CountedString) obj).value) &&
                id == ((CountedString) obj).id;
    }

    public static void main(String[] args) {
        // 如果是相同的key只会更新不会添加，利用这个机制来检查CountedString中的hashcode和equals是否正常工作
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] strings = new CountedString[5];
        for(int i = 0; i < 5; i++){
            strings[i] = new CountedString("hi");
            map.put(strings[i], i);
        }
        System.out.println(map);
        for (CountedString str: strings){
            System.out.println(str);
        }
    }
}
