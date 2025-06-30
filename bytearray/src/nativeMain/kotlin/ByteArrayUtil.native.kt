@file:OptIn(ExperimentalNativeApi::class)
@file:Suppress("unused", "NOTHING_TO_INLINE")

package bits

import kotlin.experimental.ExperimentalNativeApi

actual inline fun ByteArray.setUShortLE(
    offset: Int,
    uShort: UShort
) = setUShortAt(offset, uShort)

actual fun ByteArray.setUShortBE(
    offset: Int,
    uShort: UShort
) = setUShortAt(offset, uShort.reverseByteOrder())

actual inline fun ByteArray.setShortLE(
    offset: Int,
    short: Short
) = setShortAt(offset, short)

actual fun ByteArray.setShortBE(
    offset: Int,
    short: Short
) = setShortAt(offset, short.reverseByteOrder())

actual fun ByteArray.setULongBE(
    offset: Int,
    uLong: ULong
) = setULongAt(offset, uLong.reverseByteOrder())

actual inline fun ByteArray.setULongLE(
    offset: Int,
    uLong: ULong
) = setULongAt(offset, uLong)

actual fun ByteArray.setLongBE(
    offset: Int,
    long: Long
) = setLongAt(offset, long.reverseByteOrder())


actual inline fun ByteArray.setLongLE(
    offset: Int,
    long: Long
) = setLongAt(offset, long)

actual fun ByteArray.setIntBE(
    offset: Int,
    int: Int
) = setIntAt(offset, int.reverseByteOrder())

actual inline fun ByteArray.setIntLE(
    offset: Int,
    int: Int
) = setIntAt(offset, int)

actual fun ByteArray.setUIntBE(
    offset: Int,
    uInt: UInt
) = setUIntAt(offset, uInt.reverseByteOrder())

actual inline fun ByteArray.setUIntLE(
    offset: Int,
    uInt: UInt
) = setUIntAt(offset, uInt)

actual inline fun ByteArray.getIntLE(offset: Int): Int = getIntAt(offset)
actual fun ByteArray.getIntBE(offset: Int): Int = getIntAt(offset).reverseByteOrder()
actual inline fun ByteArray.getUIntLE(offset: Int): UInt = getUIntAt(offset)
actual fun ByteArray.getUIntBE(offset: Int): UInt = getUIntAt(offset).reverseByteOrder()

actual inline fun ByteArray.getShortLE(offset: Int): Short = getShortAt(offset)
actual fun ByteArray.getShortBE(offset: Int): Short = getShortAt(offset).reverseByteOrder()
actual inline fun ByteArray.getUShortLE(offset: Int): UShort = getUShortAt(offset)
actual fun ByteArray.getUShortBE(offset: Int): UShort = getUShortAt(offset).reverseByteOrder()

actual inline fun ByteArray.getLongLE(offset: Int): Long = getLongAt(offset)
actual fun ByteArray.getLongBE(offset: Int): Long = getLongAt(offset).reverseByteOrder()
actual inline fun ByteArray.getULongLE(offset: Int): ULong = getULongAt(offset)
actual fun ByteArray.getULongBE(offset: Int): ULong = getULongAt(offset).reverseByteOrder()

actual inline fun ByteArray.getFloat(offset: Int): Float = getFloatAt(offset)
actual inline fun ByteArray.setFloat(offset: Int, value: Float) = setFloatAt(offset, value)

actual inline fun ByteArray.getDouble(offset: Int): Double = getDoubleAt(offset)
actual inline fun ByteArray.setDouble(offset: Int, value: Double) = setDoubleAt(offset, value)