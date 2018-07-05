package volume

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class VolumeTest {
    private val tablespoon = Volume(1, Volume.Units.TABLE_SPOON)
    private val teaspoon = Volume(1, Volume.Units.TEA_SPOON)
    private val ounce =  Volume(1, Volume.Units.OUNCE)
    private val cup = Volume(1, Volume.Units.CUP)
    private val pint = Volume(1, Volume.Units.PINT)
    private val quart = Volume(1, Volume.Units.QUART)
    private val gallon = Volume(1, Volume.Units.GALLON)

    private val emptyVolume = Volume(0, Volume.Units.GALLON)

    @Test fun equals(){
        assertEquals(tablespoon, Volume(1, Volume.Units.TABLE_SPOON))
        assertEquals(gallon * 1.5, Volume(1.5, Volume.Units.GALLON))
        assertEquals(emptyVolume, Volume(0, Volume.Units.TABLE_SPOON))
        assertEquals(tablespoon.hashCode(), Volume(1, Volume.Units.TABLE_SPOON).hashCode())
    }
    @Test fun invalid(){
        assertFailsWith<IllegalArgumentException> { Volume(-1, Volume.Units.QUART) }
        assertFailsWith<IllegalArgumentException> { Volume(1, Volume.Units.QUART) * -1.5 }
        assertFailsWith<IllegalArgumentException> { Volume(1, Volume.Units.QUART) - (gallon * 1.5) }
        assertFailsWith<IllegalArgumentException> { Volume(1, Volume.Units.QUART) / -1 }
    }

    @Test fun conversion() {
        assertEquals(tablespoon, teaspoon * 3)
        assertEquals(ounce, tablespoon * 2)
        assertEquals(cup, ounce * 8)
        assertEquals(pint, cup * 2)
        assertEquals(quart, pint * 2)
        assertEquals(gallon, quart * 4)
    }

    @Test fun add() {
        assertEquals(tablespoon + teaspoon, teaspoon * 4)
    }

    @Test fun substract() {
        assertEquals(tablespoon - teaspoon, teaspoon * 2)
        assertEquals(tablespoon - tablespoon, teaspoon * 0)
    }

    @Test fun divide() {
        assertEquals(pint, quart / 2)
        assertEquals(teaspoon * 0.5, teaspoon / 2)
    }
}
