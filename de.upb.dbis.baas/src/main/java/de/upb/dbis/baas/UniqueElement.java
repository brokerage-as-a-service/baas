/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unique Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.UniqueElement#getUuid <em>Uuid</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getUniqueElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface UniqueElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see de.upb.dbis.baas.BaasPackage#getUniqueElement_Uuid()
	 * @model id="true"
	 * @generated
	 */
	String getUuid();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.UniqueElement#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(String value);

} // UniqueElement
