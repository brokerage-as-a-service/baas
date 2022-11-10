/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ranking</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.upb.dbis.baas.Ranking#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @see de.upb.dbis.baas.BaasPackage#getRanking()
 * @model abstract="true"
 * @generated
 */
public interface Ranking extends EObject {
	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.dbis.baas.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see de.upb.dbis.baas.BaasPackage#getRanking_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	double averagePrecision(int correct);

} // Ranking
