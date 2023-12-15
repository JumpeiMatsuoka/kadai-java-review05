
public class SevenNumber {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        for (int i = 1; i <= 100; i++) {
        if(i % 7 == 0 || i % 10 ==7|| i/10==7) {
        System.out.println("clap!");
    }else {
    System.out.println(i);
    }
}}}