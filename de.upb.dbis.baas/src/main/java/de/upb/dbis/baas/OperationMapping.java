/**
 */
package de.upb.dbis.baas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.OperationMapping#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getOperationMapping()
 * @model
 * @generated
 */
public interface OperationMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see de.upb.dbis.baas.BaasPackage#getOperationMapping_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.OperationMapping#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // OperationMapping
