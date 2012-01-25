package org.jboss.errai.marshalling.server.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.jboss.errai.marshalling.client.api.Marshaller;
import org.jboss.errai.marshalling.client.api.MarshallerFactory;
import org.jboss.errai.marshalling.client.api.MarshallingSession;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.BigDecimalMarshaller;
import org.jboss.errai.marshalling.client.marshallers.BigIntegerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.BooleanMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ByteMarshaller;
import org.jboss.errai.marshalling.client.marshallers.CharacterMarshaller;
import org.jboss.errai.marshalling.client.marshallers.DateMarshaller;
import org.jboss.errai.marshalling.client.marshallers.DoubleMarshaller;
import org.jboss.errai.marshalling.client.marshallers.FloatMarshaller;
import org.jboss.errai.marshalling.client.marshallers.IntegerMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LinkedListMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ListMarshaller;
import org.jboss.errai.marshalling.client.marshallers.LongMarshaller;
import org.jboss.errai.marshalling.client.marshallers.MapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.PriorityQueueMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.jboss.errai.marshalling.client.marshallers.QueueMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SQLDateMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.ShortMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SortedMapMarshaller;
import org.jboss.errai.marshalling.client.marshallers.SortedSetMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringBufferMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringBuilderMarshaller;
import org.jboss.errai.marshalling.client.marshallers.StringMarshaller;
import org.jboss.errai.marshalling.client.marshallers.TimeMarshaller;
import org.jboss.errai.marshalling.client.marshallers.TimestampMarshaller;

public class ServerMarshallingFactoryImpl implements MarshallerFactory {
  private Map<String, Marshaller> marshallers = new HashMap<String, Marshaller>();
  private SQLDateMarshaller java_sql_Date;
  private ListMarshaller java_util_AbstractList;
  private ByteMarshaller java_lang_Byte;
  private SetMarshaller java_util_LinkedHashSet;
  private ListMarshaller java_util_ArrayList;
  private StringBuilderMarshaller java_lang_StringBuilder;
  private ListMarshaller java_util_Stack;
  private ListMarshaller java_util_Vector;
  private BigDecimalMarshaller java_math_BigDecimal;
  private SortedSetMarshaller java_util_SortedSet;
  private QualifyingMarshallerWrapper<TreeMap> java_util_TreeMap;
  private SetMarshaller java_util_Set;
  private ShortMarshaller java_lang_Short;
  private SortedSetMarshaller java_util_TreeSet;
  private QualifyingMarshallerWrapper<HashMap> java_util_HashMap;
  private QueueMarshaller java_util_Queue;
  private DoubleMarshaller java_lang_Double;
  private QueueMarshaller java_util_AbstractQueue;
  private QualifyingMarshallerWrapper<AbstractMap> java_util_AbstractMap;
  private StringMarshaller java_lang_String;
  private IntegerMarshaller java_lang_Integer;
  private LongMarshaller java_lang_Long;
  private BigIntegerMarshaller java_math_BigInteger;
  private ObjectMarshaller java_lang_Object;
  private PriorityQueueMarshaller java_util_PriorityQueue;
  private SetMarshaller java_util_HashSet;
  private FloatMarshaller java_lang_Float;
  private LinkedListMarshaller java_util_LinkedList;
  private CharacterMarshaller java_lang_Character;
  private BooleanMarshaller java_lang_Boolean;
  private StringBufferMarshaller java_lang_StringBuffer;
  private SetMarshaller java_util_AbstractSet;
  private DateMarshaller java_util_Date;
  private QualifyingMarshallerWrapper<SortedMap> java_util_SortedMap;
  private TimeMarshaller java_sql_Time;
  private QualifyingMarshallerWrapper<Map> java_util_Map;
  private QualifyingMarshallerWrapper<LinkedHashMap> java_util_LinkedHashMap;
  private TimestampMarshaller java_sql_Timestamp;
  private ListMarshaller java_util_List;
  private QualifyingMarshallerWrapper<StackTraceElement[]> arrayOf_java_lang_StackTraceElement_D1;
  private Marshaller<RuntimeException> java_lang_RuntimeException;
  private Marshaller<ArithmeticException> java_lang_ArithmeticException;
  private Marshaller<ConcurrentModificationException> java_util_ConcurrentModificationException;
  private QualifyingMarshallerWrapper<char[]> arrayOf_char_D1;
  private QualifyingMarshallerWrapper<char[][]> arrayOf_char_D2;

