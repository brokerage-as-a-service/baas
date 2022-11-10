/**
 */
package de.upb.dbis.baas.util;

import de.upb.dbis.baas.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.upb.dbis.baas.BaasPackage
 * @generated
 */
public class BaasAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BaasPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaasAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BaasPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaasSwitch<Adapter> modelSwitch =
		new BaasSwitch<Adapter>() {
			@Override
			public Adapter caseUser(User object) {
				return createUserAdapter();
			}
			@Override
			public Adapter caseComposition(Composition object) {
				return createCompositionAdapter();
			}
			@Override
			public Adapter caseSpecification(Specification object) {
				return createSpecificationAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseIO(IO object) {
				return createIOAdapter();
			}
			@Override
			public Adapter caseAnnotator(Annotator object) {
				return createAnnotatorAdapter();
			}
			@Override
			public Adapter caseAnnotationResult(AnnotationResult object) {
				return createAnnotationResultAdapter();
			}
			@Override
			public Adapter caseSemanticType(SemanticType object) {
				return createSemanticTypeAdapter();
			}
			@Override
			public Adapter caseDiscoveryResult(DiscoveryResult object) {
				return createDiscoveryResultAdapter();
			}
			@Override
			public Adapter caseSemanticTypeMapping(SemanticTypeMapping object) {
				return createSemanticTypeMappingAdapter();
			}
			@Override
			public Adapter caseVector(Vector object) {
				return createVectorAdapter();
			}
			@Override
			public Adapter caseSimilarity(Similarity object) {
				return createSimilarityAdapter();
			}
			@Override
			public Adapter caseIOMapping(IOMapping object) {
				return createIOMappingAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseUniqueElement(UniqueElement object) {
				return createUniqueElementAdapter();
			}
			@Override
			public Adapter caseRanking(Ranking object) {
				return createRankingAdapter();
			}
			@Override
			public Adapter caseMatchingResult(MatchingResult object) {
				return createMatchingResultAdapter();
			}
			@Override
			public Adapter caseConfirmation(Confirmation object) {
				return createConfirmationAdapter();
			}
			@Override
			public Adapter caseOperationMapping(OperationMapping object) {
				return createOperationMappingAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.User
	 * @generated
	 */
	public Adapter createUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Composition <em>Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Composition
	 * @generated
	 */
	public Adapter createCompositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Specification
	 * @generated
	 */
	public Adapter createSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.IO <em>IO</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.IO
	 * @generated
	 */
	public Adapter createIOAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Annotator <em>Annotator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Annotator
	 * @generated
	 */
	public Adapter createAnnotatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.AnnotationResult <em>Annotation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.AnnotationResult
	 * @generated
	 */
	public Adapter createAnnotationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.SemanticType <em>Semantic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.SemanticType
	 * @generated
	 */
	public Adapter createSemanticTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.DiscoveryResult <em>Discovery Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.DiscoveryResult
	 * @generated
	 */
	public Adapter createDiscoveryResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.SemanticTypeMapping <em>Semantic Type Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.SemanticTypeMapping
	 * @generated
	 */
	public Adapter createSemanticTypeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Vector <em>Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Vector
	 * @generated
	 */
	public Adapter createVectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Similarity <em>Similarity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Similarity
	 * @generated
	 */
	public Adapter createSimilarityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.IOMapping <em>IO Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.IOMapping
	 * @generated
	 */
	public Adapter createIOMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.UniqueElement <em>Unique Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.UniqueElement
	 * @generated
	 */
	public Adapter createUniqueElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Ranking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Ranking
	 * @generated
	 */
	public Adapter createRankingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.MatchingResult <em>Matching Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.MatchingResult
	 * @generated
	 */
	public Adapter createMatchingResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.Confirmation <em>Confirmation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.Confirmation
	 * @generated
	 */
	public Adapter createConfirmationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.upb.dbis.baas.OperationMapping <em>Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.upb.dbis.baas.OperationMapping
	 * @generated
	 */
	public Adapter createOperationMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BaasAdapterFactory
