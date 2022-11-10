/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.Confirmation;
import de.upb.dbis.baas.IO;
import de.upb.dbis.baas.SemanticType;
import de.upb.dbis.baas.SemanticTypeMapping;

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
 * An implementation of the model object '<em><b>Semantic Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl#getScore <em>Score</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl#getConfirmation <em>Confirmation</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl#getRelevance <em>Relevance</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl#getSemantictype <em>Semantictype</em>}</li>
 *   <li>{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl#getIo <em>Io</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticTypeMappingImpl extends MinimalEObjectImpl.Container implements SemanticTypeMapping {
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
	 * The cached value of the '{@link #getSemantictype() <em>Semantictype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantictype()
	 * @generated
	 * @ordered
	 */
	protected SemanticType semantictype;

	/**
	 * The cached value of the '{@link #getIo() <em>Io</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIo()
	 * @generated
	 * @ordered
	 */
	protected IO io;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticTypeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaasPackage.Literals.SEMANTIC_TYPE_MAPPING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.SEMANTIC_TYPE_MAPPING__UUID, oldUuid, uuid));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.SEMANTIC_TYPE_MAPPING__SCORE, oldScore, score));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Confirmation> getConfirmation() {
		if (confirmation == null) {
			confirmation = new EObjectResolvingEList<Confirmation>(Confirmation.class, this, BaasPackage.SEMANTIC_TYPE_MAPPING__CONFIRMATION);
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.SEMANTIC_TYPE_MAPPING__RELEVANCE, oldRelevance, relevance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType getSemantictype() {
		if (semantictype != null && semantictype.eIsProxy()) {
			InternalEObject oldSemantictype = (InternalEObject)semantictype;
			semantictype = (SemanticType)eResolveProxy(oldSemantictype);
			if (semantictype != oldSemantictype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.SEMANTIC_TYPE_MAPPING__SEMANTICTYPE, oldSemantictype, semantictype));
			}
		}
		return semantictype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType basicGetSemantictype() {
		return semantictype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemantictype(SemanticType newSemantictype) {
		SemanticType oldSemantictype = semantictype;
		semantictype = newSemantictype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.SEMANTIC_TYPE_MAPPING__SEMANTICTYPE, oldSemantictype, semantictype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO getIo() {
		if (io != null && io.eIsProxy()) {
			InternalEObject oldIo = (InternalEObject)io;
			io = (IO)eResolveProxy(oldIo);
			if (io != oldIo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaasPackage.SEMANTIC_TYPE_MAPPING__IO, oldIo, io));
			}
		}
		return io;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO basicGetIo() {
		return io;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIo(IO newIo) {
		IO oldIo = io;
		io = newIo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaasPackage.SEMANTIC_TYPE_MAPPING__IO, oldIo, io));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaasPackage.SEMANTIC_TYPE_MAPPING__UUID:
				return getUuid();
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SCORE:
				return getScore();
			case BaasPackage.SEMANTIC_TYPE_MAPPING__CONFIRMATION:
				return getConfirmation();
			case BaasPackage.SEMANTIC_TYPE_MAPPING__RELEVANCE:
				return getRelevance();
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SEMANTICTYPE:
				if (resolve) return getSemantictype();
				return basicGetSemantictype();
			case BaasPackage.SEMANTIC_TYPE_MAPPING__IO:
				if (resolve) return getIo();
				return basicGetIo();
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
			case BaasPackage.SEMANTIC_TYPE_MAPPING__UUID:
				setUuid((String)newValue);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SCORE:
				setScore((Double)newValue);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__CONFIRMATION:
				getConfirmation().clear();
				getConfirmation().addAll((Collection<? extends Confirmation>)newValue);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__RELEVANCE:
				setRelevance((Double)newValue);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SEMANTICTYPE:
				setSemantictype((SemanticType)newValue);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__IO:
				setIo((IO)newValue);
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
			case BaasPackage.SEMANTIC_TYPE_MAPPING__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SCORE:
				setScore(SCORE_EDEFAULT);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__CONFIRMATION:
				getConfirmation().clear();
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__RELEVANCE:
				setRelevance(RELEVANCE_EDEFAULT);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SEMANTICTYPE:
				setSemantictype((SemanticType)null);
				return;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__IO:
				setIo((IO)null);
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
			case BaasPackage.SEMANTIC_TYPE_MAPPING__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SCORE:
				return score != SCORE_EDEFAULT;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__CONFIRMATION:
				return confirmation != null && !confirmation.isEmpty();
			case BaasPackage.SEMANTIC_TYPE_MAPPING__RELEVANCE:
				return relevance != RELEVANCE_EDEFAULT;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__SEMANTICTYPE:
				return semantictype != null;
			case BaasPackage.SEMANTIC_TYPE_MAPPING__IO:
				return io != null;
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

} //SemanticTypeMappingImpl
