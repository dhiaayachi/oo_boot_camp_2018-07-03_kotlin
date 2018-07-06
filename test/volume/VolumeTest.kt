package volume

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class VolumeTest {
    @Test fun equals(){
        assertEquals(Volume(0.5, Unit.cup), Volume(0.5, Unit.cup))
        assertNotEquals(Volume(0.5, Unit.cup), Volume(1, Unit.cup))
        assertEquals(Volume(0.5, Unit.pint), Volume(1, Unit.cup))
        assertEquals(Volume(3, Unit.teaspoon), Volume(1, Unit.tablespoon))
        assertEquals(Volume(1, Unit.gallon), Volume(8, Unit.pint))
        assertEquals(Volume(1, Unit.quart), Volume(2, Unit.pint))
        assertEquals(Volume(1, Unit.cup), Volume(8, Unit.ounce))
        assertEquals(Volume(3, Unit.cup), Volume(8*2*3, Unit.tablespoon))

    }

    @Test fun invalid() {
        assertFailsWith<IllegalArgumentException> { Volume(-2, Unit.pint ) }
        assertFailsWith<IllegalArgumentException> { Volume(1, Unit.teaspoon) - Volume(1, Unit.cup) }
    }

    @Test fun adding() {
        assertEquals(Volume(2, Unit.cup), Volume(1, Unit.cup) + Volume(1, Unit.cup))
        assertEquals(Volume(2, Unit.cup), Volume(1, Unit.cup) + Volume(8, Unit.ounce))
        assertEquals(Volume(0, Unit.teaspoon), Volume(0, Unit.cup) + Volume(0, Unit.quart))
    }
    @Test fun substract() {
        assertEquals(Volume(2, Unit.cup), Volume(3, Unit.cup) - Volume(1, Unit.cup))
        assertEquals(Volume(0, Unit.cup), Volume(3, Unit.teaspoon) - Volume(1, Unit.tablespoon))
    }

    @Test fun hashCodeTest() {
        assertEquals(Volume(1, Unit.teaspoon).hashCode(), Volume(1, Unit.teaspoon).hashCode())
        assertNotEquals(Volume(1, Unit.teaspoon).hashCode(), Volume(1, Unit.tablespoon).hashCode())
        assertEquals(Volume(3, Unit.teaspoon).hashCode(), Volume(1, Unit.tablespoon).hashCode())
        assertEquals(Volume(3, Unit.cup).hashCode(), Volume(8*2*3, Unit.tablespoon).hashCode())
        assert(hashSetOf(Volume(3, Unit.teaspoon)).contains(Volume(1, Unit.tablespoon)))
        assertEquals(Volume(0, Unit.cup).hashCode(), Volume(0, Unit.teaspoon).hashCode())
    }
}
