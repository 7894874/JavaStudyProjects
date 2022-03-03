/**
 *
 * Regular Expression - Documentation
 * Metacharacters
 * Character	What does it do?
 * $	Matches the end of the input. If in multiline mode, it also matches before a line break character, hence every end of line.
 * (?:x)	Matches 'x' but does NOT remember the match. Also known as NON-capturing parenthesis.
 * (x)	Matches 'x' and remembers the match. Also known as capturing parenthesis.
 * *	Matches the preceding character 0 or more times.
 * +	Matches the preceding character 1 or more times.
 * .	Matches any single character except the newline character.
 * ?
 * Matches the preceding character 0 or 1 time.
 * When used after the quantifiers *, +, ? or {}, makes the quantifier non-greedy; it will match the minimum number of times as opposed to matching the maximum number of times.
 * [\b]	Matches a backspace.
 * [^abc]	Matches anything NOT enclosed by the brackets. Also known as a negative character set.
 * [abc]	Matches any of the enclosed characters. Also known as a character set. You can create range of characters using the hyphen character such as A-Z (A to Z). Note that in character sets, special characters (., *, +) do not have any special meaning.
 * \
 * Used to indicate that the next character should NOT be interpreted literally. For example, the character 'w' by itself will be interpreted as 'match the character w', but using '\w' signifies 'match an alpha-numeric character including underscore'.
 * Used to indicate that a metacharacter is to be interpreted literally. For example, the '.' metacharacter means 'match any single character but a new line', but if we would rather match a dot character instead, we would use '\.'.
 * \0	Matches a NULL character.
 * \b	Matches a word boundary. Boundaries are determined when a word character is NOT followed or NOT preceeded with another word character.
 * \B	Matches a NON-word boundary. Boundaries are determined when two adjacent characters are word characters OR non-word characters.
 * \cX	Matches a control character. X must be between A to Z inclusive.
 * \d	Matches a digit character. Same as [0-9] or [0123456789].
 * \D	Matches a NON-digit character. Same as [^0-9] or [^0123456789].
 * \f	Matches a form feed.
 * \n	Matches a line feed.
 * \r	Matches a carriage return.
 * \s	Matches a single white space character. This includes space, tab, form feed and line feed.
 * \S	Matches anything OTHER than a single white space character. Anything other than space, tab, form feed and line feed.
 * \t	Matches a tab.

 * \v	Matches a vertical tab.
 * \w	Matches any alphanumeric character incuding underscore. Equivalent to [A-Za-z0-9_].
 * \W	Matches anything OTHER than an alphanumeric character incuding underscore. Equivalent to [^A-Za-z0-9_].
 * \x	A back reference to the substring matched by the x parenthetical expression. x is a positive integer.
 * \xhh	Matches a character with the 2-digits hexadecimal code.
 * ^
 * Matches the beginning of the input. If in multiline mode, it also matches after a line break character, hence every new line.
 * When used in a set pattern ([^abc]), it negates the set; match anything not enclosed in the brackets
 * x(?!y)	Matches 'x' only if 'x' is NOT followed by 'y'. Also known as a negative lookahead.
 * x(?=y)	Matches 'x' only if 'x' is followed by 'y'. Also known as a lookahead.
 * x|y	Matches 'x' OR 'y'.
 * {n,m}	Matches the preceding character at least n times and at most m times. n and m can be omitted if zero..
 * {n}	Matches the preceding character exactly n times.
 *
 *
 * Regular Expression - Solutions to common problems (Recipes)
 * How can I emulate DOTALL in JavaScript?
 * DOTALL is a flag in most recent regex libraries that makes the . metacharacter match anything INCLUDING line breaks. JavaScript by default does not support this since the . metacharacter matches anything BUT line breaks. To emulate this behavior, simply replaces all . metacharacters by [\S\s]. This means match anything that is a single white space character OR anything that is not a white space character!
 *
 * [\S\s]
 * How to validate an EMAIL address with a regular expression?
 * There is no 100% reliable solution since the RFC is way too complex. This is the best solution and should work 99% of the time is. Consult this page for more details on this problem. Always turn off case sensitivity!
 *
 * ^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$
 * How to validate an IP address (IPV4) with a regular expression?
 * This will make sure that every number in the IP address is between 0 and 255, unlike the version using \d{1,3} which would allow for 999.999.999.999. If you want to match an IP within a string, get rid of the leading ^ and trailing $ to use \b (word boundaries) instead.
 *
 * ^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$
 * How to validate a DATE with a regular expression?
 * Never use a regular expression to validate a date. The regular expression is only useful to validate the format of the date as entered by a user. For the actual date validity, you should rely on another language.
 *
 * The following expressions will validate the number of days in a month but will NOT handle leap year validation; hence february can have 29 days every year, but not more.
 *
 * ISO date format (yyyy-mm-dd):
 * ^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$
 * ISO date format (yyyy-mm-dd) with separators '-' or '/' or '.' or ' '. Forces usage of same separator accross date.
 * ^[0-9]{4}([- /.])(((0[13578]|(10|12))\1(0[1-9]|[1-2][0-9]|3[0-1]))|(02\1(0[1-9]|[1-2][0-9]))|((0[469]|11)\1(0[1-9]|[1-2][0-9]|30)))$
 * United States date format (mm/dd/yyyy)
 * ^(((0[13578]|(10|12))/(0[1-9]|[1-2][0-9]|3[0-1]))|(02/(0[1-9]|[1-2][0-9]))|((0[469]|11)/(0[1-9]|[1-2][0-9]|30)))/[0-9]{4}$
 * Hours and minutes, 24 hours format (HH:MM):
 * ^(20|21|22|23|[01]\d|\d)((:[0-5]\d){1,2})$
 * How to validate NUMBERS with a regular expression?
 * It depends. What type of number? What precision? What length? What do you want as a decimal separator? Etc. The following examples should help you want with the most common tasks.
 *
 * Positive integers of undefined length:
 * ^\d+$
 * Positive integers of maximum length (10 in our example):
 * ^\d{1,10}$
 * Positive integers of fixed length (5 in our example):
 * ^\d{5}$
 * Negative integers of undefined length:
 * ^-\d+$
 * Negative integers of maximum length (10 in our example):
 * ^-\d{1,10}$
 * Negative integers of fixed length (5 in our example):
 * ^-\d{5}$
 * Integers of undefined length:
 * ^-?\d+$
 * Integers of maximum length (10 in our example):
 * ^-?\d{1,10}$
 * Integers of fixed length (5 in our example):
 * ^-?\d{5}$
 * Numbers of undefined length with or without decimals (1234.1234):
 * ^-?\d*\.{0,1}\d+$
 * Numbers with 2 decimals (.00):
 * ^-?\d*\.\d{2}$
 * Currency numbers with optional dollar sign and thousand separators and optional 2 decimals ($1,000,00.00, 10000.12, 0.00):
 * ^$?\-?([1-9]{1}[0-9]{0,2}(\,\d{3})*(\.\d{0,2})?|[1-9]{1}\d{0,}(\.\d{0,2})?|0(\.\d{0,2})?|(\.\d{1,2}))$|^\-?$?([1-9]{1}\d{0,2}(\,\d{3})*(\.\d{0,2})?|[1-9]{1}\d{0,}(\.\d{0,2})?|0(\.\d{0,2})?|(\.\d{1,2}))$|^\($?([1-9]{1}\d{0,2}(\,\d{3})*(\.\d{0,2})?|[1-9]{1}\d{0,}(\.\d{0,2})?|0(\.\d{0,2})?|(\.\d{1,2}))\)$
 * Percentage from 0 to 100 with optional 2 decimals and optional % sign at the end (0, 0.00, 100.00, 100%, 99.99%):
 * ^-?[0-9]{0,2}(\.[0-9]{1,2})?%?$|^-?(100)(\.[0]{1,2})?%?$
 * How to validate feet and inches with a regular expression?
 * The notation for feet and inches is F'I". Possible values would be 0'0", 6'11", 12456'44"
 *
 * ^\d+'(\d|1[01])"$
 * How to validate an hexadecimal color code (#FFFFFF) with a regular expression?
 * The leading # sign is optional and the color code can take either the 6 or 3 hexadecimal digits format.
 *
 * ^#?([a-f0-9]{6}|[a-f0-9]{3})$
 * How to check for ALPHANUMERIC values with a regular expression?
 * You could make use of \w, but it also tolerates the underscore character.
 *
 * ^[a-zA-Z0-9]+$
 * How to validate a SSN (Social Security Number) with a regular expression?
 * Unlike many other similar numbers such as the canadian social insurance number (SIN) there is no checksum for a SSN. Validating the format of the SSN does not mean it's valid per say though.
 *
 * ^\d{3}-?\d{2}-?\d{4}$
 * How to validate a SIN (Social Insurance Number) with a regular expression?
 * This will only validate the format. A SIN should also be validated by computing the checksum digit. This regex will tolerate the form XXX XXX XXX, XXXXXXXX or XXX-XXX-XXX. Note that the group separator must be the same.
 *
 * ^\d{3}([\s-])?\d{3}\1\d{3}$
 * How to validate a US Zip Code with a regular expression?
 * The United States Postal Services makes use of zip codes. Zip codes have 5 digits OR 9 digits in what is known as a Zip+4.
 *
 * Zip Code (99999)
 * ^\d{5}$
 * Zip and Zip+4 (99999-9999)
 * ^\d{5}(-\d{4})?$
 * How to validate a Canadian Postal Code with a regular expression?
 * The Canadian Postal Services uses postal code. The postal codes are in format X9X 9X9. This will tolerate a space between the first and second group.
 *
 * ^[ABCEGHJKLMNPRSTVXY]{1}\d{1}[A-Z]{1} *\d{1}[A-Z]{1}\d{1}$
 * How to extract the filename in a windows path using a regular expression?
 * Since every part of a path is separated by a \ character, we only need to find the last one. Note that there's just no way to check if the last portion of a path is a file or a directory just by the name alone. You could try to match for an extension, but there's no requirement for a file to have an extension.
 *
 * [^\\]+$
 * How to validate a US or Canadian telephone number using a regular expression?
 * There are probably dozens of way to format a phone number. Your user interface should take care of the formatting problem by having a clear documentation on the format and/or split the phone into parts (area, exchange, number) and/or have an entry mask. The following expression is pretty lenient on the format and should accept 999-999-9999, 9999999999, (999) 999-9999.
 *
 * ^(\d{10})|(([\(]?([0-9]{3})[\)]?)?[ \.\-]?([0-9]{3})[ \.\-]([0-9]{4}))$
 * How to validate credit cards using a regular expression?
 * Again, you should rely on other methods since the regular expressions here will only validate the format. Make use of the Luhn algorithm to properly validate a card.
 *
 * VISA:
 * ^4[0-9]{12}(?:[0-9]{3})?$
 * MasterCard:
 * ^5[1-5][0-9]{14}$
 * American Express:
 * ^3[47][0-9]{13}$
 * Diners Club:
 * ^3(?:0[0-5]|[68][0-9])[0-9]{11}$
 * Discover:
 * ^6(?:011|5[0-9]{2})[0-9]{12}$
 * JCB:
 * ^(?:2131|1800|35\d{3})\d{11}$
 * How do I strip all HTML tags from a string?
 * Make sure to be in global mode (g flag), case insensitive and to have the dot all option on. This regular expression will match all HTML tags and their attributes. This will LEAVE the content of the tags within the string.
 *
 * <(.|\n)+?>
 * How can I remove all blank lines from a string using regular expression?
 * Make sure to be in global and multiline mode. Use an empty string as a replacement value.
 *
 * ^\s*\r?\n
 *
 *
 *
 *
 */


