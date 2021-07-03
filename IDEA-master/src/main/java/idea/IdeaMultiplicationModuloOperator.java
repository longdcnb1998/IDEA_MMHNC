package idea;

import bits.BinaryOperator;
import bits.BitArray;


public class IdeaMultiplicationModuloOperator implements BinaryOperator {
    @Override
    public BitArray combine(BitArray operand1, BitArray operand2) {
        if(operand1.size() != 16 || operand2.size() != 16) {
            throw new IllegalArgumentException("IdeaMultiplicationModuloOperator operates only on 16 bits arrays");
        }

        if (operand1.toHexString().equals("[00 00]")) {
            operand1 = new BitArray(0x10000, 24);
        }

        if (operand2.toHexString().equals("[00 00]")) {
            operand2 = new BitArray(0x10000, 24);
        }


        long a = operand1.toInt();
        long b = operand2.toInt();

        long res = ((a * b) % 65537);

        BitArray result = null;
        if(res == 65536) {
            result = new BitArray(0x0000, 16);
        } else {
            result = new BitArray((int) res, 16);
        }

        return result;
    }
}
