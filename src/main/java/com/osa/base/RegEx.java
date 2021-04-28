package com.osa.base;

import java.util.regex.Pattern;

public class RegEx {
	public static void main(String[] args) {
		String s="my<name>is sdfsdlfs<lastName>";
	System.out.println(s.subSequence(s.indexOf('<')+1, s.indexOf('>')));
	}
}