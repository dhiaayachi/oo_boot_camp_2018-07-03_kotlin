package volume

class Volume(n: Number, units: Units) {
    private val n: Double
    enum class Units(val u: Int) {
        TEA_SPOON(1),
        TABLE_SPOON(3 * TEA_SPOON.u),
        OUNCE(2 * TABLE_SPOON.u),
        CUP(8 * OUNCE.u),
        PINT(2 * CUP.u),
        QUART(2 * PINT.u),
        GALLON(4 * QUART.u)
    }

    init {
        if (n.toDouble() < 0) throw IllegalArgumentException("Volume must be >= 0")
        this.n = n.toDouble() * units.u
    }

    override fun equals(other: Any?): Boolean {
        return this === other || other is Volume && this.equals(other)
    }

    private fun equals(other: Volume) = this.n == other.n

    override fun hashCode()= this.n.hashCode()
    override fun toString() = this.n.toString()

    operator fun times(i: Number) = Volume(this.n * i.toDouble(), Units.TEA_SPOON)
    operator fun plus(other: Volume) = Volume(this.n + other.n,Volume.Units.TEA_SPOON)
    operator fun minus(other: Volume) = Volume(this.n - other.n, Volume.Units.TEA_SPOON)
    operator fun div(i: Number) = Volume(this.n/i.toDouble(), Units.TEA_SPOON)
}