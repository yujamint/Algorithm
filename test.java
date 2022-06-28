public class test {
    public static void main(String[] args) {
        String str = "abcde";

        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();
        System.out.println(reversedStr); // edcba 출력
    }
}
