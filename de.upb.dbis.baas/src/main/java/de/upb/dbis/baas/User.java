/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.User#getCompositions <em>Compositions</em>}</li>
 *   <li>{@link de.upb.dbis.baas.User#getSpecifications <em>Specifications</em>}</li>
 *   <li>{@link de.upb.dbis.baas.User#getLastName <em>Last Name</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getUser()
 * @model
 * @generated
 */
public interface User extends UniqueElement {
	/**
	 * Returns the value of the '<em><b>Compositions</b></em>' reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.Composition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compositions</em>' reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getUser_Compositions()
	 * @model
	 * @generated
	 */
	EList<Composition> getCompositions();

	/**
	 * Returns the value of the '<em><b>Specifications</b></em>' reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.Specification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifications</em>' reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getUser_Specifications()
	 * @model
	 * @generated
	 */
	EList<Specification> getSpecifications();

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see de.upb.dbis.baas.BaasPackage#getUser_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.User#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

} // User
