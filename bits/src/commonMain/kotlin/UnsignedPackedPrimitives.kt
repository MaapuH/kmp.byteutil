@file: Suppress("unused", "NOTHING_TO_INLINE")

package bits

const val ULONG_BYTE_MASK: ULong = 0xFFu
const val ULONG_SHORT_MASK: ULong = 0xFFFFu
const val ULONG_INT_MASK: ULong = 0xFFFFFFFFu

const val UINT_BYTE_MASK: UInt = 0xFFu
const val UINT_SHORT_MASK: UInt = 0xFFFFu

const val USHORT_BYTE_MASK: UShort = 0xFFu

inline fun packULongWithUShorts(x: UShort, y: UShort, z: UShort, w: UShort) = x.toULong()
    .or(y.toULong().shl(UShort.SIZE_BITS))
    .or(z.toULong().shl(32))
    .or(w.toULong().shl(48))

inline fun packULongWithUShorts(x: UInt, y: UInt, z: UInt, w: UInt) = x.toULong()
    .or(y.toULong().shl(UShort.SIZE_BITS))
    .or(z.toULong().shl(32))
    .or(w.toULong().shl(48))

inline fun packULongWithUShorts(x: ULong, y: ULong, z: ULong, w: ULong) = x.and(ULONG_SHORT_MASK)
    .or(y.and(ULONG_SHORT_MASK).shl(UShort.SIZE_BITS))
    .or(z.and(ULONG_SHORT_MASK).shl(32))
    .or(w.and(ULONG_SHORT_MASK).shl(48))

inline fun packULongWithUInts(x: UInt, y: UInt) = (x.toULong()) or (y.toULong().and(ULONG_INT_MASK).shl(UInt.SIZE_BITS))
inline fun packULongWithUInts(x: ULong, y: ULong) = x.and(ULONG_INT_MASK)
    .or(y.and(ULONG_INT_MASK).shl(UInt.SIZE_BITS))


inline fun packULongWithUBytes(
    a: UByte, b: UByte, c: UByte, d: UByte,
    e: UByte, f: UByte, g: UByte, h: UByte
) = a.toULong()
    .or(b.toULong().shl(UByte.SIZE_BITS))
    .or(c.toULong().shl(16))
    .or(d.toULong().shl(24))
    .or(e.toULong().shl(32))
    .or(f.toULong().shl(40))
    .or(g.toULong().shl(48))
    .or(h.toULong().shl(56))

inline fun packULongWithBytes(
    a: Byte, b: Byte, c: Byte, d: Byte,
    e: Byte, f: Byte, g: Byte, h: Byte
) = a.toULong()
    .or(b.toULong().shl(Byte.SIZE_BITS))
    .or(c.toULong().shl(16))
    .or(d.toULong().shl(24))
    .or(e.toULong().shl(32))
    .or(f.toULong().shl(40))
    .or(g.toULong().shl(48))
    .or(h.toULong().shl(56))

inline fun packULongWithBytesBE(
    a: Byte, b: Byte, c: Byte, d: Byte,
    e: Byte, f: Byte, g: Byte, h: Byte
) = h.toULong()
    .or(g.toULong().shl(Byte.SIZE_BITS))
    .or(f.toULong().shl(16))
    .or(e.toULong().shl(24))
    .or(d.toULong().shl(32))
    .or(c.toULong().shl(40))
    .or(b.toULong().shl(48))
    .or(a.toULong().shl(56))



inline fun packULongWithUBytes(
    a: UInt, b: UInt, c: UInt, d: UInt,
    e: UInt, f: UInt, g: UInt, h: UInt
) = a.toULong()
    .or(b.toULong().shl(UByte.SIZE_BITS))
    .or(c.toULong().shl(16))
    .or(d.toULong().shl(24))
    .or(e.toULong().shl(32))
    .or(f.toULong().shl(40))
    .or(g.toULong().shl(48))
    .or(h.toULong().shl(56))

inline fun packULongWithUBytes(
    a: ULong, b: ULong, c: ULong, d: ULong,
    e: ULong, f: ULong, g: ULong, h: ULong
) = a.and(ULONG_BYTE_MASK)
    .or(b.and(ULONG_BYTE_MASK).shl(UByte.SIZE_BITS))
    .or(c.and(ULONG_BYTE_MASK).shl(16))
    .or(d.and(ULONG_BYTE_MASK).shl(24))
    .or(e.and(ULONG_BYTE_MASK).shl(32))
    .or(f.and(ULONG_BYTE_MASK).shl(40))
    .or(g.and(ULONG_BYTE_MASK).shl(48))
    .or(h.and(ULONG_BYTE_MASK).shl(56))


inline infix fun UInt.toULongWith(other: UInt) = packULongWithUInts(this, other)

