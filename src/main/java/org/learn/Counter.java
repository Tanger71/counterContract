package org.learn;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.abi.ABIDecoder;

public class Counter
{

    private static int count;

    static{
        ABIDecoder decoder = new ABIDecoder(Blockchain.getData());
        count = decoder.decodeOneInteger();
    }

    @Callable
    public static String getCount(){
        return ((Integer)count).toString();
    }


    public static void incrementCount(int magnitude){
        count += magnitude;
        Blockchain.println("Incremented by " + magnitude + ". New value: " + count);
    }

    @Callable
    public static void resetCounter(int value){
        count = value;
        Blockchain.println("Set counter to " + count);
    }

}
