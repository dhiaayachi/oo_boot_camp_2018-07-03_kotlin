package imperial_volume

class Volume(n: Number, units: Units) {
    private val n: Double
    enum class Units {
        TABLE_SPOON, TEA_SPOON
    }

    init {
        if (units == Units.TABLE_SPOON) this.n = n.toDouble() * 3.0
        else this.n = n.toDouble()
    }

    override fun equals(other: Any?): Boolean {
        return this === other || other is Volume && this.equals(other)
    }

    private fun equals(other: Volume) = this.n == other.n

    override fun hashCode()= this.n.hashCode()
}