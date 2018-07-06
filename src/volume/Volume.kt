package volume

class Volume(n: Number, unit: Unit) {
    private val quantity = n.toDouble() * unit.ratio(Unit.teaspoon)

    init {
        if (this.quantity < 0)
            throw IllegalArgumentException("Quantity should be >= 0")
    }

    override fun equals(other: Any?): Boolean {
        return this === other || other is Volume && this.equals(other)
    }

    private fun equals(other: Volume): Boolean {
        return   this.quantity  == other.quantity
    }

    override fun toString(): String {
        return quantity.toString()
    }

    operator fun plus(other: Volume): Volume {
        return Volume(this.quantity + other.quantity, Unit.teaspoon)
    }

    operator fun minus(other: Volume): Volume {
        return Volume(this.quantity - other.quantity, Unit.teaspoon)

    }

    override fun hashCode(): Int {
        return this.quantity.hashCode()
    }
}