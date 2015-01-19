package com.lopina.important.take2.quickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort {
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static <T> void sort(T[] array, Comparator<T> comparator) {
		System.out.println("Sort");
		quickSort(array, comparator, 0, array.length - 1);
		System.out.println(arrayToString(array, 0, array.length - 1));
	}
	
	public static <T> void partialSort(T[] array, Comparator<T> comparator, int k) {
		System.out.println("PartialSort");
		partialQuickSort(array, comparator, 0, array.length - 1, k);
		System.out.println(arrayToString(array, 0, array.length - 1));
	}
	
	public static <T> void partialQuickSort(T[] array, Comparator<T> comparator, int fromIndex, int toIndex, int k) {
		System.out.println("\tQuickSort[" + fromIndex + ", " + toIndex + "]");
		if (fromIndex >= toIndex) {
			if (fromIndex == toIndex) {
				System.out.println("\t" + arrayToString(array, fromIndex, toIndex));
			}
			return;
		}
		
		int medianIndex = partition(array, comparator, fromIndex, toIndex);
		quickSort(array, comparator, fromIndex, medianIndex - 1);
		
		if (medianIndex < k - 1) {
			quickSort(array, comparator, medianIndex + 1, toIndex);
		}
		
		System.out.println("\t" + arrayToString(array, fromIndex, toIndex));
	}
	
	public static <T> void quickSort(T[] array, Comparator<T> comparator, int fromIndex, int toIndex) {
		System.out.println("\tQuickSort[" + fromIndex + ", " + toIndex + "]");
		if (fromIndex >= toIndex) {
			if (fromIndex == toIndex) {
				System.out.println("\t" + arrayToString(array, fromIndex, toIndex));
			}
			return;
		}
		
		int medianIndex = partition(array, comparator, fromIndex, toIndex);
		quickSort(array, comparator, fromIndex, medianIndex - 1);
		quickSort(array, comparator, medianIndex + 1, toIndex);
		System.out.println("\t" + arrayToString(array, fromIndex, toIndex));
	}
	
	public static <T> int partition(T[] array, Comparator<T> comparator, int fromIndex, int toIndex) {
		System.out.println("\t\tPartition[" + fromIndex + ", " + toIndex + "]");
		int k = (toIndex - fromIndex + 1) / 2;
		int medianIndex = randomIndex(fromIndex, toIndex);
		
		medianIndex = partitionAround(array, comparator, fromIndex, toIndex, medianIndex);
		
		System.out.println("\t\t" + arrayToString(array, fromIndex, toIndex, medianIndex));
		return medianIndex;
	}
	
	public static <T> int kThOrderStatistic(T[] array, Comparator<T> comparator, int fromIndex, int toIndex, int k) {
		System.out.println("\t\t\tKThOrderStatistic[" + fromIndex + ", " + toIndex + ", " + k + "]");
		int pivotIndex = 0;
		while (toIndex > fromIndex) {
			pivotIndex = randomIndex(fromIndex, toIndex);
			pivotIndex = partitionAround(array, comparator, fromIndex, toIndex, pivotIndex);
			
			if (k == pivotIndex) {
				System.out.println("\t\t\tPivot matched: " + arrayToString(array, fromIndex, toIndex, pivotIndex));
				return k;
			} else if (k < pivotIndex) {
				toIndex = pivotIndex - 1;
			} else {
				fromIndex = pivotIndex + 1;
			}
		}
		
		System.out.println("\t\t\t" + arrayToString(array, fromIndex, toIndex, pivotIndex));
		return fromIndex;
	}
	
	public static <T> int partitionAround(T[] array, Comparator<T> comparator, int fromIndex, int toIndex, int pivotIndex) {
		System.out.println("\t\t\t\tPartitionAround[" + fromIndex + ", " + toIndex + ", " + pivotIndex + "]");
		swap(array, fromIndex, pivotIndex);
		
		int from = fromIndex;
		int to = toIndex + 1;
		
		T pivot = array[from];
		while (true) {
			while (comparator.compare(array[++from], pivot) < 0) {
				if (from == toIndex) {
					break;
				}
			}
			
			while (comparator.compare(pivot, array[--to]) < 0) {
				if (to == fromIndex) {
					break;
				}
			}
			
			if (from >= to) {
				break;
			}
			
			swap(array, from, to);
		}
		
		swap(array, fromIndex, to);
		
		return to;
	}

	private static int randomIndex(int fromIndex, int toIndex) {
		int randomIndex = random.nextInt(toIndex - fromIndex  + 1) + fromIndex;
		System.out.println("\t\tRandomIndex[" + fromIndex + ", " + toIndex + ", " + randomIndex + "]");
		return randomIndex;
	}
	
	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		Comparator<Integer> naturalComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		Integer[] randomArray;
		
		randomArray = new Integer[15];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(6) + i*6;
		}
		List<Integer> list = Arrays.asList(randomArray);
		Collections.shuffle(list, random);
		randomArray = list.toArray(randomArray);
		Integer[] randomArray2 = list.toArray(new Integer[randomArray.length]);
		Integer[] randomArray3 = list.toArray(new Integer[randomArray.length]);
		
		System.out.println(Arrays.toString(randomArray));
		QuickSort.sort(randomArray, naturalComparator);
		System.out.println(Arrays.toString(randomArray));
		
		System.out.println(" 4th order statistic: " + randomArray2[QuickSort.kThOrderStatistic(randomArray2, naturalComparator, 0, randomArray2.length - 1, 4)]);
		System.out.println("11th order statistic: " + randomArray2[QuickSort.kThOrderStatistic(randomArray2, naturalComparator, 0, randomArray2.length - 1, 11)]);
		
		System.out.println(Arrays.toString(randomArray3));
		QuickSort.partialSort(randomArray3, naturalComparator, 4);
		System.out.println(Arrays.toString(randomArray3));
	}
	
	private static <T> String arrayToString(T[] array, int from, int to) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for (int i = 0; i < array.length; i++) {
			if (i == from) {
				sb.append("|");
			}
			
			sb.append(array[i]);
			
			if (i == to) {
				sb.append("|");
			}
			
			if (i < array.length - 1) {
				sb.append(", ");
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	private static <T> String arrayToString(T[] array, int from, int to, int pivotIndex) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for (int i = 0; i < array.length; i++) {
			if (i == from) {
				sb.append("|");
			}
			
			if (i == pivotIndex) {
				sb.append("|(");
			}
			
			sb.append(array[i]);
			
			if (i == pivotIndex) {
				sb.append(")|");
			}
			
			
			if (i == to) {
				sb.append("|");
			}
			
			if (i < array.length - 1) {
				sb.append(", ");
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
}
