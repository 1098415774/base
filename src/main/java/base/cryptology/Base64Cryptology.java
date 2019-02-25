package base.cryptology;

import base.utils.CryptologyUtils;

public class Base64Cryptology implements BaseCryptology{
    private int offset = 0;

    public Base64Cryptology(){
        this(0);
    }

    public Base64Cryptology(int offset){
        this.offset = offset;
    }


    public byte[] encode(byte[] data) {
        return CryptologyUtils.base64Encode(data,offset);
    }


    public byte[] decode(byte[] data) {
        return CryptologyUtils.base64Decode(data,offset);
    }


    public boolean decide(byte[] data) {
        return false;
    }
}
