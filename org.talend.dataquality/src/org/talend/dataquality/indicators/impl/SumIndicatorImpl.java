/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.dataquality.indicators.impl;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.talend.dataquality.indicators.Datatype;
import org.talend.dataquality.indicators.IndicatorsPackage;
import org.talend.dataquality.indicators.SumIndicator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sum Indicator</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class SumIndicatorImpl extends IndicatorImpl implements SumIndicator {

    /**
     * The default value of the '{@link #getSumStr() <em>Sum Str</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getSumStr()
     * @generated
     * @ordered
     */
    protected static final String SUM_STR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSumStr() <em>Sum Str</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getSumStr()
     * @generated
     * @ordered
     */
    protected String sumStr = SUM_STR_EDEFAULT;

    /**
     * The default value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDatatype()
     * @generated
     * @ordered
     */
    protected static final Datatype DATATYPE_EDEFAULT = Datatype.INTEGER;

    /**
     * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDatatype()
     * @generated
     * @ordered
     */
    protected Datatype datatype = DATATYPE_EDEFAULT;

    /**
     * ADDED scorreia 2008-04-08 a class for handling sum in a generic way.
     */
    protected static abstract class GenericSum<T> {

        protected T sum = getDefaultValue();

        public void sumObject(Object object) {
            addNumber(castObject(object));
        }

        @SuppressWarnings("unchecked")
        T castObject(Object object) {
            return (T) object;
        }

        abstract void addNumber(T number);

        abstract T getDefaultValue();

        void reset() {
            this.sum = getDefaultValue();
        }

        public String getAsString() {
            return String.valueOf(sum);
        }
    };

    protected GenericSum<?> genericSum;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SumIndicatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IndicatorsPackage.Literals.SUM_INDICATOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getSumStr() {
        return sumStr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setSumStr(String newSumStr) {
        String oldSumStr = sumStr;
        sumStr = newSumStr;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IndicatorsPackage.SUM_INDICATOR__SUM_STR, oldSumStr, sumStr));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Datatype getDatatype() {
        return datatype;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setDatatype(Datatype newDatatype) {
        Datatype oldDatatype = datatype;
        datatype = newDatatype == null ? DATATYPE_EDEFAULT : newDatatype;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IndicatorsPackage.SUM_INDICATOR__DATATYPE, oldDatatype, datatype));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case IndicatorsPackage.SUM_INDICATOR__SUM_STR:
                return getSumStr();
            case IndicatorsPackage.SUM_INDICATOR__DATATYPE:
                return getDatatype();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case IndicatorsPackage.SUM_INDICATOR__SUM_STR:
                setSumStr((String)newValue);
                return;
            case IndicatorsPackage.SUM_INDICATOR__DATATYPE:
                setDatatype((Datatype)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case IndicatorsPackage.SUM_INDICATOR__SUM_STR:
                setSumStr(SUM_STR_EDEFAULT);
                return;
            case IndicatorsPackage.SUM_INDICATOR__DATATYPE:
                setDatatype(DATATYPE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case IndicatorsPackage.SUM_INDICATOR__SUM_STR:
                return SUM_STR_EDEFAULT == null ? sumStr != null : !SUM_STR_EDEFAULT.equals(sumStr);
            case IndicatorsPackage.SUM_INDICATOR__DATATYPE:
                return datatype != DATATYPE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (sumStr: ");
        result.append(sumStr);
        result.append(", datatype: ");
        result.append(datatype);
        result.append(')');
        return result.toString();
    }

    /*
     * (non-Javadoc) ADDED scorreia 2008-04-08 handle object
     * 
     * @see org.talend.dataquality.indicators.impl.IndicatorImpl#handle(java.lang.Object)
     */
    @Override
    public boolean handle(Object data) {
        boolean handled = super.handle(data);
        if (data == null) {
            // TODO scorreia handle null values !!!
            return false;
        }
        // assert data instanceof Integer : "Sum indicator wants integer data, got: " + data;
        this.getGenericSum(data).sumObject(data);
        return handled;
    }

    /**
     * DOC scorreia Comment method "getGenericSum".
     * 
     * @return
     */
    private GenericSum<?> getGenericSum(Object object) {
        if (genericSum != null) {
            return genericSum;
        }
        if (object instanceof Integer) {
            return new GenericSum<Integer>() {

                @Override
                Integer getDefaultValue() {
                    return 0;
                }

                @Override
                void addNumber(Integer number) {
                    this.sum += number;
                }

            };
        } else if (object instanceof Double) {
            return new GenericSum<Double>() {

                @Override
                Double getDefaultValue() {
                    return 0.0;
                }

                @Override
                void addNumber(Double number) {
                    this.sum += number;
                }

            };
        } else if (object instanceof BigDecimal) {
            return new GenericSum<BigDecimal>() {

                @Override
                BigDecimal getDefaultValue() {
                    return BigDecimal.ZERO;
                }

                @Override
                void addNumber(BigDecimal number) {
                    this.sum.add(number);
                }

            };
        }

        // TODO scorreia probably throw an exception here
        return new GenericSum<Object>() {

            @Override
            Object getDefaultValue() {
                return null;
            }

            @Override
            void addNumber(Object number) {
            }

        };

    }

    /*
     * (non-Javadoc) ADDED scorreia 2008-04-08 finalizeComputation
     * 
     * @see org.talend.dataquality.indicators.impl.IndicatorImpl#finalizeComputation()
     */
    @Override
    public boolean finalizeComputation() {
        boolean ok = super.finalizeComputation();
        if (genericSum == null) {
            return false;
        }
        this.sumStr = genericSum.getAsString();
        return ok;
    }

} // SumIndicatorImpl
