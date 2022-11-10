/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.upb.dbis.baas.BaasPackage
 * @generated
 */
public interface BaasFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaasFactory eINSTANCE = de.upb.dbis.baas.impl.BaasFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Composition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composition</em>'.
	 * @generated
	 */
	Composition createComposition();

	/**
	 * Returns a new object of class '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specification</em>'.
	 * @generated
	 */
	Specification createSpecification();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>IO</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IO</em>'.
	 * @generated
	 */
	IO createIO();

	/**
	 * Returns a new object of class '<em>Annotator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotator</em>'.
	 * @generated
	 */
	Annotator createAnnotator();

	/**
	 * Returns a new object of class '<em>Annotation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Result</em>'.
	 * @generated
	 */
	AnnotationResult createAnnotationResult();

	/**
	 * Returns a new object of class '<em>Semantic Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Type</em>'.
	 * @generated
	 */
	SemanticType createSemanticType();

	/**
	 * Returns a new object of class '<em>Discovery Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Discovery Result</em>'.
	 * @generated
	 */
	DiscoveryResult createDiscoveryResult();

	/**
	 * Returns a new object of class '<em>Semantic Type Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Type Mapping</em>'.
	 * @generated
	 */
	SemanticTypeMapping createSemanticTypeMapping();

	/**
	 * Returns a new object of class '<em>Vector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vector</em>'.
	 * @generated
	 */
	Vector createVector();

	/**
	 * Returns a new object of class '<em>Similarity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Similarity</em>'.
	 * @generated
	 */
	Similarity createSimilarity();

	/**
	 * Returns a new object of class '<em>IO Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IO Mapping</em>'.
	 * @generated
	 */
	IOMapping createIOMapping();

	/**
	 * Returns a new object of class '<em>Matching Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matching Result</em>'.
	 * @generated
	 */
	MatchingResult createMatchingResult();

	/**
	 * Returns a new object of class '<em>Confirmation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Confirmation</em>'.
	 * @generated
	 */
	Confirmation createConfirmation();

	/**
	 * Returns a new object of class '<em>Operation Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Mapping</em>'.
	 * @generated
	 */
	OperationMapping createOperationMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BaasPackage getBaasPackage();

} //BaasFactory
