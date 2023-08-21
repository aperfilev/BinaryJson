/**
 * MIT License
 *
 * Copyright (c) 2023 Alexander Perfilev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package local.tools.json.binary;

/**
 * BJSON Type enumeration represents all supported types and their type ordinal value
 */
public enum BJSONType {
    NULL        ("null", "null",0, 0),
    BJSONObject ("BJSONObject", "BJSONObject", 1, -1),
    BJSONArray  ("BJSONArray", "BJSONArray", 2, -1),
    String      ("String", "String", 3, -1),
    Boolean     ("Boolean", "Boolean", 4, 1),
    Int8        ("Int8", "Byte", 5, 1),
    Int16       ("Int16", "Short", 6, 2),
    Int32       ("Int32", "Int", 7, 4),
    Int64       ("Int64", "Long", 8, 8),//aka Long
    UInt8       ("UInt8", "UByte", 9, 1),
    UInt16      ("UInt16", "UShort", 10, 2),
    UInt32      ("UInt32", "UInt", 11, 4),
    UInt64      ("UInt64", "ULong", 12, 8),
    Float32     ("Float32", "Float", 13, 4),
    Float64     ("Float64", "Double", 14, 8);

    private final String name;
    private final String alias;
    private final byte code;
    private final int size;

    BJSONType(String name, String alias, int value, int size) {
        this.name = name;
        this.alias = alias;
        this.code = (byte) value;
        this.size = size;
    }

    public static BJSONType fromCode(int code) {
        switch ((byte)code) {
            case 0: return NULL;
            case 1: return BJSONObject;
            case 2: return BJSONArray;
            case 3: return String;
            case 4: return Boolean;
            case 5: return Int8;
            case 6: return Int16;
            case 7: return Int32;
            case 8: return Int64;
            case 9: return UInt8;
            case 10: return UInt16;
            case 11: return UInt32;
            case 12: return UInt64;
            case 13: return Float32;
            case 14: return Float64;
            default: return null;
        }
    }

    /**
     * Internal byte code used to encode this type.
     * @return
     */
    public byte getCode() {
        return code;
    }

    /**
     * Size in bytes taken by each instance of this type.
     * @return
     */
    public int getSize() {
        return size;
    }
}
