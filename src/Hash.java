public class Hash {
    private String salt;

    Hash(String salt){
        this.salt = salt;
    }

    public String hash1(String input){ //modulo
        String output = "";
        input += salt;//salts the food
        int inDigit, outDigit;
        for(int i = 0; i < input.length(); i++){ //uses module
            inDigit = (int)(input.charAt(i));
            outDigit = ((int) (10000 + (inDigit * Math.PI)) % 65519);
            output += outDigit;
        }

        return output;
    }

    public String hash2(String input){ //rehash
        String output = "";
        input += salt; //salts the food
        for(int i = 0; i < input.length(); i++){ //recursion upon a previous version of itself
            output += (int)(input.charAt(i)) * (1 + (int)(hash1(input).charAt(i)));
        }
        return output;
    }
    public String hash3(String input){ //more complex rehash and modulo
        String output = "";
        int tempOut;
        input += salt; //salts the food
        for(int i = 0; i < input.length(); i++){
            tempOut = i % 2 == 0 ? input.charAt(i) : (int)(input.charAt(i) + i);
            output += (char)(tempOut);
        }
        return output;
    }

    public String encode(String input){
        return hash3(hash2(hash1(input)));
    }

    public String getSalt() {return salt;}
    public void setSalt(String salt) {this.salt = salt;}

    @Override
    public String toString(){
        return "Salt" + salt;
    }
}