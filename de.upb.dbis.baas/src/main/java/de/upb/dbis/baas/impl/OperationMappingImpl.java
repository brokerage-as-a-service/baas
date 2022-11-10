/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.Confirmation;
import de.upb.dbis.baas.Operation;
import de.upb.dbis.baas.OperationMapping;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.impl.OperationMappingImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationMappingImpl#getScore <em>Score</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationMappingImpl#getConfirmation <em>Confirmation</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationMappingImpl#getRelevance <em>Relevance</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.OperationMappingImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationMappingImpl extends MinimalEObjectImpl.Container implements OperationMapping {
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
	 * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected static final double SCORE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected double score = SCORE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfirmation() <em>Confirmation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfirmation()
	 * @generated
	 * @ordered
	 */
	protected EList<Confirmation> confirmation;

	/**
	 * The default value of the '{@link #getRelevance() <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected static final double RELEVANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getRelevance() <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected double relevance = RELEVANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaasPackage.Literals.OPERATION_MAPPING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION_MAPPING__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getScore() {
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(double newScore) {
		double oldScore = score;
		score = newScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION_MAPPING__SCORE, oldScore, score));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Confirmation> getConfirmation() {
		if (confirmation == null) {
			confirmation = new EObjectResolvingEList<Confirmation>(Confirmation.class, this, BaasPackage.OPERATION_MAPPING__CONFIRMATION);
		}
		return confirmation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRelevance() {
		return relevance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevance(double newRelevance) {
		double oldRelevance = relevance;
		relevance = newRelevance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION_MAPPING__RELEVANCE, oldRelevance, relevance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperation() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (Operation)eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.OPERATION_MAPPING__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(Operation newOperation) {
		Operation oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.OPERATION_MAPPING__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaasPackage.OPERATION_MAPPING__UUID:
				return getUuid();
			case BaasPackage.OPERATION_MAPPING__SCORE:
				return getScore();
			case BaasPackage.OPERATION_MAPPING__CONFIRMATION:
				return getConfirmation();
			case BaasPackage.OPERATION_MAPPING__RELEVANCE:
				return getRelevance();
			case BaasPackage.OPERATION_MAPPING__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
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
			case BaasPackage.OPERATION_MAPPING__UUID:
				setUuid((String)newValue);
				return;
			case BaasPackage.OPERATION_MAPPING__SCORE:
				setScore((Double)newValue);
				return;
			case BaasPackage.OPERATION_MAPPING__CONFIRMATION:
				getConfirmation().clear();
				getConfirmation().addAll((Collection<? extends Confirmation>)newValue);
				return;
			case BaasPackage.OPERATION_MAPPING__RELEVANCE:
				setRelevance((Double)newValue);
				return;
			case BaasPackage.OPERATION_MAPPING__OPERATION:
				setOperation((Operation)newValue);
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
			case BaasPackage.OPERATION_MAPPING__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case BaasPackage.OPERATION_MAPPING__SCORE:
				setScore(SCORE_EDEFAULT);
				return;
			case BaasPackage.OPERATION_MAPPING__CONFIRMATION:
				getConfirmation().clear();
				return;
			case BaasPackage.OPERATION_MAPPING__RELEVANCE:
				setRelevance(RELEVANCE_EDEFAULT);
				return;
			case BaasPackage.OPERATION_MAPPING__OPERATION:
				setOperation((Operation)null);
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
			case BaasPackage.OPERATION_MAPPING__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case BaasPackage.OPERATION_MAPPING__SCORE:
				return score != SCORE_EDEFAULT;
			case BaasPackage.OPERATION_MAPPING__CONFIRMATION:
				return confirmation != null && !confirmation.isEmpty();
			case BaasPackage.OPERATION_MAPPING__RELEVANCE:
				return relevance != RELEVANCE_EDEFAULT;
			case BaasPackage.OPERATION_MAPPING__OPERATION:
				return operation != null;
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
		result.append(", score: ");
		result.append(score);
		result.append(", relevance: ");
		result.append(relevance);
		result.append(')');
		return result.toString();
	}

} //OperationMappingImpl
