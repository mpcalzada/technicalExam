package com.ks;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class ApplicationTest
{
    @Test
    void name()
    {
        assertEquals(21, Application.yearsToCenturies(2020));
    	Assert.assertTrue(Application.scramble("hdsasdellsdasooawwadwdwawrl", "helloworld"));
        assertEquals(4, Application.duplicateCount("AcCoMmOdAtIOn"));
        assertEquals("h", Application.getMiddle("the"));
        assertEquals("as", Application.getMiddle("easy"));
        assertEquals(2, Application.persistence(999)); // this is wrong, the final number has to be 2 instead of 4
        assertEquals(5, Application.getCount("abracadabra"));
        assertEquals(6, Application.digital_root(789));
        assertArrayEquals(new String[]{"Gi", "ve", " m", "e ", "so", "me", " p", "ai", "rs", " p", "le", "as", "e_"}, Application.solution("Give me some pairs please"));
        assertEquals(2, Application.findShort("Can you think of something more likely"));
        assertEquals("128.15.26.23", Application.longToIP(2148473367L));
        assertEquals(new Integer(5), Application.repeated(new int[]{1, 2, 3, 5, 5, 6, 7, 8, 9, 0, 1}));
    }
}