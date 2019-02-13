package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        Integer count = 0;

        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) == 'z' || input.charAt(i) == 'y')) {
                if (i == input.length() - 1) {
                    count++;
                } else if (!(Character.isLetter(input.charAt(i + 1)))) {
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String remove, String base) {
        StringBuilder removed = new StringBuilder(remove);

        int start = removed.indexOf(base);
        int end = start + base.length();

        while (start != -1) {
            removed.replace(start, end, "");
            start = removed.indexOf(base, end);
            end = start + base.length();
        }

        return removed.toString();
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        boolean res = false;
        int countIs = 0;
        int countNot = 0;
        int startIS = input.indexOf("is");
        int endIs = startIS + 1;
        int startNot = input.indexOf("not");
        int endNot = startNot + 2;

        while (startIS != -1)
        {
            countIs++;
            startIS = input.indexOf("is", endIs);
            endIs =  startIS + 1;
        }

        while (startNot != -1)
        {
            countNot++;
            startNot = input.indexOf("not", endNot);
            endNot =  startNot + 2;
        }

        if(countIs == countNot)
        {
            res = true;
        }

        return res;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        boolean happy = true;

        for (int i = 1; i < input.length()-1; i++) {
            if(input.charAt(i) == 'g')
            {
                if(!(input.charAt(i-1) == 'g' || input.charAt(i+1) == 'g'))
                {
                    happy = false;
                    i = input.length();
                }
            }

        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        Integer count = 0;

        for (int i = 0; i < input.length()-2; i++) {
            if(input.charAt(i+1) == input.charAt(i) && input.charAt(i+2) == input.charAt(i))
            {
                count++;
            }

        }
        return count;
    }
}
