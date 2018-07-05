package imperial_volume

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class VolumeTest {
    private val tablespoon = Volume(1, Volume.Units.TABLE_SPOON)
    private val three_teaspoon = Volume(3, Volume.Units.TEA_SPOON)
    private val teaspoon = Volume(3, Volume.Units.TEA_SPOON)

    @Test fun equals(){
        assertEquals(tablespoon, Volume(1, Volume.Units.TABLE_SPOON))
        assertEquals(tablespoon.hashCode(), Volume(1, Volume.Units.TABLE_SPOON).hashCode())
        assertEquals(tablespoon, three_teaspoon)
    }
}
