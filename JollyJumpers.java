import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class JollyJumpers {
    
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();
        BufferedReader br = null;

       try{
            br = new BufferedReader(new FileReader(args[0]));
            String line = "";
            while((line = br.readLine()) != null){
                    input.add(line.trim());   
                }
        }catch(Exception e){
            throw new RuntimeException("Error while reading file");
        }finally{
            try{
                br.close();
            }catch(Exception e){}
        }

        for(String text : input){
         findJollyJumpers(text);
        }
    }
     private static void findJollyJumpers(String str) {
        ArrayList<Integer> nums = new ArrayList<>();

        String[] newStr = str.split(" ");

        for(String x: newStr){
            nums.add(Integer.parseInt(x));
        }
        int[] diffs = new int[nums.size()-1];

        for(int i=0; i<nums.size()-1; i++){
            diffs[i] = Math.abs(nums.get(i)-nums.get(i+1));
           }

        Arrays.sort(diffs);

        for(int i=1; i<diffs.length-1; i++){
            if(diffs[i-1] != i){
                System.out.println("Not jolly");
                return;
            }
        }
        System.out.println("Jolly");
    }
 }