inline fun ULong.extractUInt1() = toUInt()
inline fun ULong.extractUInt2() = shr(UInt.SIZE_BITS).toUInt()

inline fun ULong.extractInt1() = toInt()
inline fun ULong.extractInt2() = shr(Int.SIZE_BITS).toInt()

inline fun ULong.extractUInt1AsULong() = and(ULONG_INT_MASK)
inline fun ULong.extractUInt2AsULong() = shr(UInt.SIZE_BITS).extractUInt1AsULong()

inline fun ULong.extractUShort1() = toUShort()
inline fun ULong.extractUShort2() = shr(UShort.SIZE_BITS).toUShort()
inline fun ULong.extractUShort3() = shr(32).toUShort()
inline fun ULong.extractUShort4() = shr(48).toUShort()

inline fun ULong.extractUShort1AsULong() = and(ULONG_SHORT_MASK)
inline fun ULong.extractUShort2AsULong() = shr(UShort.SIZE_BITS).extractUShort1AsULong()
inline fun ULong.extractUShort3AsULong() = shr(32).extractUShort1AsULong()
inline fun ULong.extractUShort4AsULong() = shr(48).extractUShort1AsULong()

inline fun ULong.extractUShort1AsUInt() = and(ULONG_SHORT_MASK).toUInt()
inline fun ULong.extractUShort2AsUInt() = shr(UShort.SIZE_BITS).extractUShort1AsUInt()
inline fun ULong.extractUShort3AsUInt() = shr(32).extractUShort1AsUInt()
inline fun ULong.extractUShort4AsUInt() = shr(48).extractUShort1AsUInt()

inline fun ULong.extractUByte1() = toUByte()
inline fun ULong.extractUByte2() = shr(UByte.SIZE_BITS).toUByte()
inline fun ULong.extractUByte3() = shr(16).toUByte()
inline fun ULong.extractUByte4() = shr(24).toUByte()
inline fun ULong.extractUByte5() = shr(32).toUByte()
inline fun ULong.extractUByte6() = shr(40).toUByte()
inline fun ULong.extractUByte7() = shr(48).toUByte()
inline fun ULong.extractUByte8() = shr(56).toUByte()

inline fun ULong.extractByte1() = toByte()
inline fun ULong.extractByte2() = shr(Byte.SIZE_BITS).toByte()
inline fun ULong.extractByte3() = shr(16).toByte()
inline fun ULong.extractByte4() = shr(24).toByte()
inline fun ULong.extractByte5() = shr(32).toByte()
inline fun ULong.extractByte6() = shr(40).toByte()
inline fun ULong.extractByte7() = shr(48).toByte()
inline fun ULong.extractByte8() = shr(56).toByte()

inline fun ULong.extractUByte1AsULong() = and(ULONG_BYTE_MASK)
inline fun ULong.extractUByte2AsULong() = shr(UByte.SIZE_BITS).extractUByte1AsULong()
inline fun ULong.extractUByte3AsULong() = shr(16).extractUByte1AsULong()
inline fun ULong.extractUByte4AsULong() = shr(24).extractUByte1AsULong()
inline fun ULong.extractUByte5AsULong() = shr(32).extractUByte1AsULong()
inline fun ULong.extractUByte6AsULong() = shr(40).extractUByte1AsULong()
inline fun ULong.extractUByte7AsULong() = shr(48).extractUByte1AsULong()
inline fun ULong.extractUByte8AsULong() = shr(56).extractUByte1AsULong()

inline fun ULong.extractUByte1AsUInt() = and(ULONG_BYTE_MASK).toUInt()
inline fun ULong.extractUByte2AsUInt() = shr(UByte.SIZE_BITS).extractUByte1AsUInt()
inline fun ULong.extractUByte3AsUInt() = shr(16).extractUByte1AsUInt()
inline fun ULong.extractUByte4AsUInt() = shr(24).extractUByte1AsUInt()
inline fun ULong.extractUByte5AsUInt() = shr(32).extractUByte1AsUInt()
inline fun ULong.extractUByte6AsUInt() = shr(40).extractUByte1AsUInt()
inline fun ULong.extractUByte7AsUInt() = shr(48).extractUByte1AsUInt()
inline fun ULong.extractUByte8AsUInt() = shr(56).extractUByte1AsUInt()

inline fun packUIntWithUShorts(x: UShort, y: UShort) = x.toUInt().and(UINT_SHORT_MASK)
    .or(y.toUInt().and(UINT_SHORT_MASK).shl(UShort.SIZE_BITS))

inline fun packUIntWithUShorts(x: UInt, y: UInt) = x.and(UINT_SHORT_MASK)
    .or(y.and(UINT_SHORT_MASK).shl(UShort.SIZE_BITS))

