/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Specification#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Specification#getName <em>Name</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Specification#getRawSpecification <em>Raw Specification</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Specification#getDescription <em>Description</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Specification#getHost <em>Host</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends UniqueElement {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.Operation}.
	 * It is bidirectional and its opposite is '{@link de.upb.dbis.baas.Operation#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getSpecification_Operations()
	 * @see de.upb.dbis.baas.Operation#getSpecification
	 * @model opposite="specification" containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.upb.dbis.baas.BaasPackage#getSpecification_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Specification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Raw Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Specification</em>' attribute.
	 * @see #setRawSpecification(String)
	 * @see de.upb.dbis.baas.BaasPackage#getSpecification_RawSpecification()
	 * @model
	 * @generated
	 */
	String getRawSpecification();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Specification#getRawSpecification <em>Raw Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Specification</em>' attribute.
	 * @see #getRawSpecification()
	 * @generated
	 */
	void setRawSpecification(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.upb.dbis.baas.BaasPackage#getSpecification_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Specification#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see de.upb.dbis.baas.BaasPackage#getSpecification_Host()
	 * @model
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Specification#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

} // Specification
