@file:Suppress("unused", "NOTHING_TO_INLINE")

package bits

actual fun ByteArray.setUShortLE(
    offset: Int,
    uShort: UShort
) {
//    checkInRange(this, offset, UShort.SIZE_BYTES)
    set(offset, uShort.extractByte1())
    set(offset + 1, uShort.extractByte2())
}

actual fun ByteArray.setUShortBE(
    offset: Int,
    uShort: UShort
) {
    set(offset, uShort.extractByte2())
    set(offset + 1, uShort.extractByte1())
}

actual fun ByteArray.setShortLE(
    offset: Int,
    short: Short
) {
    set(offset, short.extractByte1())
    set(offset + 1, short.extractByte2())
}

actual fun ByteArray.setShortBE(
    offset: Int,
    short: Short
) {
    set(offset, short.extractByte2())
    set(offset + 1, short.extractByte1())
}

actual fun ByteArray.setULongBE(
    offset: Int,
    uLong: ULong
) {
    set(offset, uLong.extractByte8())
    set(offset + 1, uLong.extractByte7())
    set(offset + 2, uLong.extractByte6())
    set(offset + 3, uLong.extractByte5())
    set(offset + 4, uLong.extractByte4())
    set(offset + 5, uLong.extractByte3())
    set(offset + 6, uLong.extractByte2())
    set(offset + 7, uLong.extractByte1())
}

actual fun ByteArray.setULongLE(
    offset: Int,
    uLong: ULong
) {
    set(offset, uLong.extractByte1())
    set(offset + 1, uLong.extractByte2())
    set(offset + 2, uLong.extractByte3())
    set(offset + 3, uLong.extractByte4())
    set(offset + 4, uLong.extractByte5())
    set(offset + 5, uLong.extractByte6())
    set(offset + 6, uLong.extractByte7())
    set(offset + 7, uLong.extractByte8())
}

actual fun ByteArray.setLongBE(
    offset: Int,
    long: Long
) {
    set(offset, long.extractByte8())
    set(offset + 1, long.extractByte7())
    set(offset + 2, long.extractByte6())
    set(offset + 3, long.extractByte5())
    set(offset + 4, long.extractByte4())
    set(offset + 5, long.extractByte3())
    set(offset + 6, long.extractByte2())
    set(offset + 7, long.extractByte1())
}


actual fun ByteArray.setLongLE(
    offset: Int,
    long: Long
) {
    set(offset, long.extractByte1())
    set(offset + 1, long.extractByte2())
    set(offset + 2, long.extractByte3())
    set(offset + 3, long.extractByte4())
    set(offset + 4, long.extractByte5())
    set(offset + 5, long.extractByte6())
    set(offset + 6, long.extractByte7())
    set(offset + 7, long.extractByte8())
}

actual fun ByteArray.setIntBE(
    offset: Int,
    int: Int
) {
    set(offset, int.extractByte4())
    set(offset + 1, int.extractByte3())
    set(offset + 2, int.extractByte2())
    set(offset + 3, int.extractByte1())
}

actual fun ByteArray.setIntLE(
    offset: Int,
    int: Int
) {
    set(offset, int.extractByte1())
    set(offset + 1, int.extractByte2())
    set(offset + 2, int.extractByte3())
    set(offset + 3, int.extractByte4())
}

actual fun ByteArray.setUIntBE(
    offset: Int,
    uInt: UInt
) {
    set(offset, uInt.extractByte4())
    set(offset + 1, uInt.extractByte3())
    set(offset + 2, uInt.extractByte2())
    set(offset + 3, uInt.extractByte1())
}

actual fun ByteArray.setUIntLE(
    offset: Int,
    uInt: UInt
) {
    set(offset, uInt.extractByte1())
    set(offset + 1, uInt.extractByte2())
    set(offset + 2, uInt.extractByte3())
    set(offset + 3, uInt.extractByte4())
}

actual fun ByteArray.getIntLE(offset: Int) = packIntWithBytes(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3)
)

actual fun ByteArray.getIntBE(offset: Int) = packIntWithBytesBE(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3)
)

actual inline fun ByteArray.getUIntLE(offset: Int) = packIntWithBytes(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3)
).toUInt()

actual inline fun ByteArray.getUIntBE(offset: Int) = packIntWithBytesBE(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3)
).toUInt()

actual fun ByteArray.getShortLE(offset: Int) = packShortWithBytes(
    get(offset),
    get(offset + 1),
)

actual fun ByteArray.getShortBE(offset: Int) = packShortWithBytesBE(
    get(offset),
    get(offset + 1),
)

actual inline fun ByteArray.getUShortLE(offset: Int) = packShortWithBytes(
    get(offset),
    get(offset + 1),
).toUShort()

actual inline fun ByteArray.getUShortBE(offset: Int) = packShortWithBytesBE(
    get(offset),
    get(offset + 1),
).toUShort()

actual fun ByteArray.getULongLE(offset: Int) = packULongWithBytes(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3),
    get(offset + 4),
    get(offset + 5),
    get(offset + 6),
    get(offset + 7)
)

actual fun ByteArray.getULongBE(offset: Int) = packULongWithBytesBE(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3),
    get(offset + 4),
    get(offset + 5),
    get(offset + 6),
    get(offset + 7)
)

actual fun ByteArray.getLongLE(offset: Int) = packLongWithBytes(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3),
    get(offset + 4),
    get(offset + 5),
    get(offset + 6),
    get(offset + 7)
)

actual fun ByteArray.getLongBE(offset: Int) = packLongWithBytesBE(
    get(offset),
    get(offset + 1),
    get(offset + 2),
    get(offset + 3),
    get(offset + 4),
    get(offset + 5),
    get(offset + 6),
    get(offset + 7)
)

actual fun ByteArray.getFloat(offset: Int): Float = Float.fromBits(getIntLE(offset))
actual fun ByteArray.setFloat(offset: Int, value: Float) = setIntLE(offset, value.toRawBits())

actual fun ByteArray.getDouble(offset: Int): Double = Double.fromBits(getLongLE(offset))
actual fun ByteArray.setDouble(offset: Int, value: Double) = setLongLE(offset, value.toRawBits())