package com.mikado.mikadosaas.common.util;

import java.security.SecureRandom;

public class RandomStringUtil {

	protected RandomStringUtil() {

	}

	public static String randomString(int length) {
		SecureRandom rnd = new SecureRandom();
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public static String randomNumber(int length) {
		SecureRandom rnd = new SecureRandom();
		final String AB = "0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
