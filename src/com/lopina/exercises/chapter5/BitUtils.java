package com.lopina.exercises.chapter5;

public class BitUtils {
	public static boolean getBitFromEnd(int num, int i) {
		assertBitPositionInInt(i);
		return ((num & (1 << i)) != 0);
	}
	
	public static boolean getBitFromStart(int num, int i) {
		assertBitPositionInInt(i);
		return getBitFromEnd(num, 31 - i);
	}
	
	public static int setBitFromEnd(int num, int i) {
		assertBitPositionInInt(i);
		return (num | (1 << i));
	}
	
	public static int setBitFromStart(int num, int i) {
		assertBitPositionInInt(i);
		return setBitFromEnd(num, 31 - i);
	}
	
	public static int clearBitFromEnd(int num, int i) {
		assertBitPositionInInt(i);
		return (num & (~(1 << i)));
	}
	
	public static int clearBitFromStart(int num, int i) {
		assertBitPositionInInt(i);
		return clearBitFromEnd(num, 31 - i);
	}
	
	public static int clearBitsFromLeastSignificant(int num, int i) {
		assertBitPositionInInt(i);
		/*
		 * Assume we want to clear last 3 bits of 8 bit number "abcdefgh"
		 * clearBitsFromLeastSignificant(abcdefgh, 3) = abcde000
		 * 
		 * We need to do the following operations:
		 *     abcdefgh &
		 *     11111000
		 * 
		 * That equals to
		 *     abcdefgh &
		 *    ~00000111
		 * 
		 * Which equals to
		 *     abcdefgh &
		 *   ~(00001000 -
		 *     00000001)
		 * 
		 * Which is actually
		 *     abcdefgh &
		 *  ~((00000001 << (3 + 1)) -
		 *     00000001)
		 * 
		 */
		int mask = ~((1 << (i + 1)) - 1);
		return num & mask;
	}
	
	public static int clearBitsFromMostSignificant(int num, int i) {
		assertBitPositionInInt(i);
		/*
		 * Assume we want to clear first 3 bitst of 8 bit number "abcdefgh"
		 * clearBitsFromMostSignificant(abcdefgh, 3) = 000defgh
		 * 
		 * We need to do the following operations:
		 *     abcdefgh &
		 *     00011111
		 *     
		 * That equals to
		 *     abcdefgh &
		 *    (00100000 -
		 *     00000001)
		 * 
		 * Which equals to
		 *     abcdefgh &
		 *   ((00000001 << (8 - i)) -
		 *     00000001)
		 */
		
		int mask = (1 << (31 - i)) - 1;
		return num & mask;
	}
	
	public static int updateBitFromEnd(int num, int i, int b) {
		assertBitPositionInInt(i);
		assertIntIsBitValue(b);
		
		int mask = ~(1 << i);
		return (num & mask) | (b << i);
	}
	
	public static int updateBitFromStart(int num, int i, int b) {
		assertBitPositionInInt(i);
		assertIntIsBitValue(b);
		
		return updateBitFromEnd(num, 31 - i, b);
	}
	
	public static int updateBitsFromLeastSignificant(int n, int m, int i, int j) {
		assert(i < j);
		assertBitPositionInInt(i);
		assertBitPositionInInt(j);
		
		/*
		 * Step 1: Clear bits [i-j] in n
		 *     clear bits [2-5]:
		 *     
		 *     abcdefgh &
		 *     11000011
		 *     
		 *     11000011:
		 *     11000000 |
		 *     00000011
		 *     
		 *     11000000:
		 *     11111111 << (j + 1)
		 *     
		 *     00000011:
		 *     00000100 -
		 *     00000001
		 *     
		 *     00000100:
		 *     00000001 << (i + 1)
		 *     
		 *     mask:
		 *     (~0 << (j + 1)) |
		 *      ((1 << i) - 1)
		 */
		int clearRangeMask = (~0 << (j + 1)) | ((1 << i) - 1);
		
		int nCleared = n & clearRangeMask;
		
		/*
		 * Step 2: Shift m into correct position
		 */
		int mShifted = m << i;
		
		/**
		 * Step 3: Merge with OR
		 */
		return nCleared | mShifted;
	}
	
	public static String smallDoubleToBinary(double num) {
		if (num < 0 || num > 1) {
			throw new IllegalArgumentException("The number should be from interval [0, 1]");
		}
		
		int MAX_LENGTH = 32;
		
		StringBuilder sb = new StringBuilder();
		
		while (num > 0) {
			if (sb.length() >= MAX_LENGTH) {
				return "ERROR";
			}
			
			double r = num * 2.0;
			
			if (r > 1.0) {
				sb.append(1);
				num = r - 1.0;
			} else {
				sb.append(0);
				num = r;
			}
			
		}
		
		return sb.toString();
	}
	
	
	private static void assertIntIsBitValue(int b) {
		if (b != 0 && b != 1) {
			throw new IllegalArgumentException("Bit value should be from set {0, 1}");
		}
	}

	private static void assertBitPositionInInt(int i) {
		if (i < 0 || i > 31) {
			throw new IllegalArgumentException("Bit position should be in range [0-31]");
		}
	}
	
	
}
