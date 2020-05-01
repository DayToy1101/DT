import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] credit = new int[n];
            int[] score = new int[n];
            for(int i = 0;i < n;i++){
                credit[i] = sc.nextInt();
            }
            for(int i = 0;i < n;i++){
                score[i] = sc.nextInt();
            }
            System.out.printf("%.2f",getAvgCredit(credit,score));
        }
    }
    public static double getAvgCredit(int[] credit,int[] score){
        double sum = 0.0;
        double allCredit = 0.0;
        for(int i = 0;i < credit.length;i++){
            allCredit += credit[i] * GPA(score[i]);
            sum += credit[i];
        }
        return allCredit/sum;
    }
    public static double GPA(int score){
        double gpa = 0.0;
        if(score >= 90&&score <= 100){
            gpa = 4.0;
        }
        else if(score >= 85&&score <= 89){
            gpa = 3.7;
        }
        else if(score >= 82&&score <= 84){
            gpa = 3.3;
        }
        else if(score >= 78&&score <= 81){
            gpa = 3.0;
        }
        else if(score >= 75&&score <= 77){
            gpa = 2.7;
        }
        else if(score >= 72&&score <= 74){
            gpa = 2.3;
        }
        else if(score >= 68&&score <= 71){
            gpa = 2.0;
        }
        else if(score >= 64&&score <= 67){
            gpa = 1.5;
        }
        else if(score >= 60&&score <= 63){
            gpa = 1.0;
        }
        else if(score < 60){
            gpa = 0.0;
        }
        return gpa;
    }
}