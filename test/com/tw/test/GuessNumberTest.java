package com.tw.test;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zw on 2015/12/26.
 */
public class GuessNumberTest {
    private NumberGenerator numGenetator=new NumberGenerator();
    @Test
    public void should_have_four_characters() {
        String numbers = new NumberGenerator().generate();
        assertEquals(numbers.length(), 4);
    }

    @Test
    public void should_it_is_numbers() {
        String numbers = new NumberGenerator().generate();
        assertTrue(numbers.matches("\\d*"));
    }

    @Test
    public void should_it_is_unque() {
        String numbers = new NumberGenerator().generate();
        assertEquals(isUnque(numbers), true);

    }

    private boolean isUnque(String numbers) {
        for (int i = 0; i < numbers.length()-1; i++) {
            if (numbers.charAt(i) == numbers.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void should_be_random(){
        assertEquals(true, israndomEachOther(numGenetator.generate()));
    }
    public boolean israndomEachOther(String onenum){
        String secnum=numGenetator.generate();
        if(secnum.equals(onenum))
            return false;
        else
            return true;
    }

    @Test
    public void should_be_true_result_of0a0b(){
        assertEquals(numGenetator.comResult("1234","5678"),"0A0B");
    }
    @Test
    public void should_be_true_result_of4a0b(){
        assertEquals(numGenetator.comResult("1234","1234"),"4A0B");
    }
    @Test
    public void should_be_true_result_of0a4b(){
        assertEquals(numGenetator.comResult("1234","4321"),"0A4B");
    }
    @Test
    public void should_be_true_result_of2a2b() {
        assertEquals(numGenetator.comResult("1234", "1324"), "2A2B");
    }
}
