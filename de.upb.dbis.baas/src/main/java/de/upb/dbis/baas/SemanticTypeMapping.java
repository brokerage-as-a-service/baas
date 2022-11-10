/**
 */
package de.upb.dbis.baas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantic Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.SemanticTypeMapping#getSemantictype <em>Semantictype</em>}</li>
 *   <li>{@link de.upb.dbis.baas.SemanticTypeMapping#getIo <em>Io</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getSemanticTypeMapping()
 * @model
 * @generated
 */
public interface SemanticTypeMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Semantictype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantictype</em>' reference.
	 * @see #setSemantictype(SemanticType)
	 * @see de.upb.dbis.baas.BaasPackage#getSemanticTypeMapping_Semantictype()
	 * @model
	 * @generated
	 */
	SemanticType getSemantictype();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.SemanticTypeMapping#getSemantictype <em>Semantictype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantictype</em>' reference.
	 * @see #getSemantictype()
	 * @generated
	 */
	void setSemantictype(SemanticType value);

	/**
	 * Returns the value of the '<em><b>Io</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Io</em>' reference.
	 * @see #setIo(IO)
	 * @see de.upb.dbis.baas.BaasPackage#getSemanticTypeMapping_Io()
	 * @model
	 * @generated
	 */
	IO getIo();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.SemanticTypeMapping#getIo <em>Io</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Io</em>' reference.
	 * @see #getIo()
	 * @generated
	 */
	void setIo(IO value);

} // SemanticTypeMapping
