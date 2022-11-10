/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Vector#getSimilarities <em>Similarities</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getVector()
 * @model
 * @generated
 */
public interface Vector extends EObject {
	/**
	 * Returns the value of the '<em><b>Similarities</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.Similarity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Similarities</em>' containment reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getVector_Similarities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Similarity> getSimilarities();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double length();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double average();

} // Vector
