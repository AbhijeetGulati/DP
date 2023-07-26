import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    //house robber 2
    class Solution {
        //declare dp array
        int[] dp;
        public int rob(int[] nums) {
         int n= nums.length;
         dp=new int[101];
         //if only single element in array
         if(n==1){
             return nums[0];
         }
         if(n==2){
             return Math.max(nums[0],nums[1]);
         }
         Arrays.fill(dp,-1);
         //call function
            //from 0 till index n-2
            int take0thindex=f(nums,0,n-2);
            //from 1st index till n-1
            //reset dp array
            Arrays.fill(dp,-1);
            int nottake0thindex=f(nums,1,n-1);

            return Math.max(take0thindex,nottake0thindex);
        }

        public int f(int[] nums,int i,int n){
            if(i>n){
                //out of bounds
                return 0;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
            //pick and not pick
            int p=nums[i]+f(nums,i+2,n);
            int np=0+f(nums,i+1,n);

            return dp[i]=Math.max(p,np);
        }
    }
}