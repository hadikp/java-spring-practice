package drill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class palindromeTest {

    @Test
    void testPali() {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.palidrome("dokkod"));
    }

}