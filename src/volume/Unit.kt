package volume

class Unit {
    private val n: Double

    companion object {
        val teaspoon = Unit(1)
        val tablespoon = teaspoon * 3
        val ounce = tablespoon * 2
        val cup = ounce * 8
        val pint = cup * 2
        val quart = pint * 2
        val gallon = quart * 4
    }

    private operator fun times(i: Int) = Unit(this.n * i)

    private constructor(n: Number) {
        this.n = n.toDouble()
    }
    internal fun ratio(other: Unit):Double{
        return this.n/other.n
    }

    override fun hashCode(): Int {
        return (ratio(teaspoon)).hashCode()
    }
    fun hashCode(q:Double): Int {
        return (q*ratio(teaspoon)).hashCode()
    }
}