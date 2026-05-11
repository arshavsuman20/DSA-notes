class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return new ArrayList<>();
        return phone("",digits);
    }
    List<String> phone(String p, String up){ //proecssed string contains answer
    //unprocessed string does not contains the answer
        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        List<String> list=new ArrayList<>();
        int start=(digit-2)*3;
        if(digit>7) start++;
        int len=(digit==7 || digit==9)?4:3;
        int end=len+start;
        for(int i=start ; i<end; i++){
            char ch=(char)('a'+i);
            list.addAll(phone(p+ch, up.substring(1)));
        }
        return list;
    }
}