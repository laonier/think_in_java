package chapter19.section2;

public enum  EnumerationExtend {
    ELEMENT1("extend1-element1"), ELEMENT2("extend1-element2", "extend2-element2");
    private String extend1;
    private String extend2;
    EnumerationExtend(String extend1){
        this.extend1 = extend1;
    }
    EnumerationExtend(String extend1, String extend2){
        this.extend1 = extend1;
        this.extend2 = extend2;
    }
    public String getExtend1() {
        return extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    @Override
    public String toString() {
        return name() + "[extend1 = " + extend1 + ", extend2 = " + extend2 + "]";
    }

    public static void main(String[] args) {
        for (EnumerationExtend ee: values()) {
            System.out.println(ee);
        }
    }
}
