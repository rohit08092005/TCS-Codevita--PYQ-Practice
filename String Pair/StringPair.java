import java.util.*;
public class StringPair {
    
    /**
     * @param str
     */
    public static int countVowels(String str){

        int count = 0;
        for(int i = 0 ;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                count++;
            }
        }
        return count;
    }

    public static String numbertoWords(int num){
        String[] unit = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] teens = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens ={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

        if(num == 100){
            return "Hundred";
        }

        if (num < 10){
            return unit[num];
        }
        if(num==10){
            return tens[0];
        }
        if(num < 20 && num > 10){
            int helper = num % 10;
            return teens[helper -1];
        }

        if (num < 100 && num >= 20){
            int helper = num / 10;
            int helper2 = num % 10;
            return tens[helper-1 ] + " " + unit[helper2];

            
        }
       return "";

       
    }  

    public static int calculateD(int [] arr){
        int D =0;

        for(int i =0;i<arr.length;i++){

           String word = numbertoWords(arr[i]);
            int count = countVowels(word);
            D += count;

        }
        return D;
    }

    public static int countPairs(int [] arr,int D){
        int count = 0;
        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == D){
                    count++;
                }
            }
        }
        return count;
    }

    public static String CounttoWords(int count){
        if(count == 0){
            return "Zero";
        }
        if(count > 0 && count <= 100){
            return numbertoWords(count);
        }
    
        if(count > 100){
            return "greater 100";
        }

        return "";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        int D = calculateD(arr);
        int pairs = countPairs(arr,D);
        String result = CounttoWords(pairs);
        System.out.println("The number of pairs is:" + result);

    }


    
}
