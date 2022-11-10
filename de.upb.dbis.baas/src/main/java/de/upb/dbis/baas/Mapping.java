/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Mapping#getScore <em>Score</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Mapping#getConfirmation <em>Confirmation</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Mapping#getRelevance <em>Relevance</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getMapping()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Mapping extends UniqueElement {
	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see #setScore(double)
	 * @see de.upb.dbis.baas.BaasPackage#getMapping_Score()
	 * @model
	 * @generated
	 */
	double getScore();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Mapping#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' attribute.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(double value);

	/**
	 * Returns the value of the '<em><b>Confirmation</b></em>' reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.Confirmation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confirmation</em>' reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getMapping_Confirmation()
	 * @model
	 * @generated
	 */
	EList<Confirmation> getConfirmation();

	/**
	 * Returns the value of the '<em><b>Relevance</b></em>' attribute.
	 * The default value is <code>"-1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance</em>' attribute.
	 * @see #setRelevance(double)
	 * @see de.upb.dbis.baas.BaasPackage#getMapping_Relevance()
	 * @model default="-1.0"
	 * @generated
	 */
	double getRelevance();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Mapping#getRelevance <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance</em>' attribute.
	 * @see #getRelevance()
	 * @generated
	 */
	void setRelevance(double value);

} // Mapping
