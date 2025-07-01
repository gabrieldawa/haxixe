public class Hash {
    private String salt;

    Hash(String salt){
        this.salt = salt;
    }

    public String hash1(String input){
        String output = "";
        input += salt;
        int inDigit, outDigit;
        for(int i = 0; i < input.length(); i++){
            inDigit = (int)(input.charAt(i));
            outDigit = ((int) (10000 + (inDigit * Math.PI)) % 65519);
            output += outDigit;
        }

        return output;
    }

    //public String hash2(){}
    //public String hash3(){}

    public String getSalt() {return salt;}
    public void setSalt(String salt) {this.salt = salt;}

    @Override
    public String toString(){
        return "Salt" + salt;
    }
}