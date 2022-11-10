/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Operation#getIos <em>Ios</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getOperationId <em>Operation Id</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getDescription <em>Description</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getSummary <em>Summary</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getResponseCode <em>Response Code</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getMethod <em>Method</em>}</li>
 *   <li>{@link de.upb.dbis.baas.Operation#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends UniqueElement {
	/**
	 * Returns the value of the '<em><b>Ios</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.IO}.
	 * It is bidirectional and its opposite is '{@link de.upb.dbis.baas.IO#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ios</em>' containment reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_Ios()
	 * @see de.upb.dbis.baas.IO#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<IO> getIos();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.upb.dbis.baas.Specification#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' container reference.
	 * @see #setSpecification(Specification)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_Specification()
	 * @see de.upb.dbis.baas.Specification#getOperations
	 * @model opposite="operations" transient="false"
	 * @generated
	 */
	Specification getSpecification();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getSpecification <em>Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' container reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(Specification value);

	/**
	 * Returns the value of the '<em><b>Operation Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Id</em>' attribute.
	 * @see #setOperationId(String)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_OperationId()
	 * @model
	 * @generated
	 */
	String getOperationId();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getOperationId <em>Operation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Id</em>' attribute.
	 * @see #getOperationId()
	 * @generated
	 */
	void setOperationId(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Summary</em>' attribute.
	 * @see #setSummary(String)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_Summary()
	 * @model
	 * @generated
	 */
	String getSummary();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getSummary <em>Summary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary</em>' attribute.
	 * @see #getSummary()
	 * @generated
	 */
	void setSummary(String value);

	/**
	 * Returns the value of the '<em><b>Response Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Code</em>' attribute.
	 * @see #setResponseCode(String)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_ResponseCode()
	 * @model
	 * @generated
	 */
	String getResponseCode();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getResponseCode <em>Response Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Code</em>' attribute.
	 * @see #getResponseCode()
	 * @generated
	 */
	void setResponseCode(String value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_Method()
	 * @model
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see de.upb.dbis.baas.BaasPackage#getOperation_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.Operation#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // Operation
