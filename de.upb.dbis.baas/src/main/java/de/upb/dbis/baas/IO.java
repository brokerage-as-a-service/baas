/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.IO#getName <em>Name</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getDescription <em>Description</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getType <em>Type</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getFormat <em>Format</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getJsonPath <em>Json Path</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getValues <em>Values</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getDefault <em>Default</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getSemanticTypes <em>Semantic Types</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getSubject <em>Subject</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link de.upb.dbis.baas.IO#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getIO()
 * @model
 * @generated
 */
public interface IO extends UniqueElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.upb.dbis.baas.Operation#getIos <em>Ios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(Operation)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Operation()
	 * @see de.upb.dbis.baas.Operation#getIos
	 * @model opposite="ios" transient="false"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Json Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Json Path</em>' attribute.
	 * @see #setJsonPath(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_JsonPath()
	 * @model
	 * @generated
	 */
	String getJsonPath();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getJsonPath <em>Json Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Json Path</em>' attribute.
	 * @see #getJsonPath()
	 * @generated
	 */
	void setJsonPath(String value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Values()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Object> getValues();

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatype</em>' attribute.
	 * @see #setDatatype(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Datatype()
	 * @model
	 * @generated
	 */
	String getDatatype();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getDatatype <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype</em>' attribute.
	 * @see #getDatatype()
	 * @generated
	 */
	void setDatatype(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Default()
	 * @model
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Semantic Types</b></em>' reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.SemanticType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Types</em>' reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getIO_SemanticTypes()
	 * @model
	 * @generated
	 */
	EList<SemanticType> getSemanticTypes();

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' reference.
	 * @see #setSubject(SemanticType)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Subject()
	 * @model
	 * @generated
	 */
	SemanticType getSubject();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getSubject <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(SemanticType value);

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' reference.
	 * @see #setPredicate(SemanticType)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Predicate()
	 * @model
	 * @generated
	 */
	SemanticType getPredicate();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(SemanticType value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(SemanticType)
	 * @see de.upb.dbis.baas.BaasPackage#getIO_Object()
	 * @model
	 * @generated
	 */
	SemanticType getObject();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.IO#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(SemanticType value);

} // IO
