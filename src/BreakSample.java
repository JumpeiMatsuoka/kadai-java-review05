
public class BreakSample {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        int[] targetArray = {37,85,64,57,98,100,47,23,71,69};
        int search = 100;
        
        int i;
        
        for (i = 0; i < targetArray.length; i++) {
            if( search == targetArray[i]) {
                break;
            }
        }
    if(i >= targetArray.length) {
        System.out.println("対象のデータが見つかりませんでした！");
    }else{
        System.out.println("添え字" + i + "に対象のデータが見つかりました！");
        
    }
    
    }

}
