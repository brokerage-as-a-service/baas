/**
 */
package de.upb.dbis.baas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Discovery Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.DiscoveryResult#getQuery <em>Query</em>}</li>
 *   <li>{@link de.upb.dbis.baas.DiscoveryResult#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getDiscoveryResult()
 * @model
 * @generated
 */
public interface DiscoveryResult extends Ranking, UniqueElement {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see de.upb.dbis.baas.BaasPackage#getDiscoveryResult_Query()
	 * @model
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.DiscoveryResult#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.upb.dbis.baas.BaasPackage#getDiscoveryResult_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.upb.dbis.baas.DiscoveryResult#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DiscoveryResult
