package com.jogjanode.jogjanodeproblem2;

import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args ) {
        try (final var in = new Scanner(System.in)) {
        	final var line1 = in.nextLine();
    		final var nk = validatingLine1(line1);
    		if (nk[0] < 2) throw new RuntimeException("Invalid item size");
    		final var line2 = in.nextLine();
    		final var arr = validatingLine2(line2);
    		if (nk[0] != arr.length) throw new RuntimeException("Invalid item size");
    		final var result = pairs(nk[1], arr);
    		System.out.println(result);
        }
    }

    private static Integer pairs(Integer k, Integer[] arr) {
    	var count = 0;
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = i + 1; j < arr.length; j++) {
    			final var v1 = arr[i];
    			final var v2 = arr[j];
    			final var distance = v1 > v2 ? v1 - v2 : v2 - v1;
    			if (distance ==  k) count++;
    		}
    	}
		return count;
	}

	public static Integer[] validatingLine1(String s) {
		final var sa = Stream.of(s.split(" "))
				.filter(s1 -> !s1.isEmpty() && !s1.isBlank())
				.map(Integer::parseInt)
				.filter(i -> i > 0)
				.toList()
				.toArray(new Integer[] {});
		if (sa.length != 2) throw new RuntimeException("Invalid format numbers");
		return sa;
	}

    public static Integer[] validatingLine2(String s) {
		return Stream.of(s.split(" "))
				.filter(s1 -> !s1.isEmpty() && !s1.isBlank())
				.distinct()
				.map(Integer::parseInt)
				.filter(i -> i > 0)
				.toList()
				.toArray(new Integer[] {});
	}
}
