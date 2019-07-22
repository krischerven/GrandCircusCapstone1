import java.util.Scanner;

public class Week1Capstone {

	public static void main(String[] args) {
		final Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the Pig Latin Translator!");
		boolean cont = true;
		while (cont) {
			System.out.println("Enter a line to be translated:");
			final String line = s.nextLine();
			String translated = "";
			for (final String sub: line.split(" ")) {
				translated += translate(sub);
				translated += " ";
			}
			translated.trim();
			System.out.println("Translated: " + capitalize(translated));
			System.out.println("Continue? (y/n)");
			if (!yes(s.nextLine())) {
				cont = false;
				s.close();
			}
		}
	}
	
	private static String capitalize(final String target) {
		return target.substring(0,1).toUpperCase() + target.substring(1);
	}
	
	private static boolean yes(final String parsing) {
		switch (parsing.toLowerCase().trim()) {
			case "y": 
			case "yes": {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isVowel(final char testing) {
		final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for (final char vowel: vowels) {
			if (testing == vowel) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isConsonant(final char testing) {
		return !isVowel(testing);
	}
	
	private static String translate(String entry) {
		entry = entry.toLowerCase();
		if (isVowel(entry.charAt(0))) {
			return entry+"way";
		} else {
			String tmp = "";
			int lasti = 0;
			for (int i = 0; i < entry.length(); ++i) {
				if (isConsonant(entry.charAt(i))) {
					tmp += entry.charAt(i);
				} else {
					break;
				}
				lasti = i+1;
			}
			String ret = "";
			for (int i = lasti; i < entry.length(); ++i) {
				ret += entry.charAt(i);
			}
			return ret+tmp+"ay";
		}
	}
}