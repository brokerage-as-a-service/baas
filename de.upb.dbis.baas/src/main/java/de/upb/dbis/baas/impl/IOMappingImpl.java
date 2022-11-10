/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.Confirmation;
import de.upb.dbis.baas.IO;
import de.upb.dbis.baas.IOMapping;
import de.upb.dbis.baas.Vector;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IO Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getScore <em>Score</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getConfirmation <em>Confirmation</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getRelevance <em>Relevance</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getVector <em>Vector</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.IOMappingImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IOMappingImpl extends MinimalEObjectImpl.Container implements IOMapping {
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
	 * The cached value of the '{@link #getVector() <em>Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVector()
	 * @generated
	 * @ordered
	 */
	protected Vector vector;

	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected IO left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected IO right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IOMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaasPackage.Literals.IO_MAPPING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__UUID, oldUuid, uuid));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__SCORE, oldScore, score));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Confirmation> getConfirmation() {
		if (confirmation == null) {
			confirmation = new EObjectResolvingEList<Confirmation>(Confirmation.class, this, BaasPackage.IO_MAPPING__CONFIRMATION);
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__RELEVANCE, oldRelevance, relevance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector getVector() {
		return vector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVector(Vector newVector, NotificationChain msgs) {
		Vector oldVector = vector;
		vector = newVector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__VECTOR, oldVector, newVector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVector(Vector newVector) {
		if (newVector != vector) {
			NotificationChain msgs = null;
			if (vector != null)
				msgs = ((InternalEObject)vector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaasPackage.IO_MAPPING__VECTOR, null, msgs);
			if (newVector != null)
				msgs = ((InternalEObject)newVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaasPackage.IO_MAPPING__VECTOR, null, msgs);
			msgs = basicSetVector(newVector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__VECTOR, newVector, newVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO getLeft() {
		if (left != null && left.eIsProxy()) {
			InternalEObject oldLeft = (InternalEObject)left;
			left = (IO)eResolveProxy(oldLeft);
			if (left != oldLeft) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.IO_MAPPING__LEFT, oldLeft, left));
			}
		}
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO basicGetLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(IO newLeft) {
		IO oldLeft = left;
		left = newLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__LEFT, oldLeft, left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO getRight() {
		if (right != null && right.eIsProxy()) {
			InternalEObject oldRight = (InternalEObject)right;
			right = (IO)eResolveProxy(oldRight);
			if (right != oldRight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.IO_MAPPING__RIGHT, oldRight, right));
			}
		}
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO basicGetRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(IO newRight) {
		IO oldRight = right;
		right = newRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.IO_MAPPING__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaasPackage.IO_MAPPING__VECTOR:
				return basicSetVector(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaasPackage.IO_MAPPING__UUID:
				return getUuid();
			case BaasPackage.IO_MAPPING__SCORE:
				return getScore();
			case BaasPackage.IO_MAPPING__CONFIRMATION:
				return getConfirmation();
			case BaasPackage.IO_MAPPING__RELEVANCE:
				return getRelevance();
			case BaasPackage.IO_MAPPING__VECTOR:
				return getVector();
			case BaasPackage.IO_MAPPING__LEFT:
				if (resolve) return getLeft();
				return basicGetLeft();
			case BaasPackage.IO_MAPPING__RIGHT:
				if (resolve) return getRight();
				return basicGetRight();
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
			case BaasPackage.IO_MAPPING__UUID:
				setUuid((String)newValue);
				return;
			case BaasPackage.IO_MAPPING__SCORE:
				setScore((Double)newValue);
				return;
			case BaasPackage.IO_MAPPING__CONFIRMATION:
				getConfirmation().clear();
				getConfirmation().addAll((Collection<? extends Confirmation>)newValue);
				return;
			case BaasPackage.IO_MAPPING__RELEVANCE:
				setRelevance((Double)newValue);
				return;
			case BaasPackage.IO_MAPPING__VECTOR:
				setVector((Vector)newValue);
				return;
			case BaasPackage.IO_MAPPING__LEFT:
				setLeft((IO)newValue);
				return;
			case BaasPackage.IO_MAPPING__RIGHT:
				setRight((IO)newValue);
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
			case BaasPackage.IO_MAPPING__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case BaasPackage.IO_MAPPING__SCORE:
				setScore(SCORE_EDEFAULT);
				return;
			case BaasPackage.IO_MAPPING__CONFIRMATION:
				getConfirmation().clear();
				return;
			case BaasPackage.IO_MAPPING__RELEVANCE:
				setRelevance(RELEVANCE_EDEFAULT);
				return;
			case BaasPackage.IO_MAPPING__VECTOR:
				setVector((Vector)null);
				return;
			case BaasPackage.IO_MAPPING__LEFT:
				setLeft((IO)null);
				return;
			case BaasPackage.IO_MAPPING__RIGHT:
				setRight((IO)null);
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
			case BaasPackage.IO_MAPPING__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case BaasPackage.IO_MAPPING__SCORE:
				return score != SCORE_EDEFAULT;
			case BaasPackage.IO_MAPPING__CONFIRMATION:
				return confirmation != null && !confirmation.isEmpty();
			case BaasPackage.IO_MAPPING__RELEVANCE:
				return relevance != RELEVANCE_EDEFAULT;
			case BaasPackage.IO_MAPPING__VECTOR:
				return vector != null;
			case BaasPackage.IO_MAPPING__LEFT:
				return left != null;
			case BaasPackage.IO_MAPPING__RIGHT:
				return right != null;
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

} //IOMappingImpl
