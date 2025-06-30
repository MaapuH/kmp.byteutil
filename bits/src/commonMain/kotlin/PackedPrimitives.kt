@file: Suppress("unused", "NOTHING_TO_INLINE")

package bits

const val LONG_BYTE_MASK: Long = 0xFF
const val LONG_SHORT_MASK: Long = 0xFF_FF
const val LONG_INT_MASK: Long = 0xFF_FF_FF_FF

const val INT_BYTE_MASK: Int = 0xFF
const val INT_SHORT_MASK: Int = 0xFF_FF

const val SHORT_BYTE_MASK: Short = 0xFF

inline fun packLongWithShorts(x: Short, y: Short, z: Short, w: Short) = x.toLong()
    .or(y.toLong().shl(Short.SIZE_BITS))
    .or(z.toLong().shl(32))
    .or(w.toLong().shl(48))

inline fun packLongWithShorts(x: Int, y: Int, z: Int, w: Int) = x.toLong()
    .or(y.toLong().shl(Short.SIZE_BITS))
    .or(z.toLong().shl(32))
    .or(w.toLong().shl(48))

inline fun packLongWithShorts(x: Long, y: Long, z: Long, w: Long) = x.and(LONG_SHORT_MASK)
    .or(y.and(LONG_SHORT_MASK).shl(Short.SIZE_BITS))
    .or(z.and(LONG_SHORT_MASK).shl(32))
    .or(w.and(LONG_SHORT_MASK).shl(48))

inline fun packLongWithInts(x: Int, y: Int) = (x.toLong()) or (y.toLong().and(LONG_INT_MASK).shl(Int.SIZE_BITS))
inline fun packLongWithInts(x: Long, y: Long) = x.and(LONG_INT_MASK)
    .or(y.and(LONG_INT_MASK).shl(Int.SIZE_BITS))


inline fun packLongWithBytes(
    a: Byte, b: Byte, c: Byte, d: Byte,
    e: Byte, f: Byte, g: Byte, h: Byte
) = a.toLong()
    .or(b.toLong().shl(Byte.SIZE_BITS))
    .or(c.toLong().shl(16))
    .or(d.toLong().shl(24))
    .or(e.toLong().shl(32))
    .or(f.toLong().shl(40))
    .or(g.toLong().shl(48))
    .or(h.toLong().shl(56))

inline fun packLongWithBytesBE(
    a: Byte, b: Byte, c: Byte, d: Byte,
    e: Byte, f: Byte, g: Byte, h: Byte
) = h.toLong()
    .or(g.toLong().shl(Byte.SIZE_BITS))
    .or(f.toLong().shl(16))
    .or(e.toLong().shl(24))
    .or(d.toLong().shl(32))
    .or(c.toLong().shl(40))
    .or(b.toLong().shl(48))
    .or(a.toLong().shl(56))


inline fun packLongWithBytes(
    a: Int, b: Int, c: Int, d: Int,
    e: Int, f: Int, g: Int, h: Int
) = a.toLong()
    .or(b.toLong().shl(Byte.SIZE_BITS))
    .or(c.toLong().shl(16))
    .or(d.toLong().shl(24))
    .or(e.toLong().shl(32))
    .or(f.toLong().shl(40))
    .or(g.toLong().shl(48))
    .or(h.toLong().shl(56))

inline fun packLongWithBytes(
    a: Long, b: Long, c: Long, d: Long,
    e: Long, f: Long, g: Long, h: Long
) = a.and(LONG_BYTE_MASK)
    .or(b.and(LONG_BYTE_MASK).shl(Byte.SIZE_BITS))
    .or(c.and(LONG_BYTE_MASK).shl(16))
    .or(d.and(LONG_BYTE_MASK).shl(24))
    .or(e.and(LONG_BYTE_MASK).shl(32))
    .or(f.and(LONG_BYTE_MASK).shl(40))
    .or(g.and(LONG_BYTE_MASK).shl(48))
    .or(h.and(LONG_BYTE_MASK).shl(56))


inline infix fun Int.toLongWith(other: Int) = packLongWithInts(this, other)

