//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.02 at 12:23:52 PM MST 
//


package org.openinfobutton.schemas.kb;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;


/**
 * <p>Java class for PQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="unit" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PQ")
public class PQ {

    @XmlAttribute(name = "value", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String value;
    @XmlAttribute(name = "unit", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String unit;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final PQ.Builder<_B> _other) {
        _other.value = this.value;
        _other.unit = this.unit;
    }

    public<_B >PQ.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
        return new PQ.Builder<_B>(_parentBuilder, this, true);
    }

    public PQ.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
    }

    public static PQ.Builder<Void> builder() {
        return new PQ.Builder<Void>(null, null, false);
    }

    public static<_B >PQ.Builder<_B> copyOf(final PQ _other) {
        final PQ.Builder<_B> _newBuilder = new PQ.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final PQ.Builder<_B> _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree valuePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("value"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(valuePropertyTree!= null):((valuePropertyTree == null)||(!valuePropertyTree.isLeaf())))) {
            _other.value = this.value;
        }
        final PropertyTree unitPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("unit"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(unitPropertyTree!= null):((unitPropertyTree == null)||(!unitPropertyTree.isLeaf())))) {
            _other.unit = this.unit;
        }
    }

    public<_B >PQ.Builder<_B> newCopyBuilder(final _B _parentBuilder, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return new PQ.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public PQ.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static<_B >PQ.Builder<_B> copyOf(final PQ _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PQ.Builder<_B> _newBuilder = new PQ.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
    }

    public static PQ.Builder<Void> copyExcept(final PQ _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static PQ.Builder<Void> copyOnly(final PQ _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    public static class Builder<_B >implements Buildable
    {

        protected final _B _parentBuilder;
        protected final PQ _storedValue;
        private String value;
        private String unit;

        public Builder(final _B _parentBuilder, final PQ _other, final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    this.value = _other.value;
                    this.unit = _other.unit;
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public Builder(final _B _parentBuilder, final PQ _other, final boolean _copy, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    final PropertyTree valuePropertyTree = ((_propertyTree == null)?null:_propertyTree.get("value"));
                    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(valuePropertyTree!= null):((valuePropertyTree == null)||(!valuePropertyTree.isLeaf())))) {
                        this.value = _other.value;
                    }
                    final PropertyTree unitPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("unit"));
                    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(unitPropertyTree!= null):((unitPropertyTree == null)||(!unitPropertyTree.isLeaf())))) {
                        this.unit = _other.unit;
                    }
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public _B end() {
            return this._parentBuilder;
        }

        protected<_P extends PQ >_P init(final _P _product) {
            _product.value = this.value;
            _product.unit = this.unit;
            return _product;
        }

        /**
         * Sets the new value of "value" (any previous value will be replaced)
         * 
         * @param value
         *     New value of the "value" property.
         */
        public PQ.Builder<_B> withValue(final String value) {
            this.value = value;
            return this;
        }

        /**
         * Sets the new value of "unit" (any previous value will be replaced)
         * 
         * @param unit
         *     New value of the "unit" property.
         */
        public PQ.Builder<_B> withUnit(final String unit) {
            this.unit = unit;
            return this;
        }

        @Override
        public PQ build() {
            if (_storedValue == null) {
                return this.init(new PQ());
            } else {
                return ((PQ) _storedValue);
            }
        }

    }

    public static class Select
        extends PQ.Selector<PQ.Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static PQ.Select _root() {
            return new PQ.Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {

        private com.kscs.util.jaxb.Selector<TRoot, PQ.Selector<TRoot, TParent>> value = null;
        private com.kscs.util.jaxb.Selector<TRoot, PQ.Selector<TRoot, TParent>> unit = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.value!= null) {
                products.put("value", this.value.init());
            }
            if (this.unit!= null) {
                products.put("unit", this.unit.init());
            }
            return products;
        }

        public com.kscs.util.jaxb.Selector<TRoot, PQ.Selector<TRoot, TParent>> value() {
            return ((this.value == null)?this.value = new com.kscs.util.jaxb.Selector<TRoot, PQ.Selector<TRoot, TParent>>(this._root, this, "value"):this.value);
        }

        public com.kscs.util.jaxb.Selector<TRoot, PQ.Selector<TRoot, TParent>> unit() {
            return ((this.unit == null)?this.unit = new com.kscs.util.jaxb.Selector<TRoot, PQ.Selector<TRoot, TParent>>(this._root, this, "unit"):this.unit);
        }

    }

}