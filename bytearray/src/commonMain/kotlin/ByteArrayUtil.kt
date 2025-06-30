package bits

//inline fun checkInRange(byteArray: ByteArray, offset: Int, size: Int)
//    { if ((offset + size < byteArray.size) && (offset >= 0)) throw IndexOutOfBoundsException() }


expect fun ByteArray.setUShortLE(
    offset: Int,
    uShort: UShort
)
expect fun ByteArray.setUShortBE(
    offset: Int,
    uShort: UShort
)

expect fun ByteArray.setShortLE(
    offset: Int,
    short: Short
)

expect fun ByteArray.setShortBE(
    offset: Int,
    short: Short
)

expect fun ByteArray.setULongBE(
    offset: Int,
    uLong: ULong
)

expect fun ByteArray.setULongLE(
    offset: Int,
    uLong: ULong
)

expect fun ByteArray.setLongBE(
    offset: Int,
    long: Long
)


expect fun ByteArray.setLongLE(
    offset: Int,
    long: Long
)

expect fun ByteArray.setIntBE(
    offset: Int,
    int: Int
)

expect fun ByteArray.setIntLE(
    offset: Int,
    int: Int
)

expect fun ByteArray.setUIntBE(
    offset: Int,
    uInt: UInt
)

expect fun ByteArray.setUIntLE(
    offset: Int,
    uInt: UInt
)

expect fun ByteArray.getIntLE(offset: Int): Int
expect fun ByteArray.getIntBE(offset: Int): Int
expect fun ByteArray.getUIntLE(offset: Int): UInt
expect fun ByteArray.getUIntBE(offset: Int): UInt

expect fun ByteArray.getShortLE(offset: Int): Short
expect fun ByteArray.getShortBE(offset: Int): Short
expect fun ByteArray.getUShortLE(offset: Int): UShort
expect fun ByteArray.getUShortBE(offset: Int): UShort

expect fun ByteArray.getLongLE(offset: Int): Long
expect fun ByteArray.getLongBE(offset: Int): Long
expect fun ByteArray.getULongLE(offset: Int): ULong
expect fun ByteArray.getULongBE(offset: Int): ULong

expect fun ByteArray.getFloat(offset: Int): Float
expect fun ByteArray.setFloat(offset: Int, value: Float)

expect fun ByteArray.getDouble(offset: Int): Double
expect fun ByteArray.setDouble(offset: Int, value: Double)

fun byteArrayOf(vararg arrays: ByteArray): ByteArray {
    val newArray = ByteArray(arrays.sumOf { it.size })
    var offset = 0
    arrays.forEach {
        it.copyInto(newArray, offset)
        offset += it.size
    }
    return newArray
}

fun byteArrayOf(arrays: Collection<ByteArray>): ByteArray {
    val newArray = ByteArray(arrays.sumOf { it.size })
    var offset = 0
    arrays.forEach {
        it.copyInto(newArray, offset)
        offset += it.size
    }
    return newArray
}

/**
 * Converts the given int array into a byte array via big-endian conversion
 * (1 int becomes 4 bytes).
 * @return The converted array.
 */
fun IntArray.toByteArrayBE(): ByteArray {
    val array = ByteArray(size * 4)
    for (i in indices) array.setIntBE(i * Int.SIZE_BYTES, get(i))
    return array
}

/**
 * Converts the given byte array into an int array via big-endian conversion (4 bytes become 1 int).
 * @throws IllegalArgumentException if the byte array size is not a multiple of 4.
 */
fun ByteArray.toIntArrayBE(): IntArray {
    if (this.size % Int.SIZE_BYTES != 0) {
        throw IllegalArgumentException("Byte array length must be a multiple of $Int.SIZE_BYTES")
    }

    val array = IntArray(this.size / Int.SIZE_BYTES)
    for (i in array.indices) {
        val iAdjusted = i * Int.SIZE_BYTES
        array[i] = getIntBE(iAdjusted)
    }
    return array
}