/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Similarity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Similarity#getName <em>Name</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Similarity#getSigma <em>Sigma</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getSimilarity()
 * @model
 * @generated
 */
public interface Similarity extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.upb.dbis.baas.BaasPackage#getSimilarity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Similarity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sigma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sigma</em>' attribute.
	 * @see #setSigma(double)
	 * @see de.upb.dbis.baas.BaasPackage#getSimilarity_Sigma()
	 * @model
	 * @generated
	 */
	double getSigma();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Similarity#getSigma <em>Sigma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sigma</em>' attribute.
	 * @see #getSigma()
	 * @generated
	 */
	void setSigma(double value);

} // Similarity