  private Marshaller<NullPointerException> java_lang_NullPointerException;
  private Marshaller<EmptyStackException> java_util_EmptyStackException;
  private Marshaller<ArrayStoreException> java_lang_ArrayStoreException;
  private Marshaller<StackTraceElement> java_lang_StackTraceElement;
  private Marshaller<StringIndexOutOfBoundsException> java_lang_StringIndexOutOfBoundsException;
  private Marshaller<IOException> java_io_IOException;
  private Marshaller<Throwable> java_lang_Throwable;
  private Marshaller<UnsupportedOperationException> java_lang_UnsupportedOperationException;
  private Marshaller<IllegalArgumentException> java_lang_IllegalArgumentException;
  private Marshaller<ClassCastException> java_lang_ClassCastException;
  private Marshaller<AssertionError> java_lang_AssertionError;
  private Marshaller<IndexOutOfBoundsException> java_lang_IndexOutOfBoundsException;
  private Marshaller<NegativeArraySizeException> java_lang_NegativeArraySizeException;
  private QualifyingMarshallerWrapper<Object[]> arrayOf_java_lang_Object_D1;
  private QualifyingMarshallerWrapper<String[]> arrayOf_java_lang_String_D1;
  private QualifyingMarshallerWrapper<int[]> arrayOf_int_D1;
  private QualifyingMarshallerWrapper<long[]> arrayOf_long_D1;
  private QualifyingMarshallerWrapper<double[]> arrayOf_double_D1;
  private QualifyingMarshallerWrapper<float[]> arrayOf_float_D1;
  private QualifyingMarshallerWrapper<short[]> arrayOf_short_D1;
  private QualifyingMarshallerWrapper<boolean[]> arrayOf_boolean_D1;
  private QualifyingMarshallerWrapper<byte[]> arrayOf_byte_D1;
  private QualifyingMarshallerWrapper<Integer[]> arrayOf_java_lang_Integer_D1;
  private QualifyingMarshallerWrapper<Long[]> arrayOf_java_lang_Long_D1;
  private QualifyingMarshallerWrapper<Double[]> arrayOf_java_lang_Double_D1;
  private QualifyingMarshallerWrapper<Float[]> arrayOf_java_lang_Float_D1;
  private QualifyingMarshallerWrapper<Short[]> arrayOf_java_lang_Short_D1;
  private QualifyingMarshallerWrapper<Boolean[]> arrayOf_java_lang_Boolean_D1;
  private QualifyingMarshallerWrapper<Byte[]> arrayOf_java_lang_Byte_D1;
  public ServerMarshallingFactoryImpl() {
    java_sql_Date = new SQLDateMarshaller();
    marshallers.put("java.sql.Date", java_sql_Date);
    java_util_AbstractList = new ListMarshaller();
    marshallers.put("java.util.AbstractList", java_util_AbstractList);
    java_lang_Byte = new ByteMarshaller();
    marshallers.put("java.lang.Byte", java_lang_Byte);
    java_util_LinkedHashSet = new SetMarshaller();
    marshallers.put("java.util.LinkedHashSet", java_util_LinkedHashSet);
    java_util_ArrayList = new ListMarshaller();
    marshallers.put("java.util.ArrayList", java_util_ArrayList);
    java_lang_StringBuilder = new StringBuilderMarshaller();
    marshallers.put("java.lang.StringBuilder", java_lang_StringBuilder);
    java_util_Stack = new ListMarshaller();
    marshallers.put("java.util.Stack", java_util_Stack);
    java_util_Vector = new ListMarshaller();
    marshallers.put("java.util.Vector", java_util_Vector);
    java_math_BigDecimal = new BigDecimalMarshaller();
    marshallers.put("java.math.BigDecimal", java_math_BigDecimal);
    java_util_SortedSet = new SortedSetMarshaller();
    marshallers.put("java.util.SortedSet", java_util_SortedSet);
    marshallers.put("java.util.Collections$UnmodifiableSortedSet", java_util_SortedSet);
    marshallers.put("java.util.TreeSet", java_util_SortedSet);
    marshallers.put("java.util.Collections$SynchronizedSortedSet", java_util_SortedSet);
    java_util_TreeMap = new QualifyingMarshallerWrapper(new SortedMapMarshaller());
    marshallers.put("java.util.TreeMap", java_util_TreeMap);
    java_util_Set = new SetMarshaller();
    marshallers.put("java.util.Set", java_util_Set);
    marshallers.put("java.util.Collections$SynchronizedSet", java_util_Set);
    marshallers.put("java.util.Collections$UnmodifiableSet", java_util_Set);
    marshallers.put("java.util.Collections$EmptySet", java_util_Set);
    marshallers.put("java.util.SortedSet", java_util_Set);
    marshallers.put("java.util.Collections$SingletonSet", java_util_Set);
    marshallers.put("java.util.AbstractSet", java_util_Set);
    marshallers.put("java.util.HashSet", java_util_Set);
    marshallers.put("java.util.LinkedHashSet", java_util_Set);
    java_lang_Short = new ShortMarshaller();
    marshallers.put("java.lang.Short", java_lang_Short);
    java_util_TreeSet = new SortedSetMarshaller();
    marshallers.put("java.util.TreeSet", java_util_TreeSet);
    java_util_HashMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.HashMap", java_util_HashMap);
    java_util_Queue = new QueueMarshaller();
    marshallers.put("java.util.Queue", java_util_Queue);
    marshallers.put("java.util.AbstractQueue", java_util_Queue);
    java_lang_Double = new DoubleMarshaller();
    marshallers.put("java.lang.Double", java_lang_Double);
    java_util_AbstractQueue = new QueueMarshaller();
    marshallers.put("java.util.AbstractQueue", java_util_AbstractQueue);
    java_util_AbstractMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.AbstractMap", java_util_AbstractMap);
    java_lang_String = new StringMarshaller();
    marshallers.put("java.lang.String", java_lang_String);
    java_lang_Integer = new IntegerMarshaller();
    marshallers.put("java.lang.Integer", java_lang_Integer);
    java_lang_Long = new LongMarshaller();
    marshallers.put("java.lang.Long", java_lang_Long);
    java_math_BigInteger = new BigIntegerMarshaller();
    marshallers.put("java.math.BigInteger", java_math_BigInteger);
    java_lang_Object = new ObjectMarshaller();
    marshallers.put("java.lang.Object", java_lang_Object);
    java_util_PriorityQueue = new PriorityQueueMarshaller();
    marshallers.put("java.util.PriorityQueue", java_util_PriorityQueue);
    java_util_HashSet = new SetMarshaller();
    marshallers.put("java.util.HashSet", java_util_HashSet);
    java_lang_Float = new FloatMarshaller();
    marshallers.put("java.lang.Float", java_lang_Float);
    java_util_LinkedList = new LinkedListMarshaller();
    marshallers.put("java.util.LinkedList", java_util_LinkedList);
    java_lang_Character = new CharacterMarshaller();
    marshallers.put("java.lang.Character", java_lang_Character);
    java_lang_Boolean = new BooleanMarshaller();
    marshallers.put("java.lang.Boolean", java_lang_Boolean);
    java_lang_StringBuffer = new StringBufferMarshaller();
    marshallers.put("java.lang.StringBuffer", java_lang_StringBuffer);
    java_util_AbstractSet = new SetMarshaller();
    marshallers.put("java.util.AbstractSet", java_util_AbstractSet);
    java_util_Date = new DateMarshaller();
    marshallers.put("java.util.Date", java_util_Date);
    java_util_SortedMap = new QualifyingMarshallerWrapper(new SortedMapMarshaller());
    marshallers.put("java.util.SortedMap", java_util_SortedMap);
    marshallers.put("java.util.Collections$SynchronizedSortedMap", java_util_SortedMap);
    marshallers.put("java.util.Collections$UnmodifiableSortedMap", java_util_SortedMap);
    marshallers.put("java.util.TreeMap", java_util_SortedMap);
    java_sql_Time = new TimeMarshaller();
    marshallers.put("java.sql.Time", java_sql_Time);
    java_util_Map = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.Map", java_util_Map);
    marshallers.put("java.util.Collections$SingletonMap", java_util_Map);
    marshallers.put("java.util.AbstractMap", java_util_Map);
    marshallers.put("java.util.Collections$SynchronizedMap", java_util_Map);
    marshallers.put("java.util.HashMap", java_util_Map);
    marshallers.put("java.util.Collections$UnmodifiableMap", java_util_Map);
    marshallers.put("java.util.Collections$EmptyMap", java_util_Map);
    marshallers.put("java.util.LinkedHashMap", java_util_Map);
    java_util_LinkedHashMap = new QualifyingMarshallerWrapper(new MapMarshaller());
    marshallers.put("java.util.LinkedHashMap", java_util_LinkedHashMap);
    java_sql_Timestamp = new TimestampMarshaller();
    marshallers.put("java.sql.Timestamp", java_sql_Timestamp);
    java_util_List = new ListMarshaller();
    marshallers.put("java.util.List", java_util_List);
    marshallers.put("java.util.Collections$SynchronizedRandomAccessList", java_util_List);
    marshallers.put("java.util.Collections$UnmodifiableRandomAccessList", java_util_List);
    marshallers.put("java.util.Stack", java_util_List);
    marshallers.put("java.util.Vector", java_util_List);
    marshallers.put("java.util.ArrayList", java_util_List);
    marshallers.put("java.util.Collections$SingletonList", java_util_List);
    marshallers.put("java.util.Collections$SynchronizedList", java_util_List);
    marshallers.put("java.util.Collections$UnmodifiableList", java_util_List);
    marshallers.put("java.util.Collections$EmptyList", java_util_List);
    marshallers.put("java.util.Arrays$ArrayList", java_util_List);
    marshallers.put("java.util.AbstractList", java_util_List);
    marshallers.put("[Ljava.lang.StackTraceElement;", arrayOf_java_lang_StackTraceElement_D1);
    java_lang_RuntimeException = new Marshaller<RuntimeException>() {
      public Class getTypeHandled() {
        return RuntimeException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public RuntimeException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(RuntimeException.class, objId);
          }
          RuntimeException entity = new RuntimeException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.RuntimeException", t);
        }
      }

