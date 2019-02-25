package base.factory;


import base.cryptology.BaseCryptology;

public class CryptologyFactory {

    private static CryptologyFactory cryptologyFactory;

    private static BaseCryptology baseCryptology;

    private CryptologyFactory(){}

    public static synchronized CryptologyFactory getInstance(){
        if (cryptologyFactory == null){
            cryptologyFactory = new CryptologyFactory();
        }
        return cryptologyFactory;
    }

    public static BaseCryptology getBaseCryptology() {
        return baseCryptology;
    }

    public static void setBaseCryptology(BaseCryptology baseCryptology) {
        CryptologyFactory.baseCryptology = baseCryptology;
    }

    public static byte[] encode(byte[] data){
        return baseCryptology.encode(data);
    }

    public static byte[] decode(byte[] data){
        return baseCryptology.decode(data);
    }

    public static boolean decide(byte[] data){return baseCryptology.decide(data);}
}
