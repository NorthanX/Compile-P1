import java.io.*;

public class P1 {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();


        String sRead = "";
        String sSymbol = "";

        while ((sRead =bufferedReader.readLine()) != null) {
            stringBuilder.append(sRead + "\n");
        }
        bufferedReader.close();

        String S = stringBuilder.toString();
        int stringLength = S.length();
        int loc = -1;
        int token;

        while(loc<stringLength){
            token=0;
            loc++;
            while(S.charAt(loc)==' '||S.charAt(loc)=='\n'||S.charAt(loc)=='\r'){
                loc++;
                if(loc>=stringLength){
                    break;
                }
            }
            if(loc>=stringLength){
                break;
            }
            if(Character.isLetter(S.charAt(loc))){
                while(Character.isLetter(S.charAt(loc)) || Character.isDigit(S.charAt(loc))){
                    token++;
                    loc++;
                }
                loc--;
                sSymbol = S.substring(loc-token+1,loc+1);
                if(sSymbol.equals("BEGIN")||sSymbol.equals("END")||sSymbol.equals("FOR")
                        ||sSymbol.equals("IF")||sSymbol.equals("THEN") ||sSymbol.equals("ELSE")){
                    char[] cSymbol = sSymbol.toCharArray();
                    for(int i = 1;i < sSymbol.length();i++){
                        cSymbol[i] = Character.toLowerCase(cSymbol[i]);
                    }
                    sSymbol = new String(cSymbol);
                    System.out.println(sSymbol);
                }
                else {
                    System.out.println("Ident("+sSymbol+")");
                }
            }
            else if(Character.isDigit(S.charAt(loc))){
                while(Character.isDigit(S.charAt(loc))){
                    token++;
                    loc++;
                }
                loc--;
                sSymbol = S.substring(loc-token+1,loc+1);
                System.out.println("Int("+Integer.parseInt(sSymbol)+")");
            }
            else if (S.charAt(loc)== ':'){
                loc++;
                if(S.charAt(loc)== '='){
                    System.out.println("Assign");
                }
                else {
                    loc--;
                    System.out.println("Colon");
                }
            }
            else if (S.charAt(loc)== '+'){
                System.out.println("Plus");
            }
            else if (S.charAt(loc)== '*'){
                System.out.println("Star");
            }
            else if (S.charAt(loc)== ','){
                System.out.println("Comma");
            }
            else if (S.charAt(loc)== '('){
                System.out.println("LParenthesis");
            }
            else if (S.charAt(loc)== ')'){
                System.out.println("RParenthesis");
            }
            else {
                System.out.println("Unknown");
                break;
            }
        }
    }


}
