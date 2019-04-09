package chapter17.section8;

public class AssociativeArray<K,V> {
    private Object[][] pair;
    private int index = -1;
    public AssociativeArray(int length){
        pair = new Object[length][2];
    }
    public void put(K key, V value){
        for(int i = 0; i < pair.length; i++){
            if (key.equals(pair[i][0])){
                pair[i] = new Object[]{key, value};
                return;
            }
        }
        if(++index > pair.length){
            throw new IndexOutOfBoundsException();
        }
        pair[index] = new Object[]{key, value};
    }
    public V get(K key){
        for(int i = 0; i < pair.length; i++){
            if(pair[i][0].equals(key)){
                return (V)pair[i][1];
            }
        }
        return null;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < pair.length; i++){
            Object[] entry = pair[i];
            sb.append(entry[0]).append("=").append(entry[1]);
            if (i < pair.length -1 ) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String,String> aa = new AssociativeArray<>(7);
        aa.put("1", "one");
        aa.put("2", "two");
        aa.put("3", "three");
        aa.put("4", "four");
        aa.put("5", "five");
        aa.put("6", "six");
        aa.put("7", "seven");
        aa.put("7", "seven1");
        System.out.println(aa);
    }
}
