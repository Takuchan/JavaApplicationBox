
// 作成日
// 2022年11月18日
// 作成者 Takuchan

import java.util.Scanner;

public class main1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Boolean judgeInt = false;
        int inputuserId = 0;
        String inputName = "";
        
        while(!judgeInt){
            try{
                System.out.println("ユーザーIDを入力してください");
                Scanner scanner1 = new Scanner(System.in);
                inputuserId = scanner1.nextInt();
                judgeInt = true;
            }catch(Exception e){
                System.out.println("数字を入力しろって言ったよね?????");

            }
        }
        
        System.out.println("あなたの名前を入力してください");
        inputName = scanner.nextLine();

        Module module = new Module(inputuserId, inputName);
        System.out.println("ようこそ" + module.getUserId() +" の " + module.getName()+"さん");

        
        
    }
}

