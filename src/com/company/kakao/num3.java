//package com.company.kakao;
//
//class num3 {
//    public static int[] result;
//
//    public boolean compare(String a, String b)
//    {
//        if(a.length()!=b.length())
//            return false;
//
//        for (int i=0;i<a.length();i++)
//        {
//            if(b.charAt(i)=='*')
//                continue;
//            if(a.charAt(i)!=b.charAt(i))
//                return false;
//        }
//        return true;
//    }
//
//    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
//        if(r == 0){
//            for(int i=0; i<index; i++) System.out.print(arr[combArr[i]] + " ");
//            System.out.println();
//        }else if(target == n) return;
//        else{
//            combArr[index] = target;
//            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
//            doCombination(combArr, n, r, index, target+1, arr); //(ii)
//        }
//    }
//    public int solution(String[] user_id, String[] banned_id) {
//        int answer = 0;
//        result = new int[banned_id.length];
//        for (int i = 0; i < banned_id.length; i++) {
//            String tmp = banned_id[i];
//            for (int j = 0; j < user_id.length; j++) {
//                if(compare(user_id[j],tmp))
//                    return result[i]++;
//            }
//        }
//        return answer;
//    }
//}
