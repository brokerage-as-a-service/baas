/**
 */
package de.upb.dbis.baas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IO Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.IOMapping#getVector <em>Vector</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IOMapping#getLeft <em>Left</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IOMapping#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getIOMapping()
 * @model
 * @generated
 */
public interface IOMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vector</em>' containment reference.
	 * @see #setVector(Vector)
	 * @see de.upb.dbis.baas.BaasPackage#getIOMapping_Vector()
	 * @model containment="true"
	 * @generated
	 */
	Vector getVector();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IOMapping#getVector <em>Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vector</em>' containment reference.
	 * @see #getVector()
	 * @generated
	 */
	void setVector(Vector value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(IO)
	 * @see de.upb.dbis.baas.BaasPackage#getIOMapping_Left()
	 * @model
	 * @generated
	 */
	IO getLeft();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IOMapping#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(IO value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(IO)
	 * @see de.upb.dbis.baas.BaasPackage#getIOMapping_Right()
	 * @model
	 * @generated
	 */
	IO getRight();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IOMapping#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(IO value);

} // IOMapping
