@file: Suppress("unused", "NOTHING_TO_INLINE")

package bits

fun UInt.to32BitBinaryStringBE(): String = toString(2).padStart(Int.SIZE_BITS, '0')

fun Int.hasMask(mask: Int) = and(mask) == mask
fun Int.setBitAsBoolean(index: Int, value: Boolean) = if (value) or(INT_BIT_ONE.shl(index)) else and(INT_BIT_ONE.shl(index).inv())

fun Int.setBit(index: Int, bit: Int) = if (bit == INT_BIT_ONE) or(bit.shl(index)) else and(bit.shl(index).inv())
fun Int.getBit(position: Int) = shr(position) and INT_BIT_ONE

fun UInt.setBit(index: Int, bit: UInt) = if (bit == UINT_BIT_ONE) or(bit.shl(index)) else and(bit.shl(index).inv())
fun UInt.getBit(position: Int) = shr(position) and UINT_BIT_ONE

fun UInt.hasMask(mask: UInt) = and(mask) == mask
fun UInt.setBitAsBoolean(index: Int, value: Boolean) = if (value) or(UINT_BIT_ONE.shl(index)) else and(UINT_BIT_ONE.shl(index).inv())

fun Int.makeBitOne(index: Int) = or(INT_BIT_ONE.shl(index))


const val UINT_SINGLE_BIT_MASK = 1u
const val UINT_BIT_ONE = 1u
const val UINT_BIT_ZERO = 0u

const val INT_SINGLE_BIT_MASK = 1
const val INT_BIT_ONE = 1
const val INT_BIT_ZERO = 0


fun makeLeastSignificantBitsOne(size: Int): UInt = (UInt.MAX_VALUE).shr(Int.SIZE_BITS - size)
fun makeContinuosBitsOne(offset: Int, size: Int): UInt = makeLeastSignificantBitsOne(size).shl(offset)
