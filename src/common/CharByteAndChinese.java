import java.io.UnsupportedEncodingException;

public class CharByteAndChinese {
    /**
     * byte 8 bits -128 - + 127
     * 1 bit = 1 二进制数据
     * 1 byte(字节) = 8 bit
     * 1 字母 = 1 byte = 8 bit(位)
     * 1 汉字 = 2 byte = 16 bit
     */
    public static void main(String[] args) {
        String str = "你好Hello";
        System.out.println("系统默认字符：" + System.getProperty("file.encoding"));
        // UTF-8（系统默认）编码中，一个英文字母字符存储需要1个字节，一个汉字字符储存需要3到4个字节
        testEncode(str, System.getProperty("file.encoding"));
        // GB 2312 编码或 GBK 编码中，一个英文字母字符存储需要1个字节，一个汉字字符存储需要2个字节
        testEncode(str, "GBK");
        testEncode(str, "GB2312");
        // UTF-16编码中，一个英文字母字符存储需要2个字节，
        // 一个汉字字符储存需要3到4个字节（Unicode扩展区的一些汉字存储需要4个字节）
        testEncode(str, "UTF-16");
        // UTF-32编码中，世界上任何字符的存储都需要4个字节
        testEncode(str, "UTF-32");
    }
    static void testEncode(String str, String encode) {
        System.out.println("================>>");
        System.out.println("测试字符 = " + str);
        System.out.println("str.length = " + str.length());
        System.out.println("采用[" + encode + "]编码后转换");
        try {
            System.out.println("Bytes.length = " + str.getBytes(encode).length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
