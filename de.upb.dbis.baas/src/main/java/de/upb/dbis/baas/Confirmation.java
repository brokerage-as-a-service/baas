/**
 */
package de.upb.dbis.baas;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Confirmation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Confirmation#getUser <em>User</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Confirmation#getDatetime <em>Datetime</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getConfirmation()
 * @model
 * @generated
 */
public interface Confirmation extends UniqueElement {
	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see de.upb.dbis.baas.BaasPackage#getConfirmation_User()
	 * @model
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Confirmation#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Datetime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datetime</em>' attribute.
	 * @see #setDatetime(Date)
	 * @see de.upb.dbis.baas.BaasPackage#getConfirmation_Datetime()
	 * @model
	 * @generated
	 */
	Date getDatetime();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Confirmation#getDatetime <em>Datetime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datetime</em>' attribute.
	 * @see #getDatetime()
	 * @generated
	 */
	void setDatetime(Date value);

} // Confirmation
