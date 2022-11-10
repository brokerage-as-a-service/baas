/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.IO;
import de.upb.dbis.baas.Operation;
import de.upb.dbis.baas.SemanticType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IO</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getJsonPath <em>Json Path</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getValues <em>Values</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getSemanticTypes <em>Semantic Types</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOImpl#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IOImpl extends MinimalEObjectImpl.Container implements IO {
	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getJsonPath() <em>Json Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsonPath()
	 * @generated
	 * @ordered
	 */
	protected static final String JSON_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJsonPath() <em>Json Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJsonPath()
	 * @generated
	 * @ordered
	 */
	protected String jsonPath = JSON_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> values;

	/**
	 * The default value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected static final String DATATYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected String datatype = DATATYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSemanticTypes() <em>Semantic Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticType> semanticTypes;

	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected SemanticType subject;

	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected SemanticType predicate;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected SemanticType object;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IOImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaasPackage.Literals.IO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperation() {
		if (eContainerFeatureID() != BaasPackage.IO__OPERATION) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, BaasPackage.IO__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(Operation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != BaasPackage.IO__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, BaasPackage.OPERATION__IOS, Operation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJsonPath() {
		return jsonPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJsonPath(String newJsonPath) {
		String oldJsonPath = jsonPath;
		jsonPath = newJsonPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__JSON_PATH, oldJsonPath, jsonPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getValues() {
		if (values == null) {
			values = new EDataTypeUniqueEList<Object>(Object.class, this, BaasPackage.IO__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDatatype() {
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatatype(String newDatatype) {
		String oldDatatype = datatype;
		datatype = newDatatype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__DATATYPE, oldDatatype, datatype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticType> getSemanticTypes() {
		if (semanticTypes == null) {
			semanticTypes = new EObjectResolvingEList<SemanticType>(SemanticType.class, this, BaasPackage.IO__SEMANTIC_TYPES);
		}
		return semanticTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType getSubject() {
		if (subject != null && subject.eIsProxy()) {
			InternalEObject oldSubject = (InternalEObject)subject;
			subject = (SemanticType)eResolveProxy(oldSubject);
			if (subject != oldSubject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.IO__SUBJECT, oldSubject, subject));
			}
		}
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType basicGetSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(SemanticType newSubject) {
		SemanticType oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__SUBJECT, oldSubject, subject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType getPredicate() {
		if (predicate != null && predicate.eIsProxy()) {
			InternalEObject oldPredicate = (InternalEObject)predicate;
			predicate = (SemanticType)eResolveProxy(oldPredicate);
			if (predicate != oldPredicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.IO__PREDICATE, oldPredicate, predicate));
			}
		}
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType basicGetPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(SemanticType newPredicate) {
		SemanticType oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__PREDICATE, oldPredicate, predicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = (SemanticType)eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.IO__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(SemanticType newObject) {
		SemanticType oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaasPackage.IO__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((Operation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaasPackage.IO__OPERATION:
				return basicSetOperation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BaasPackage.IO__OPERATION:
				return eInternalContainer().eInverseRemove(this, BaasPackage.OPERATION__IOS, Operation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaasPackage.IO__UUID:
				return getUuid();
			case BaasPackage.IO__NAME:
				return getName();
			case BaasPackage.IO__OPERATION:
				return getOperation();
			case BaasPackage.IO__DESCRIPTION:
				return getDescription();
			case BaasPackage.IO__TYPE:
				return getType();
			case BaasPackage.IO__FORMAT:
				return getFormat();
			case BaasPackage.IO__JSON_PATH:
				return getJsonPath();
			case BaasPackage.IO__VALUES:
				return getValues();
			case BaasPackage.IO__DATATYPE:
				return getDatatype();
			case BaasPackage.IO__DEFAULT:
				return getDefault();
			case BaasPackage.IO__SEMANTIC_TYPES:
				return getSemanticTypes();
			case BaasPackage.IO__SUBJECT:
				if (resolve) return getSubject();
				return basicGetSubject();
			case BaasPackage.IO__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case BaasPackage.IO__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BaasPackage.IO__UUID:
				setUuid((String)newValue);
				return;
			case BaasPackage.IO__NAME:
				setName((String)newValue);
				return;
			case BaasPackage.IO__OPERATION:
				setOperation((Operation)newValue);
				return;
			case BaasPackage.IO__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BaasPackage.IO__TYPE:
				setType((String)newValue);
				return;
			case BaasPackage.IO__FORMAT:
				setFormat((String)newValue);
				return;
			case BaasPackage.IO__JSON_PATH:
				setJsonPath((String)newValue);
				return;
			case BaasPackage.IO__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Object>)newValue);
				return;
			case BaasPackage.IO__DATATYPE:
				setDatatype((String)newValue);
				return;
			case BaasPackage.IO__DEFAULT:
				setDefault((String)newValue);
				return;
			case BaasPackage.IO__SEMANTIC_TYPES:
				getSemanticTypes().clear();
				getSemanticTypes().addAll((Collection<? extends SemanticType>)newValue);
				return;
			case BaasPackage.IO__SUBJECT:
				setSubject((SemanticType)newValue);
				return;
			case BaasPackage.IO__PREDICATE:
				setPredicate((SemanticType)newValue);
				return;
			case BaasPackage.IO__OBJECT:
				setObject((SemanticType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BaasPackage.IO__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case BaasPackage.IO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BaasPackage.IO__OPERATION:
				setOperation((Operation)null);
				return;
			case BaasPackage.IO__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BaasPackage.IO__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case BaasPackage.IO__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case BaasPackage.IO__JSON_PATH:
				setJsonPath(JSON_PATH_EDEFAULT);
				return;
			case BaasPackage.IO__VALUES:
				getValues().clear();
				return;
			case BaasPackage.IO__DATATYPE:
				setDatatype(DATATYPE_EDEFAULT);
				return;
			case BaasPackage.IO__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case BaasPackage.IO__SEMANTIC_TYPES:
				getSemanticTypes().clear();
				return;
			case BaasPackage.IO__SUBJECT:
				setSubject((SemanticType)null);
				return;
			case BaasPackage.IO__PREDICATE:
				setPredicate((SemanticType)null);
				return;
			case BaasPackage.IO__OBJECT:
				setObject((SemanticType)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BaasPackage.IO__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case BaasPackage.IO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BaasPackage.IO__OPERATION:
				return getOperation() != null;
			case BaasPackage.IO__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case BaasPackage.IO__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case BaasPackage.IO__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case BaasPackage.IO__JSON_PATH:
				return JSON_PATH_EDEFAULT == null ? jsonPath != null : !JSON_PATH_EDEFAULT.equals(jsonPath);
			case BaasPackage.IO__VALUES:
				return values != null && !values.isEmpty();
			case BaasPackage.IO__DATATYPE:
				return DATATYPE_EDEFAULT == null ? datatype != null : !DATATYPE_EDEFAULT.equals(datatype);
			case BaasPackage.IO__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case BaasPackage.IO__SEMANTIC_TYPES:
				return semanticTypes != null && !semanticTypes.isEmpty();
			case BaasPackage.IO__SUBJECT:
				return subject != null;
			case BaasPackage.IO__PREDICATE:
				return predicate != null;
			case BaasPackage.IO__OBJECT:
				return object != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (uuid: ");
		result.append(uuid);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", type: ");
		result.append(type);
		result.append(", format: ");
		result.append(format);
		result.append(", jsonPath: ");
		result.append(jsonPath);
		result.append(", values: ");
		result.append(values);
		result.append(", datatype: ");
		result.append(datatype);
		result.append(", default: ");
		result.append(default_);
		result.append(')');
		return result.toString();
	}

} //IOImpl