inline fun Long.extractInt1() = toInt()
inline fun Long.extractInt2() = shr(Int.SIZE_BITS).toInt()

inline fun Long.extractInt1AsLong() = and(LONG_INT_MASK)
inline fun Long.extractInt2AsLong() = shr(Int.SIZE_BITS).extractInt1AsLong()

inline fun Long.extractShort1() = toShort()
inline fun Long.extractShort2() = shr(Short.SIZE_BITS).toShort()
inline fun Long.extractShort3() = shr(32).toShort()
inline fun Long.extractShort4() = shr(48).toShort()

inline fun Long.extractShort1AsLong() = and(LONG_SHORT_MASK)
inline fun Long.extractShort2AsLong() = shr(Short.SIZE_BITS).extractShort1AsLong()
inline fun Long.extractShort3AsLong() = shr(32).extractShort1AsLong()
inline fun Long.extractShort4AsLong() = shr(48).extractShort1AsLong()

inline fun Long.extractShort1AsInt() = and(LONG_SHORT_MASK).toInt()
inline fun Long.extractShort2AsInt() = shr(Short.SIZE_BITS).extractShort1AsInt()
inline fun Long.extractShort3AsInt() = shr(32).extractShort1AsInt()
inline fun Long.extractShort4AsInt() = shr(48).extractShort1AsInt()

inline fun Long.extractByte1() = toByte()
inline fun Long.extractByte2() = shr(Byte.SIZE_BITS).toByte()
inline fun Long.extractByte3() = shr(16).toByte()
inline fun Long.extractByte4() = shr(24).toByte()
inline fun Long.extractByte5() = shr(32).toByte()
inline fun Long.extractByte6() = shr(40).toByte()
inline fun Long.extractByte7() = shr(48).toByte()
inline fun Long.extractByte8() = shr(56).toByte()

inline fun Long.extractByte1AsLong() = and(LONG_BYTE_MASK)
inline fun Long.extractByte2AsLong() = shr(Byte.SIZE_BITS).extractByte1AsLong()
inline fun Long.extractByte3AsLong() = shr(16).extractByte1AsLong()
inline fun Long.extractByte4AsLong() = shr(24).extractByte1AsLong()
inline fun Long.extractByte5AsLong() = shr(32).extractByte1AsLong()
inline fun Long.extractByte6AsLong() = shr(40).extractByte1AsLong()
inline fun Long.extractByte7AsLong() = shr(48).extractByte1AsLong()
inline fun Long.extractByte8AsLong() = shr(56).extractByte1AsLong()

inline fun Long.extractByte1AsInt() = and(LONG_BYTE_MASK).toInt()
inline fun Long.extractByte2AsInt() = shr(Byte.SIZE_BITS).extractByte1AsInt()
inline fun Long.extractByte3AsInt() = shr(16).extractByte1AsInt()
inline fun Long.extractByte4AsInt() = shr(24).extractByte1AsInt()
inline fun Long.extractByte5AsInt() = shr(32).extractByte1AsInt()
inline fun Long.extractByte6AsInt() = shr(40).extractByte1AsInt()
inline fun Long.extractByte7AsInt() = shr(48).extractByte1AsInt()
inline fun Long.extractByte8AsInt() = shr(56).extractByte1AsInt()

inline fun packIntWithShorts(x: Short, y: Short) = x.toInt().and(INT_SHORT_MASK)
    .or(y.toInt().and(INT_SHORT_MASK).shl(Short.SIZE_BITS))

inline fun packIntWithShorts(x: Int, y: Int) = x.and(INT_SHORT_MASK)
    .or(y.and(INT_SHORT_MASK).shl(Short.SIZE_BITS))

inline fun packIntWithBytes(x: Byte, y: Byte, z: Byte, w: Byte) = x.toInt()
    .or(y.toInt().shl(Byte.SIZE_BITS))
    .or(z.toInt().shl(16))
    .or(w.toInt().shl(24))

inline fun packIntWithBytesBE(x: Byte, y: Byte, z: Byte, w: Byte) = w.toInt()
    .or(z.toInt().shl(Byte.SIZE_BITS))
    .or(y.toInt().shl(16))
    .or(x.toInt().shl(24))

