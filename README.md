# BinaryJson Java Library

BinaryJson is a high-performance Java library for parsing and writing structured JSON-like objects in binary format. It provides a significant boost in loading data compared to traditional text-based JSON objects. By utilizing binary format, BinaryJson achieves better compression in many cases, resulting in improved performance and reduced data size.

## Features

- Efficient parsing and writing of JSON-like objects in binary format.
- Significantly faster loading times compared to traditional text-based JSON parsing.
- Improved compression for reduced data size in many scenarios.
- Simple and intuitive API for working with binary JSON data.
- Support for handling nested objects, arrays, strings, numbers, and more.

## Installation

1. Download required dependency BinaryTools from github.com/aperfilev/binarytools.
2. Build with `./gradlew` command.
3. Publish BinarTools to your local maven repo with `./gradlew publishToMavenLocal` command
4. Build BinaryJson library with `./gradlew` command

You can include BinaryJson in your project using Maven or Gradle. Add the following dependency to your project configuration:

```xml
<dependency>
    <groupId>local.tools</groupId>
    <artifactId>binaryjson</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Reading Binary JSON

```java
import com.example.binaryjson.BinaryJsonReader;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryJsonReaderExample {
    public static void main(String[] args) throws IOException {
        BJSONObject original = new BJSONObject();
        original.put("null", (Object)null);
        original.put("string1", "=123ТЕС=");
        original.put("string2", "1234567890abcABC");
        original.put("string3", "1234567890абвгдАБВГД");
        original.put("minByte", Byte.MIN_VALUE);
        original.put("maxByte", Byte.MAX_VALUE);
        original.put("minShort", Short.MIN_VALUE);
        original.put("maxShort", Short.MAX_VALUE);
        original.put("minInt", Integer.MIN_VALUE);
        original.put("maxInt", Integer.MAX_VALUE);
        original.put("minLong", Long.MIN_VALUE);
        original.put("maxLong", Long.MAX_VALUE);
        original.put("minFloat", Float.MIN_VALUE);
        original.put("maxFloat", Float.MAX_VALUE);
        original.put("floatPInf", Float.POSITIVE_INFINITY);
        original.put("floatNInf", Float.NEGATIVE_INFINITY);
        original.put("floatNaN", Float.NaN);
        original.put("minDouble", Double.MIN_VALUE);
        original.put("maxDouble", Double.MAX_VALUE);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        BJSONWriter writer = new BJSONWriter(output);
        writer.writeBJSONNode(original);
        writer.close();

        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
        BJSONReader reader = new BJSONReader(input);
        BJSONObject duplicate = (BJSONObject) reader.readBJSONNode();
        reader.close();

        assertEquals(original.get("null"), duplicate.get("null"));
        assertEquals(original.getString("string1"), duplicate.getString("string1"));
        assertEquals(original.getString("string2"), duplicate.getString("string2"));
        assertEquals(original.getString("string3"), duplicate.getString("string3"));
        assertEquals(original.getByte("minByte"), duplicate.getByte("minByte"));
        assertEquals(original.getByte("maxByte"), duplicate.getByte("maxByte"));
        assertEquals(original.getShort("minShort"), duplicate.getShort("minShort"));
        assertEquals(original.getShort("maxShort"), duplicate.getShort("maxShort"));
        assertEquals(original.getInt("minInt"), duplicate.getInt("minInt"));
        assertEquals(original.getInt("maxInt"), duplicate.getInt("maxInt"));
        assertEquals(original.getLong("minLong"), duplicate.getLong("minLong"));
        assertEquals(original.getLong("maxLong"), duplicate.getLong("maxLong"));
        assertEquals(original.getFloat("minFloat"), duplicate.getFloat("minFloat"));
        assertEquals(original.getFloat("maxFloat"), duplicate.getFloat("maxFloat"));
        assertEquals(original.getFloat("floatPInf"), duplicate.getFloat("floatPInf"));
        assertEquals(original.getFloat("floatNInf"), duplicate.getFloat("floatNInf"));
        assertEquals(original.getFloat("floatNaN"), duplicate.getFloat("floatNaN"));
        assertEquals(original.getDouble("minDouble"), duplicate.getDouble("minDouble"));
        assertEquals(original.getDouble("maxDouble"), duplicate.getDouble("maxDouble"));
    }
}
```

### Writing Binary JSON

```java
import com.example.binaryjson.BinaryJsonWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryJsonWriterExample {
    public static void main(String[] args) throws IOException {
        BJSONObject original = new BJSONObject();
        original.put("minInt8",  Int8.MIN_VALUE);
        original.put("maxInt8",  Int8.MAX_VALUE);
        original.put("minInt16",  Int16.MIN_VALUE);
        original.put("maxInt16",  Int16.MAX_VALUE);
        original.put("minInt32",  Int32.MIN_VALUE);
        original.put("maxInt32",  Int32.MAX_VALUE);
        original.put("minInt64",  Int64.MIN_VALUE);
        original.put("maxInt64",  Int64.MAX_VALUE);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        BJSONWriter writer = new BJSONWriter(output);
        writer.writeBJSONNode(original);
        writer.close();

        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
        BJSONReader reader = new BJSONReader(input);
        BJSONObject duplicate = (BJSONObject) reader.readBJSONNode();
        reader.close();

        assertEquals(original.getByte("minInt8"), duplicate.getByte("minInt8"));
        assertEquals(original.getByte("maxInt8"), duplicate.getByte("maxInt8"));
        assertEquals(original.getShort("minInt16"), duplicate.getShort("minInt16"));
        assertEquals(original.getShort("minInt16"), duplicate.getShort("minInt16"));
        assertEquals(original.getInt("minInt32"), duplicate.getInt("minInt32"));
        assertEquals(original.getInt("minInt32"), duplicate.getInt("minInt32"));
        assertEquals(original.getLong("minInt64"), duplicate.getLong("minInt64"));
        assertEquals(original.getLong("minInt64"), duplicate.getLong("minInt64"));
    }
}
```

## Performance Comparison

BinaryJson offers a significant performance boost compared to traditional text-based JSON parsing. In many cases, loading the same amount of data can achieve a 10x-20x speedup, resulting in improved application responsiveness.

## License

This library is released under the [MIT License](LICENSE).

## Contributions

Contributions are welcome! Feel free to submit issues and pull requests on the [GitHub repository](https://github.com/aperfilev/binaryjson).

## Contact

For questions, suggestions, or feedback, you can reach us at alexperfilev@gmail.com