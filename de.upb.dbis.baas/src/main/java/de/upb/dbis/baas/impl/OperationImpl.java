/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.IO;
import de.upb.dbis.baas.Operation;
import de.upb.dbis.baas.Specification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getIos <em>Ios</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getOperationId <em>Operation Id</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getSummary <em>Summary</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getResponseCode <em>Response Code</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends MinimalEObjectImpl.Container implements Operation {
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
	 * The cached value of the '{@link #getIos() <em>Ios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIos()
	 * @generated
	 * @ordered
	 */
	protected EList<IO> ios;

	/**
	 * The default value of the '{@link #getOperationId() <em>Operation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationId()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationId() <em>Operation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationId()
	 * @generated
	 * @ordered
	 */
	protected String operationId = OPERATION_ID_EDEFAULT;

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
	 * The default value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSummary() <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummary()
	 * @generated
	 * @ordered
	 */
	protected String summary = SUMMARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponseCode() <em>Response Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseCode()
	 * @generated
	 * @ordered
	 */
	protected static final String RESPONSE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResponseCode() <em>Response Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseCode()
	 * @generated
	 * @ordered
	 */
	protected String responseCode = RESPONSE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected String method = METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaasPackage.Literals.OPERATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IO> getIos() {
		if (ios == null) {
			ios = new EObjectContainmentWithInverseEList<IO>(IO.class, this, BaasPackage.OPERATION__IOS, BaasPackage.IO__OPERATION);
		}
		return ios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getSpecification() {
		if (eContainerFeatureID() != BaasPackage.OPERATION__SPECIFICATION) return null;
		return (Specification)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification(Specification newSpecification, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSpecification, BaasPackage.OPERATION__SPECIFICATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(Specification newSpecification) {
		if (newSpecification != eInternalContainer() || (eContainerFeatureID() != BaasPackage.OPERATION__SPECIFICATION && newSpecification != null)) {
			if (EcoreUtil.isAncestor(this, newSpecification))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecification != null)
				msgs = ((InternalEObject)newSpecification).eInverseAdd(this, BaasPackage.SPECIFICATION__OPERATIONS, Specification.class, msgs);
			msgs = basicSetSpecification(newSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__SPECIFICATION, newSpecification, newSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationId(String newOperationId) {
		String oldOperationId = operationId;
		operationId = newOperationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__OPERATION_ID, oldOperationId, operationId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSummary(String newSummary) {
		String oldSummary = summary;
		summary = newSummary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__SUMMARY, oldSummary, summary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseCode(String newResponseCode) {
		String oldResponseCode = responseCode;
		responseCode = newResponseCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__RESPONSE_CODE, oldResponseCode, responseCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethod(String newMethod) {
		String oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaasPackage.OPERATION__IOS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIos()).basicAdd(otherEnd, msgs);
			case BaasPackage.OPERATION__SPECIFICATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSpecification((Specification)otherEnd, msgs);
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
			case BaasPackage.OPERATION__IOS:
				return ((InternalEList<?>)getIos()).basicRemove(otherEnd, msgs);
			case BaasPackage.OPERATION__SPECIFICATION:
				return basicSetSpecification(null, msgs);
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
			case BaasPackage.OPERATION__SPECIFICATION:
				return eInternalContainer().eInverseRemove(this, BaasPackage.SPECIFICATION__OPERATIONS, Specification.class, msgs);
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
			case BaasPackage.OPERATION__UUID:
				return getUuid();
			case BaasPackage.OPERATION__IOS:
				return getIos();
			case BaasPackage.OPERATION__SPECIFICATION:
				return getSpecification();
			case BaasPackage.OPERATION__OPERATION_ID:
				return getOperationId();
			case BaasPackage.OPERATION__DESCRIPTION:
				return getDescription();
			case BaasPackage.OPERATION__SUMMARY:
				return getSummary();
			case BaasPackage.OPERATION__RESPONSE_CODE:
				return getResponseCode();
			case BaasPackage.OPERATION__METHOD:
				return getMethod();
			case BaasPackage.OPERATION__PATH:
				return getPath();
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
			case BaasPackage.OPERATION__UUID:
				setUuid((String)newValue);
				return;
			case BaasPackage.OPERATION__IOS:
				getIos().clear();
				getIos().addAll((Collection<? extends IO>)newValue);
				return;
			case BaasPackage.OPERATION__SPECIFICATION:
				setSpecification((Specification)newValue);
				return;
			case BaasPackage.OPERATION__OPERATION_ID:
				setOperationId((String)newValue);
				return;
			case BaasPackage.OPERATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BaasPackage.OPERATION__SUMMARY:
				setSummary((String)newValue);
				return;
			case BaasPackage.OPERATION__RESPONSE_CODE:
				setResponseCode((String)newValue);
				return;
			case BaasPackage.OPERATION__METHOD:
				setMethod((String)newValue);
				return;
			case BaasPackage.OPERATION__PATH:
				setPath((String)newValue);
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
			case BaasPackage.OPERATION__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case BaasPackage.OPERATION__IOS:
				getIos().clear();
				return;
			case BaasPackage.OPERATION__SPECIFICATION:
				setSpecification((Specification)null);
				return;
			case BaasPackage.OPERATION__OPERATION_ID:
				setOperationId(OPERATION_ID_EDEFAULT);
				return;
			case BaasPackage.OPERATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BaasPackage.OPERATION__SUMMARY:
				setSummary(SUMMARY_EDEFAULT);
				return;
			case BaasPackage.OPERATION__RESPONSE_CODE:
				setResponseCode(RESPONSE_CODE_EDEFAULT);
				return;
			case BaasPackage.OPERATION__METHOD:
				setMethod(METHOD_EDEFAULT);
				return;
			case BaasPackage.OPERATION__PATH:
				setPath(PATH_EDEFAULT);
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
			case BaasPackage.OPERATION__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case BaasPackage.OPERATION__IOS:
				return ios != null && !ios.isEmpty();
			case BaasPackage.OPERATION__SPECIFICATION:
				return getSpecification() != null;
			case BaasPackage.OPERATION__OPERATION_ID:
				return OPERATION_ID_EDEFAULT == null ? operationId != null : !OPERATION_ID_EDEFAULT.equals(operationId);
			case BaasPackage.OPERATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case BaasPackage.OPERATION__SUMMARY:
				return SUMMARY_EDEFAULT == null ? summary != null : !SUMMARY_EDEFAULT.equals(summary);
			case BaasPackage.OPERATION__RESPONSE_CODE:
				return RESPONSE_CODE_EDEFAULT == null ? responseCode != null : !RESPONSE_CODE_EDEFAULT.equals(responseCode);
			case BaasPackage.OPERATION__METHOD:
				return METHOD_EDEFAULT == null ? method != null : !METHOD_EDEFAULT.equals(method);
			case BaasPackage.OPERATION__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
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
		result.append(", operationId: ");
		result.append(operationId);
		result.append(", description: ");
		result.append(description);
		result.append(", summary: ");
		result.append(summary);
		result.append(", responseCode: ");
		result.append(responseCode);
		result.append(", method: ");
		result.append(method);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //OperationImpl
