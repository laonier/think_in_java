package chapter18.section12.exercises;

import common.Constant;

import java.io.*;

public class E27_SerializeJavaBean implements Serializable {
    private E27_SerializeJavaBean bean;
    private String value;
    public E27_SerializeJavaBean(){}
    public E27_SerializeJavaBean(E27_SerializeJavaBean bean, String value) {
        this.bean = bean;
        this.value = value;
    }

    public static void main(String[] args) {
        String filename = Constant.PATH_CHAPTER18_SECTION12 + "exercises/bean.out";
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(filename));
            E27_SerializeJavaBean bean = new E27_SerializeJavaBean(new E27_SerializeJavaBean(), "I am I !");
            out.writeObject(bean);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            E27_SerializeJavaBean now = (E27_SerializeJavaBean)in.readObject();
            in.close();
            System.out.println(now.value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