inline fun packUIntWithUBytes(x: UByte, y: UByte, z: UByte, w: UByte) = x.toUInt()
    .or(y.toUInt().shl(UByte.SIZE_BITS))
    .or(z.toUInt().shl(16))
    .or(w.toUInt().shl(24))

inline fun packUIntWithUBytes(x: UInt, y: UInt, z: UInt, w: UInt) = x.and(UINT_BYTE_MASK)
    .or(y.and(UINT_BYTE_MASK).shl(UByte.SIZE_BITS))
    .or(z.and(UINT_BYTE_MASK).shl(16))
    .or(w.and(UINT_BYTE_MASK).shl(24))

inline fun UInt.extractUByte1() = toUByte()
inline fun UInt.extractUByte2() = shr(UByte.SIZE_BITS).extractUByte1()
inline fun UInt.extractUByte3() = shr(16).extractUByte1()
inline fun UInt.extractUByte4() = shr(24).extractUByte1()

inline fun UInt.extractByte1() = toByte()
inline fun UInt.extractByte2() = shr(Byte.SIZE_BITS).extractByte1()
inline fun UInt.extractByte3() = shr(16).extractByte1()
inline fun UInt.extractByte4() = shr(24).extractByte1()

inline fun UInt.extractUByte1AsUInt() = and(UINT_BYTE_MASK)
inline fun UInt.extractUByte2AsUInt() = shr(UByte.SIZE_BITS).extractUByte1AsUInt()
inline fun UInt.extractUByte3AsUInt() = shr(16).extractUByte1AsUInt()
inline fun UInt.extractUByte4AsUInt() = shr(24).extractUByte1AsUInt()

inline fun UInt.extractUShort1() = toUShort()
inline fun UInt.extractUShort2() = shr(UShort.SIZE_BITS).toUShort()

inline fun UInt.extractUShort1AsUInt() = and(UINT_SHORT_MASK)
inline fun UInt.extractUShort2AsUInt() = shr(UShort.SIZE_BITS).extractUShort1AsUInt()

inline fun packUShortWithUBytes(x: UByte, y: UByte) = x.toUInt()
    .or(y.toUInt().and(UINT_BYTE_MASK).shl(UByte.SIZE_BITS))
    .toUShort()

inline fun packUShortWithUBytes(x: UInt, y: UInt) = x.and(UINT_BYTE_MASK)
    .or(y.and(UINT_BYTE_MASK).shl(UByte.SIZE_BITS))
    .toUShort()

inline fun UShort.extractUByte1() = toUByte()
inline fun UShort.extractUByte2() = toInt().shr(UByte.SIZE_BITS).toUByte()

inline fun UShort.extractByte1() = toByte()
inline fun UShort.extractByte2() = toInt().shr(Byte.SIZE_BITS).toByte()

inline fun UShort.extractUByte1AsUInt() = toUInt().and(UINT_BYTE_MASK)
inline fun UShort.extractUByte2AsUInt() = toUInt().shr(UByte.SIZE_BITS).extractUByte1AsUInt()

//fun packULongWithFloats(x: Float, y: Float) = (x.toRawBits().toULong())
//    .or(y.toRawBits().toULong().and(ULONG_INT_MASK).shl(UInt.SIZE_BITS))

//inline fun floatFromUIntBits(intBits: UInt) = java.lang.Float.intBitsToFloat(intBits.toInt())
//
//inline fun ULong.extractFloat1() = floatFromUIntBits(shr(Float.SIZE_BITS).toUInt())
//inline fun ULong.extractAbsFloat1() = floatFromUIntBits((shr(Float.SIZE_BITS).and(0x7FFFFFFFu)).toUInt())
//inline fun ULong.extractFloat2() = floatFromUIntBits(and(ULONG_INT_MASK).toUInt())
//inline fun ULong.extractAbsFloat2() = floatFromUIntBits(and(0x7FFFFFFFu).toUInt())

inline fun UShort.reverseByteOrder(): UShort = (((toInt() and 0xff) shl Byte.SIZE_BITS)
    .or(toInt() ushr Byte.SIZE_BITS)).toUShort()

inline fun UInt.reverseByteOrder(): UInt = (toShort().reverseByteOrder().toInt() shl Short.SIZE_BITS)
    .or(shr(Short.SIZE_BITS).toShort().reverseByteOrder().toInt() and INT_SHORT_MASK).toUInt()

inline fun ULong.reverseByteOrder(): ULong = (toInt().reverseByteOrder().toLong() shl Int.SIZE_BITS)
    .or(shr(Int.SIZE_BITS).toInt().reverseByteOrder().toLong() and LONG_INT_MASK).toULong()
