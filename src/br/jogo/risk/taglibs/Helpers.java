package br.jogo.risk.taglibs;

public class Helpers {
	public static String rawIf(String format, Object... args) {
		boolean allArgsNotNull = true;
		for (Object object : args) {
			if( object == null ) {
				allArgsNotNull = false;
				break;
			}
		}
	    if (args != null && args.length > 0 &&         
	        format != null && format.length()  > 0 && allArgsNotNull)
	        return String.format(format, args);
	    return "";
	}

	public static String rawIf(boolean condition, String content) {
		return condition ? content : ""; 
	}
}