      public String marshall(RuntimeException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.RuntimeException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.RuntimeException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.RuntimeException", java_lang_RuntimeException);
    java_lang_ArithmeticException = new Marshaller<ArithmeticException>() {
      public Class getTypeHandled() {
        return ArithmeticException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public ArithmeticException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(ArithmeticException.class, objId);
          }
          ArithmeticException entity = new ArithmeticException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ArithmeticException", t);
        }
      }

      public String marshall(ArithmeticException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ArithmeticException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ArithmeticException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.ArithmeticException", java_lang_ArithmeticException);
    java_util_ConcurrentModificationException = new Marshaller<ConcurrentModificationException>() {
      public Class getTypeHandled() {
        return ConcurrentModificationException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public ConcurrentModificationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(ConcurrentModificationException.class, objId);
          }
          ConcurrentModificationException entity = new ConcurrentModificationException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.util.ConcurrentModificationException", t);
        }
      }

      public String marshall(ConcurrentModificationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.util.ConcurrentModificationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.util.ConcurrentModificationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.util.ConcurrentModificationException", java_util_ConcurrentModificationException);
    arrayOf_char_D1 = new QualifyingMarshallerWrapper(new Marshaller<char[]>() {
      public Class getTypeHandled() {
        return char.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public char[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(char[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private char[] _demarshall1(EJArray a0, MarshallingSession a1) {
        char[] newArray = new char[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Character.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(char[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Character.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[C", arrayOf_char_D1);
    arrayOf_char_D2 = new QualifyingMarshallerWrapper(new Marshaller<char[][]>() {
      public Class getTypeHandled() {
        return char.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public char[][] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall2(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(char[][] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall2(a0, a1);
        }
      }

      private char[][] _demarshall2(EJArray a0, MarshallingSession a1) {
        char[][] newArray = new char[a0.size()][];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = _demarshall1(a0.get(i).isArray(), a1);
        }
        return newArray;
      }

      private String _marshall2(char[][] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(_marshall1(a0[i], a1));
        }
        return sb.append("]").toString();
      }

      private char[] _demarshall1(EJArray a0, MarshallingSession a1) {
        char[] newArray = new char[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Character.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(char[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Character.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[[C", arrayOf_char_D2);

    java_lang_NullPointerException = new Marshaller<NullPointerException>() {
      public Class getTypeHandled() {
        return NullPointerException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public NullPointerException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(NullPointerException.class, objId);
          }
          NullPointerException entity = new NullPointerException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.NullPointerException", t);
        }
      }

      public String marshall(NullPointerException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.NullPointerException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.NullPointerException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.NullPointerException", java_lang_NullPointerException);
    java_util_EmptyStackException = new Marshaller<EmptyStackException>() {
      public Class getTypeHandled() {
        return EmptyStackException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public EmptyStackException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(EmptyStackException.class, objId);
          }
          EmptyStackException entity = new EmptyStackException();
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.util.EmptyStackException", t);
        }
      }

      public String marshall(EmptyStackException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.util.EmptyStackException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.util.EmptyStackException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.util.EmptyStackException", java_util_EmptyStackException);
    java_lang_ArrayStoreException = new Marshaller<ArrayStoreException>() {
      public Class getTypeHandled() {
        return ArrayStoreException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public ArrayStoreException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(ArrayStoreException.class, objId);
          }
          ArrayStoreException entity = new ArrayStoreException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ArrayStoreException", t);
        }
      }

      public String marshall(ArrayStoreException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ArrayStoreException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ArrayStoreException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.ArrayStoreException", java_lang_ArrayStoreException);
    java_lang_StackTraceElement = new Marshaller<StackTraceElement>() {
      public Class getTypeHandled() {
        return StackTraceElement.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public StackTraceElement demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(StackTraceElement.class, objId);
          }
          StackTraceElement entity = new StackTraceElement(java_lang_String.demarshall(obj.get("declaringClass"), a1), java_lang_String.demarshall(obj.get("methodName"), a1), java_lang_String.demarshall(obj.get("fileName"), a1), java_lang_Integer.demarshall(obj.get("lineNumber"), a1));
          a1.recordObjectHash(objId, entity);
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.StackTraceElement", t);
        }
      }

      public String marshall(StackTraceElement a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.StackTraceElement\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(640).append("{\"^EncodedType\":\"java.lang.StackTraceElement\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"fileName\" : ").append(java_lang_String.marshall(a0.getFileName(), a1)).append(",").append("\"methodName\" : ").append(java_lang_String.marshall(a0.getMethodName(), a1)).append(",").append("\"lineNumber\" : ").append(java_lang_Integer.marshall(a0.getLineNumber(), a1)).append(",").append("\"declaringClass\" : ").append(java_lang_String.marshall(a0.getClassName(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.StackTraceElement", java_lang_StackTraceElement);
    java_lang_StringIndexOutOfBoundsException = new Marshaller<StringIndexOutOfBoundsException>() {
      public Class getTypeHandled() {
        return StringIndexOutOfBoundsException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public StringIndexOutOfBoundsException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(StringIndexOutOfBoundsException.class, objId);
          }
          StringIndexOutOfBoundsException entity = new StringIndexOutOfBoundsException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.StringIndexOutOfBoundsException", t);
        }
      }

      public String marshall(StringIndexOutOfBoundsException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.StringIndexOutOfBoundsException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.StringIndexOutOfBoundsException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.StringIndexOutOfBoundsException", java_lang_StringIndexOutOfBoundsException);
    java_io_IOException = new Marshaller<IOException>() {
      public Class getTypeHandled() {
        return IOException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public IOException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(IOException.class, objId);
          }
          IOException entity = new IOException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.io.IOException", t);
        }
      }

      public String marshall(IOException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.io.IOException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.io.IOException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.io.IOException", java_io_IOException);
    java_lang_Throwable = new Marshaller<Throwable>() {
      public Class getTypeHandled() {
        return Throwable.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Throwable demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(Throwable.class, objId);
          }
          Throwable entity = new Throwable(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.Throwable", t);
        }
      }

      public String marshall(Throwable a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.Throwable\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3072).append("{\"^EncodedType\":\"java.lang.Throwable\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.Throwable", java_lang_Throwable);
    java_lang_UnsupportedOperationException = new Marshaller<UnsupportedOperationException>() {
      public Class getTypeHandled() {
        return UnsupportedOperationException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public UnsupportedOperationException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(UnsupportedOperationException.class, objId);
          }
          UnsupportedOperationException entity = new UnsupportedOperationException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.UnsupportedOperationException", t);
        }
      }

      public String marshall(UnsupportedOperationException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.UnsupportedOperationException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.UnsupportedOperationException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.UnsupportedOperationException", java_lang_UnsupportedOperationException);
    java_lang_IllegalArgumentException = new Marshaller<IllegalArgumentException>() {
      public Class getTypeHandled() {
        return IllegalArgumentException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public IllegalArgumentException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(IllegalArgumentException.class, objId);
          }
          IllegalArgumentException entity = new IllegalArgumentException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.IllegalArgumentException", t);
        }
      }

      public String marshall(IllegalArgumentException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.IllegalArgumentException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.IllegalArgumentException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.IllegalArgumentException", java_lang_IllegalArgumentException);

    java_lang_ClassCastException = new Marshaller<ClassCastException>() {
      public Class getTypeHandled() {
        return ClassCastException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public ClassCastException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(ClassCastException.class, objId);
          }
          ClassCastException entity = new ClassCastException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.ClassCastException", t);
        }
      }

      public String marshall(ClassCastException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.ClassCastException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.ClassCastException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.ClassCastException", java_lang_ClassCastException);
    java_lang_AssertionError = new Marshaller<AssertionError>() {
      public Class getTypeHandled() {
        return AssertionError.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public AssertionError demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(AssertionError.class, objId);
          }
          AssertionError entity = new AssertionError(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.AssertionError", t);
        }
      }

      public String marshall(AssertionError a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.AssertionError\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.AssertionError\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.AssertionError", java_lang_AssertionError);
    java_lang_IndexOutOfBoundsException = new Marshaller<IndexOutOfBoundsException>() {
      public Class getTypeHandled() {
        return IndexOutOfBoundsException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public IndexOutOfBoundsException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(IndexOutOfBoundsException.class, objId);
          }
          IndexOutOfBoundsException entity = new IndexOutOfBoundsException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.IndexOutOfBoundsException", t);
        }
      }

      public String marshall(IndexOutOfBoundsException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.IndexOutOfBoundsException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.IndexOutOfBoundsException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.IndexOutOfBoundsException", java_lang_IndexOutOfBoundsException);
    java_lang_NegativeArraySizeException = new Marshaller<NegativeArraySizeException>() {
      public Class getTypeHandled() {
        return NegativeArraySizeException.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public NegativeArraySizeException demarshall(EJValue a0, MarshallingSession a1) {
        try {
          if (a0.isNull() != null) {
            return null;
          }
          EJObject obj = a0.isObject();
          String objId = obj.get("^ObjectID").isString().stringValue();
          if (a1.hasObjectHash(objId)) {
            return a1.getObject(NegativeArraySizeException.class, objId);
          }
          NegativeArraySizeException entity = new NegativeArraySizeException(java_lang_String.demarshall(obj.get("message"), a1));
          a1.recordObjectHash(objId, entity);
          if ((obj.containsKey("stackTrace")) && (obj.get("stackTrace").isNull() == null)) {
            entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
          }
          if ((obj.containsKey("cause")) && (obj.get("cause").isNull() == null)) {
            entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
          }
          return entity;
        } catch (Throwable t) {
          t.printStackTrace();
          throw new RuntimeException("error demarshalling entity: java.lang.NegativeArraySizeException", t);
        }
      }

      public String marshall(NegativeArraySizeException a0, MarshallingSession a1) {
        if (a0 == null) {
          return "null";
        }
        if (a1.hasObjectHash(a0)) {
          String objId = a1.getObjectHash(a0);
          return new StringBuilder(128).append("{\"^EncodedType\":\"java.lang.NegativeArraySizeException\"").append(",").append("\"^ObjectID\":\"").append(objId).append("\"}").toString();
        }
        String objId = a1.getObjectHash(a0);
        a1.recordObjectHash(objId, objId);
        return new StringBuilder(3968).append("{\"^EncodedType\":\"java.lang.NegativeArraySizeException\",\"^ObjectID\":\"").append(objId).append("\"").append(",").append("\"stackTrace\" : ").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\" : ").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\" : ").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
      }

      public boolean handles(EJValue a0) {
        return (a0.isObject() != null) && a0.isObject().get("^EncodedType").isString().stringValue().equals(this.getTypeHandled().getName());
      }


    };
    marshallers.put("java.lang.NegativeArraySizeException", java_lang_NegativeArraySizeException);

    arrayOf_java_lang_Object_D1 = new QualifyingMarshallerWrapper(new Marshaller<Object[]>() {
      public Class getTypeHandled() {
        return Object.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Object[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Object[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Object[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Object[] newArray = new Object[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Object.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Object[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Object.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Object;", arrayOf_java_lang_Object_D1);
    arrayOf_java_lang_String_D1 = new QualifyingMarshallerWrapper(new Marshaller<String[]>() {
      public Class getTypeHandled() {
        return String.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public String[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(String[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private String[] _demarshall1(EJArray a0, MarshallingSession a1) {
        String[] newArray = new String[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_String.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(String[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_String.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.String;", arrayOf_java_lang_String_D1);
    arrayOf_int_D1 = new QualifyingMarshallerWrapper(new Marshaller<int[]>() {
      public Class getTypeHandled() {
        return int.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public int[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(int[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private int[] _demarshall1(EJArray a0, MarshallingSession a1) {
        int[] newArray = new int[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Integer.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(int[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Integer.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[I", arrayOf_int_D1);
    arrayOf_long_D1 = new QualifyingMarshallerWrapper(new Marshaller<long[]>() {
      public Class getTypeHandled() {
        return long.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public long[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(long[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private long[] _demarshall1(EJArray a0, MarshallingSession a1) {
        long[] newArray = new long[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Long.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(long[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Long.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[J", arrayOf_long_D1);
    arrayOf_double_D1 = new QualifyingMarshallerWrapper(new Marshaller<double[]>() {
      public Class getTypeHandled() {
        return double.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public double[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(double[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private double[] _demarshall1(EJArray a0, MarshallingSession a1) {
        double[] newArray = new double[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Double.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(double[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Double.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[D", arrayOf_double_D1);
    arrayOf_float_D1 = new QualifyingMarshallerWrapper(new Marshaller<float[]>() {
      public Class getTypeHandled() {
        return float.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public float[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(float[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private float[] _demarshall1(EJArray a0, MarshallingSession a1) {
        float[] newArray = new float[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Float.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(float[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Float.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[F", arrayOf_float_D1);
    arrayOf_short_D1 = new QualifyingMarshallerWrapper(new Marshaller<short[]>() {
      public Class getTypeHandled() {
        return short.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public short[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(short[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private short[] _demarshall1(EJArray a0, MarshallingSession a1) {
        short[] newArray = new short[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Short.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(short[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Short.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[S", arrayOf_short_D1);
    arrayOf_boolean_D1 = new QualifyingMarshallerWrapper(new Marshaller<boolean[]>() {
      public Class getTypeHandled() {
        return boolean.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public boolean[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(boolean[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private boolean[] _demarshall1(EJArray a0, MarshallingSession a1) {
        boolean[] newArray = new boolean[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Boolean.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(boolean[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Boolean.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Z", arrayOf_boolean_D1);
    arrayOf_byte_D1 = new QualifyingMarshallerWrapper(new Marshaller<byte[]>() {
      public Class getTypeHandled() {
        return byte.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public byte[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(byte[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private byte[] _demarshall1(EJArray a0, MarshallingSession a1) {
        byte[] newArray = new byte[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Byte.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(byte[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Byte.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[B", arrayOf_byte_D1);
    arrayOf_java_lang_Integer_D1 = new QualifyingMarshallerWrapper(new Marshaller<Integer[]>() {
      public Class getTypeHandled() {
        return Integer.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Integer[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Integer[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Integer[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Integer[] newArray = new Integer[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Integer.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Integer[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Integer.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Integer;", arrayOf_java_lang_Integer_D1);
    arrayOf_java_lang_Long_D1 = new QualifyingMarshallerWrapper(new Marshaller<Long[]>() {
      public Class getTypeHandled() {
        return Long.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Long[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Long[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Long[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Long[] newArray = new Long[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Long.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Long[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Long.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Long;", arrayOf_java_lang_Long_D1);
    arrayOf_java_lang_Double_D1 = new QualifyingMarshallerWrapper(new Marshaller<Double[]>() {
      public Class getTypeHandled() {
        return Double.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Double[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Double[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Double[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Double[] newArray = new Double[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Double.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Double[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Double.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Double;", arrayOf_java_lang_Double_D1);
    arrayOf_java_lang_Float_D1 = new QualifyingMarshallerWrapper(new Marshaller<Float[]>() {
      public Class getTypeHandled() {
        return Float.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Float[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Float[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Float[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Float[] newArray = new Float[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Float.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Float[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Float.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Float;", arrayOf_java_lang_Float_D1);
    arrayOf_java_lang_Short_D1 = new QualifyingMarshallerWrapper(new Marshaller<Short[]>() {
      public Class getTypeHandled() {
        return Short.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Short[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Short[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Short[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Short[] newArray = new Short[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Short.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Short[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Short.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Short;", arrayOf_java_lang_Short_D1);
    arrayOf_java_lang_Boolean_D1 = new QualifyingMarshallerWrapper(new Marshaller<Boolean[]>() {
      public Class getTypeHandled() {
        return Boolean.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Boolean[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Boolean[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Boolean[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Boolean[] newArray = new Boolean[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Boolean.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Boolean[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Boolean.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Boolean;", arrayOf_java_lang_Boolean_D1);
    arrayOf_java_lang_Byte_D1 = new QualifyingMarshallerWrapper(new Marshaller<Byte[]>() {
      public Class getTypeHandled() {
        return Byte.class;
      }

      public String getEncodingType() {
        return "json";
      }

      public Byte[] demarshall(EJValue a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          EJArray arr = a0.isArray();
          return _demarshall1(arr, a1);
        }
      }

      public boolean handles(EJValue a0) {
        return true;
      }

      public String marshall(Byte[] a0, MarshallingSession a1) {
        if (a0 == null) {
          return null;
        } else {
          return _marshall1(a0, a1);
        }
      }

      private Byte[] _demarshall1(EJArray a0, MarshallingSession a1) {
        Byte[] newArray = new Byte[a0.size()];
        for (int i = 0; i < newArray.length; i++) {
          newArray[i] = java_lang_Byte.demarshall(a0.get(i), a1);
        }
        return newArray;
      }

      private String _marshall1(Byte[] a0, MarshallingSession a1) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a0.length; i++) {
          if (i > 0) {
            sb.append(",");
          }
          sb.append(java_lang_Byte.marshall(a0[i], a1));
        }
        return sb.append("]").toString();
      }

    });
    marshallers.put("[Ljava.lang.Byte;", arrayOf_java_lang_Byte_D1);
  }

  private static Field _getAccessibleField(Class cls, String name) {
    try {
      Field fld = cls.getDeclaredField(name);
      fld.setAccessible(true);
      return fld;
    } catch (Throwable e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }


  public Marshaller<Object> getMarshaller(String a0, String a1) {
    return marshallers.get(a1);
  }
}