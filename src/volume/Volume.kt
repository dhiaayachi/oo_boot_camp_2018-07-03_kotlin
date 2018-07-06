package volume

class Volume(n: Number, private val unit: Unit) {
    private val quantity = n.toDouble()

    init {
        if (this.quantity < 0)
            throw IllegalArgumentException("Quantity should be >= 0")
    }

    override fun equals(other: Any?): Boolean {
        return this === other || other is Volume && this.equals(other)
    }

    private fun equals(other: Volume): Boolean {
        return   this.quantity  == convertedAmount(other)
    }

    private fun convertedAmount(other: Volume) = other.unit.ratio(this.unit) * other.quantity

    override fun toString(): String {
        return quantity.toString()
    }

    operator fun plus(other: Volume): Volume {
        return Volume(this.quantity + convertedAmount(other), this.unit)
    }

    operator fun minus(other: Volume): Volume {
        return Volume(this.quantity - convertedAmount(other), this.unit)

    }

    override fun hashCode(): Int {
        return this.unit.hashCode(quantity)
    }
}