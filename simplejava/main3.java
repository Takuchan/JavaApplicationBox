import java.util.Scanner;
public class main3{
    public static void main(String[] args){
        Boolean judgeBool = false;
        
        Boolean resultPrimary = false;

        System.out.println("素数チェックアプリ!");
        System.out.println("数字入力しろぼけ。");
        
        while (!judgeBool) {
            try{
                Scanner scanner = new Scanner(System.in);
                Double count = scanner.nextDouble();
                judgeBool = true;
                resultPrimary = aho(count);
                
            }catch (Exception e){
                judgeBool = false;
                System.out.println("数字入力しろぼけって念を押したよね??（圧）");
            }
        }
        if(resultPrimary){
            System.out.println("素数!");
        }else{
            System.out.println("合成数");
        }
    }


    public static boolean aho(Double a){
        Boolean result = false;

        for (int i = 2; i < a;i++){
            if(a % i == 0){
                result = false;
                break;
            }else{
                result = true;
            }
        }
        return result;

    }
}
