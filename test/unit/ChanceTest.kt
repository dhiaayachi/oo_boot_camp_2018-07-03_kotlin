/*
 * Copyright (c) 2018 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George
 */
package unit

import chance.Chance
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// Confirms that Chance operates correctly
internal class ChanceTest {
    private val certain = Chance(1)
    private val likely = Chance(0.75)
    private val equallyLikely = Chance(0.5)
    private val unlikely = Chance(0.25)
    private val impossible = Chance(0)

    @Test fun equality() {
        assertEquals(likely, Chance(0.75))
        assertNotEquals(likely, unlikely)
        assertNotEquals(likely, "a string")
        assertNotEquals(likely, null)
    }

    @Test fun `hash set support`() {
        assert(hashSetOf<Chance>(likely).contains(Chance(0.75)))
    }

    @Test fun `hash code`() {
        assertEquals(likely.hashCode(), Chance(0.75).hashCode())
    }

    @Test fun not() {
        assertEquals(unlikely, likely.not())
        assertEquals(likely, likely.not().not())
        assertEquals(unlikely, !likely)
        assertEquals(likely, !!likely)
        assertEquals(impossible, certain.not())
    }
    @Test fun and(){
        assertEquals(impossible,certain.and(certain.not()))
        assertEquals(certain,certain.and(certain))
        assertEquals(Chance(0.125), equallyLikely.and(equallyLikely.and(equallyLikely)))
    }
    @Test fun or() {
        assertEquals(certain, certain.or(certain))
        assertEquals(certain, certain.or(impossible))
        assertEquals(unlikely, unlikely.or(impossible))
        assertEquals(Chance(0.875), equallyLikely.or(equallyLikely).or(equallyLikely))
        assertEquals(Chance((1.0/2.0)-(1.0/16.0)), Chance(1.0/4.0).or(Chance(1.0/4.0)))
    }

}