public class ReplaceSymbols {

    public static String ToDoReplacement(String strBefore) {

        // все возможные символы пробелов, которые только могут быть в java

        String whitespace_chars = ""       /* dummy empty string for homogeneity */
                + "\u0009" // CHARACTER TABULATION
                + "\u000B" // LINE TABULATION
                + "\u000C" // FORM FEED (FF)
                + "\u0020" // SPACE
                + "\u0085" // NEXT LINE (NEL)
                + "\u00A0" // NO-BREAK SPACE
                + "\u1680" // OGHAM SPACE MARK
                + "\u180E" // MONGOLIAN VOWEL SEPARATOR
                + "\u2000" // EN QUAD
                + "\u2001" // EM QUAD
                + "\u2002" // EN SPACE
                + "\u2003" // EM SPACE
                + "\u2004" // THREE-PER-EM SPACE
                + "\u2005" // FOUR-PER-EM SPACE
                + "\u2006" // SIX-PER-EM SPACE
                + "\u2007" // FIGURE SPACE
                + "\u2008" // PUNCTUATION SPACE
                + "\u2009" // THIN SPACE
                + "\u200A" // HAIR SPACE
                + "\u2028" // LINE SEPARATOR
                + "\u2029" // PARAGRAPH SEPARATOR
                + "\u202F" // NARROW NO-BREAK SPACE
                + "\u205F" // MEDIUM MATHEMATICAL SPACE
                + "\u3000" // IDEOGRAPHIC SPACE
                ;

        String digits = "0-9";
        String allLettersAndDigitsExeptSpecial_symbols = "[^A-Za-z0-9]"; //// \D
        String lettersForExeption = "[tnfr]";

        /* A \s that actually works for Java’s native character set: Unicode */
        String whitespace_charclass = "[" + whitespace_chars + allLettersAndDigitsExeptSpecial_symbols + lettersForExeption +"]";
        /* A \S that actually works for  Java’s native character set: Unicode */
        // String not_whitespace_charclass = "[^" + whitespace_chars + "]";

        String aString = strBefore.replaceAll(whitespace_charclass, "");

        return aString;

    }

}
