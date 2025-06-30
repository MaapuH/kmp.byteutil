@file: Suppress("unused")

package bits

import java.lang.invoke.MethodHandles
import java.nio.ByteOrder

private val byteArrayAsShortViewLE = MethodHandles
    .byteArrayViewVarHandle(ShortArray::class.java, ByteOrder.LITTLE_ENDIAN)
    .withInvokeExactBehavior()
private val byteArrayAsIntViewLE = MethodHandles
    .byteArrayViewVarHandle(IntArray::class.java, ByteOrder.LITTLE_ENDIAN)
    .withInvokeExactBehavior()
private val byteArrayAsLongViewLE = MethodHandles
    .byteArrayViewVarHandle(LongArray::class.java, ByteOrder.LITTLE_ENDIAN)
    .withInvokeExactBehavior()

private val byteArrayAsShortViewBE = MethodHandles
    .byteArrayViewVarHandle(ShortArray::class.java, ByteOrder.BIG_ENDIAN)
    .withInvokeExactBehavior()
private val byteArrayAsIntViewBE = MethodHandles
    .byteArrayViewVarHandle(IntArray::class.java, ByteOrder.BIG_ENDIAN)
    .withInvokeExactBehavior()
private val byteArrayAsLongViewBE = MethodHandles
    .byteArrayViewVarHandle(LongArray::class.java, ByteOrder.BIG_ENDIAN)
    .withInvokeExactBehavior()

private val byteArrayAsFloatView = MethodHandles
    .byteArrayViewVarHandle(FloatArray::class.java, ByteOrder.LITTLE_ENDIAN)
    .withInvokeExactBehavior()
private val byteArrayAsDoubleView = MethodHandles
    .byteArrayViewVarHandle(DoubleArray::class.java, ByteOrder.LITTLE_ENDIAN)
    .withInvokeExactBehavior()

actual fun ByteArray.setUShortLE(
    offset: Int,
    uShort: UShort
) = byteArrayAsShortViewLE.set(this, offset, uShort.toShort())

actual fun ByteArray.setUShortBE(
    offset: Int,
    uShort: UShort
) = byteArrayAsShortViewBE.set(this, offset, uShort.toShort())

actual fun ByteArray.setShortLE(
    offset: Int,
    short: Short
) = byteArrayAsShortViewLE.set(this, offset, short)

actual fun ByteArray.setShortBE(
    offset: Int,
    short: Short
) = byteArrayAsShortViewBE.set(this, offset, short)

actual fun ByteArray.setULongBE(
    offset: Int,
    uLong: ULong
) = byteArrayAsLongViewBE.set(this, offset, uLong.toLong())

actual fun ByteArray.setULongLE(
    offset: Int,
    uLong: ULong
) = byteArrayAsLongViewLE.set(this, offset, uLong.toLong())

actual fun ByteArray.setLongBE(
    offset: Int,
    long: Long
) = byteArrayAsLongViewBE.set(this, offset, long)


actual fun ByteArray.setLongLE(
    offset: Int,
    long: Long
) = byteArrayAsLongViewLE.set(this, offset, long)

actual fun ByteArray.setIntBE(
    offset: Int,
    int: Int
) = byteArrayAsIntViewBE.set(this, offset, int)

actual fun ByteArray.setIntLE(
    offset: Int,
    int: Int
) = byteArrayAsIntViewLE.set(this, offset, int)

actual fun ByteArray.setUIntBE(
    offset: Int,
    uInt: UInt
) = byteArrayAsIntViewBE.set(this, offset, uInt.toInt())

actual fun ByteArray.setUIntLE(
    offset: Int,
    uInt: UInt
) = byteArrayAsIntViewLE.set(this, offset, uInt.toInt())

actual fun ByteArray.getIntLE(offset: Int): Int = byteArrayAsIntViewLE.get(this, offset) as Int
actual fun ByteArray.getIntBE(offset: Int): Int = byteArrayAsIntViewBE.get(this, offset) as Int
actual fun ByteArray.getUIntLE(offset: Int): UInt = (byteArrayAsIntViewLE.get(this, offset) as Int).toUInt()
actual fun ByteArray.getUIntBE(offset: Int): UInt = (byteArrayAsIntViewBE.get(this, offset) as Int).toUInt()

actual fun ByteArray.getShortLE(offset: Int): Short = byteArrayAsShortViewLE.get(this, offset) as Short
actual fun ByteArray.getShortBE(offset: Int): Short = byteArrayAsShortViewBE.get(this, offset) as Short
actual fun ByteArray.getUShortLE(offset: Int): UShort = (byteArrayAsShortViewLE.get(this, offset) as Short).toUShort()
actual fun ByteArray.getUShortBE(offset: Int): UShort = (byteArrayAsShortViewBE.get(this, offset) as Short).toUShort()

actual fun ByteArray.getLongLE(offset: Int): Long = byteArrayAsLongViewLE.get(this, offset) as Long
actual fun ByteArray.getLongBE(offset: Int): Long = byteArrayAsLongViewBE.get(this, offset) as Long
actual fun ByteArray.getULongLE(offset: Int): ULong = (byteArrayAsLongViewLE.get(this, offset) as Long).toULong()
actual fun ByteArray.getULongBE(offset: Int): ULong = (byteArrayAsLongViewBE.get(this, offset) as Long).toULong()

actual fun ByteArray.getFloat(offset: Int): Float = byteArrayAsFloatView.get(this, offset) as Float
actual fun ByteArray.setFloat(offset: Int, value: Float) = byteArrayAsFloatView.set(this, offset, value)

actual fun ByteArray.getDouble(offset: Int): Double = byteArrayAsDoubleView.get(this, offset) as Double
actual fun ByteArray.setDouble(offset: Int, value: Double) = byteArrayAsDoubleView.set(this, offset, value)