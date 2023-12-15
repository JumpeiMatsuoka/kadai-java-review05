
public class DoWhileSample {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        int num = 1; // 初期値設定

        do {
            // 2の倍数を計算
            num = num * 2;

            // 結果を出力
            System.out.println(num);
        } while (num < 1024); // 繰り返しの条件（numが1024より小さい間）
    }

}
