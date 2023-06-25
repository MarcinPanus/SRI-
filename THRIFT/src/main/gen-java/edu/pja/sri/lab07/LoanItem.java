/**
 * Autogenerated by Thrift Compiler (0.18.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.pja.sri.lab07;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.18.1)", date = "2023-06-20")
public class LoanItem implements org.apache.thrift.TBase<LoanItem, LoanItem._Fields>, java.io.Serializable, Cloneable, Comparable<LoanItem> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoanItem");

  private static final org.apache.thrift.protocol.TField BOOK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("bookId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField READER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("readerId", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new LoanItemStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new LoanItemTupleSchemeFactory();

  public int bookId; // required
  public int readerId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BOOK_ID((short)1, "bookId"),
    READER_ID((short)2, "readerId");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BOOK_ID
          return BOOK_ID;
        case 2: // READER_ID
          return READER_ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BOOKID_ISSET_ID = 0;
  private static final int __READERID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BOOK_ID, new org.apache.thrift.meta_data.FieldMetaData("bookId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.READER_ID, new org.apache.thrift.meta_data.FieldMetaData("readerId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoanItem.class, metaDataMap);
  }

  public LoanItem() {
  }

  public LoanItem(
    int bookId,
    int readerId)
  {
    this();
    this.bookId = bookId;
    setBookIdIsSet(true);
    this.readerId = readerId;
    setReaderIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LoanItem(LoanItem other) {
    __isset_bitfield = other.__isset_bitfield;
    this.bookId = other.bookId;
    this.readerId = other.readerId;
  }

  @Override
  public LoanItem deepCopy() {
    return new LoanItem(this);
  }

  @Override
  public void clear() {
    setBookIdIsSet(false);
    this.bookId = 0;
    setReaderIdIsSet(false);
    this.readerId = 0;
  }

  public int getBookId() {
    return this.bookId;
  }

  public LoanItem setBookId(int bookId) {
    this.bookId = bookId;
    setBookIdIsSet(true);
    return this;
  }

  public void unsetBookId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BOOKID_ISSET_ID);
  }

  /** Returns true if field bookId is set (has been assigned a value) and false otherwise */
  public boolean isSetBookId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BOOKID_ISSET_ID);
  }

  public void setBookIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BOOKID_ISSET_ID, value);
  }

  public int getReaderId() {
    return this.readerId;
  }

  public LoanItem setReaderId(int readerId) {
    this.readerId = readerId;
    setReaderIdIsSet(true);
    return this;
  }

  public void unsetReaderId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __READERID_ISSET_ID);
  }

  /** Returns true if field readerId is set (has been assigned a value) and false otherwise */
  public boolean isSetReaderId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __READERID_ISSET_ID);
  }

  public void setReaderIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __READERID_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case BOOK_ID:
      if (value == null) {
        unsetBookId();
      } else {
        setBookId((java.lang.Integer)value);
      }
      break;

    case READER_ID:
      if (value == null) {
        unsetReaderId();
      } else {
        setReaderId((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BOOK_ID:
      return getBookId();

    case READER_ID:
      return getReaderId();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case BOOK_ID:
      return isSetBookId();
    case READER_ID:
      return isSetReaderId();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof LoanItem)
      return this.equals((LoanItem)that);
    return false;
  }

  public boolean equals(LoanItem that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_bookId = true;
    boolean that_present_bookId = true;
    if (this_present_bookId || that_present_bookId) {
      if (!(this_present_bookId && that_present_bookId))
        return false;
      if (this.bookId != that.bookId)
        return false;
    }

    boolean this_present_readerId = true;
    boolean that_present_readerId = true;
    if (this_present_readerId || that_present_readerId) {
      if (!(this_present_readerId && that_present_readerId))
        return false;
      if (this.readerId != that.readerId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + bookId;

    hashCode = hashCode * 8191 + readerId;

    return hashCode;
  }

  @Override
  public int compareTo(LoanItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetBookId(), other.isSetBookId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBookId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bookId, other.bookId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetReaderId(), other.isSetReaderId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReaderId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.readerId, other.readerId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("LoanItem(");
    boolean first = true;

    sb.append("bookId:");
    sb.append(this.bookId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("readerId:");
    sb.append(this.readerId);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'bookId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'readerId' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LoanItemStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public LoanItemStandardScheme getScheme() {
      return new LoanItemStandardScheme();
    }
  }

  private static class LoanItemStandardScheme extends org.apache.thrift.scheme.StandardScheme<LoanItem> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, LoanItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BOOK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.bookId = iprot.readI32();
              struct.setBookIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // READER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.readerId = iprot.readI32();
              struct.setReaderIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetBookId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'bookId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetReaderId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'readerId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, LoanItem struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(BOOK_ID_FIELD_DESC);
      oprot.writeI32(struct.bookId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(READER_ID_FIELD_DESC);
      oprot.writeI32(struct.readerId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LoanItemTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public LoanItemTupleScheme getScheme() {
      return new LoanItemTupleScheme();
    }
  }

  private static class LoanItemTupleScheme extends org.apache.thrift.scheme.TupleScheme<LoanItem> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LoanItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.bookId);
      oprot.writeI32(struct.readerId);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LoanItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.bookId = iprot.readI32();
      struct.setBookIdIsSet(true);
      struct.readerId = iprot.readI32();
      struct.setReaderIdIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

