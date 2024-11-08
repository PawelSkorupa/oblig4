package no.hvl.dat152.obl4.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Validator {

	public static String validString(String parameter) {
		return parameter != null ? parameter : "null";
	}
	
	public static String getCookieValue(HttpServletRequest request,
			String cookieName) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					return c.getValue();
				}
			}
		}
		return null;
	}

	public static boolean validatePassword(String password) {
		if (password == null || password.length() < 8) {
			return false;
		}

		boolean hasUppercase = password.matches(".*[A-Z].*");
		boolean hasLowercase = password.matches(".*[a-z].*");
		boolean hasDigit = password.matches(".*\\d.*");
		boolean hasSpecialChar = password.matches(".*[!@#$%^&*()].*");

		return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
	}
}
