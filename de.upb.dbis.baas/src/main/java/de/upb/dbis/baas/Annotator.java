/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.upb.dbis.baas.BaasPackage#getAnnotator()
 * @model
 * @generated
 */
public interface Annotator extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AnnotationResult searchSemanticType(IO io);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void add(IO io, SemanticType type);

} // Annotator
