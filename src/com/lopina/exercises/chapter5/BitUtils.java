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