inline fun packIntWithBytes(x: Int, y: Int, z: Int, w: Int) = x.and(INT_BYTE_MASK)
    .or(y.and(INT_BYTE_MASK).shl(Byte.SIZE_BITS))
    .or(z.and(INT_BYTE_MASK).shl(16))
    .or(w.and(INT_BYTE_MASK).shl(24))

inline fun Int.extractByte1() = toByte()
inline fun Int.extractByte2() = shr(Byte.SIZE_BITS).extractByte1()
inline fun Int.extractByte3() = shr(16).extractByte1()
inline fun Int.extractByte4() = shr(24).extractByte1()

inline fun Int.extractByte1AsInt() = and(INT_BYTE_MASK)
inline fun Int.extractByte2AsInt() = shr(Byte.SIZE_BITS).extractByte1AsInt()
inline fun Int.extractByte3AsInt() = shr(16).extractByte1AsInt()
inline fun Int.extractByte4AsInt() = shr(24).extractByte1AsInt()

inline fun Int.extractShort1() = toShort()
inline fun Int.extractShort2() = shr(Short.SIZE_BITS).toShort()

inline fun Int.extractShort1AsInt() = and(INT_SHORT_MASK)
inline fun Int.extractShort2AsInt() = shr(Short.SIZE_BITS).extractShort1AsInt()


//public static int pack(int c1, int c2, int c3, int c4)
//{
//    return (c1 << 24) | (c2 << 16) | (c3 << 8) | (c4);
//}

inline fun packShortWithBytes(x: Byte, y: Byte) = x.toInt()
    .or(y.toInt().and(INT_BYTE_MASK).shl(Byte.SIZE_BITS))
    .toShort()
inline fun packShortWithBytesBE(x: Byte, y: Byte) = y.toInt()
    .or(x.toInt().and(INT_BYTE_MASK).shl(Byte.SIZE_BITS))
    .toShort()


inline fun packShortWithBytes(x: Int, y: Int) = x.and(INT_BYTE_MASK)
    .or(y.and(INT_BYTE_MASK).shl(Byte.SIZE_BITS))
    .toShort()

inline fun Short.extractByte1() = toByte()
inline fun Short.extractByte2() = toInt().shr(Byte.SIZE_BITS).toByte()

inline fun Short.extractByte1AsInt() = toInt().and(INT_BYTE_MASK)
inline fun Short.extractByte2AsInt() = toInt().shr(Byte.SIZE_BITS).extractByte1AsInt()

inline fun packLongWithFloats(x: Float, y: Float) = (x.toRawBits().toLong())
    .or(y.toRawBits().toLong().and(LONG_INT_MASK).shl(Int.SIZE_BITS))

//inline fun floatFromIntBits(intBits: Int) = java.lang.Float.intBitsToFloat(intBits)
//
//inline fun Long.extractFloat1() = floatFromIntBits(shr(Float.SIZE_BITS).toInt())
//inline fun Long.extractAbsFloat1() = floatFromIntBits((shr(Float.SIZE_BITS).and(0x7FFFFFFF)).toInt())
//inline fun Long.extractFloat2() = floatFromIntBits(and(LONG_INT_MASK).toInt())
//inline fun Long.extractAbsFloat2() = floatFromIntBits(and(0x7FFFFFFF).toInt())

inline fun Short.reverseByteOrder(): Short = (((toInt() and 0xff) shl Byte.SIZE_BITS)
    .or(toInt() ushr Byte.SIZE_BITS)).toShort()

inline fun Int.reverseByteOrder(): Int = (toShort().reverseByteOrder().toInt() shl Short.SIZE_BITS)
    .or(ushr(Short.SIZE_BITS).toShort().reverseByteOrder().toInt() and INT_SHORT_MASK)

inline fun Long.reverseByteOrder(): Long = (toInt().reverseByteOrder().toLong() shl Int.SIZE_BITS)
    .or(ushr(Int.SIZE_BITS).toInt().reverseByteOrder().toLong() and LONG_INT_MASK)


