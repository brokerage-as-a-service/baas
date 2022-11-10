/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaasFactoryImpl extends EFactoryImpl implements BaasFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BaasFactory init() {
		try {
			BaasFactory theBaasFactory = (BaasFactory)EPackage.Registry.INSTANCE.getEFactory(BaasPackage.eNS_URI);
			if (theBaasFactory != null) {
				return theBaasFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BaasFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaasFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BaasPackage.USER: return createUser();
			case BaasPackage.COMPOSITION: return createComposition();
			case BaasPackage.SPECIFICATION: return createSpecification();
			case BaasPackage.OPERATION: return createOperation();
			case BaasPackage.IO: return createIO();
			case BaasPackage.ANNOTATOR: return createAnnotator();
			case BaasPackage.ANNOTATION_RESULT: return createAnnotationResult();
			case BaasPackage.SEMANTIC_TYPE: return createSemanticType();
			case BaasPackage.DISCOVERY_RESULT: return createDiscoveryResult();
			case BaasPackage.SEMANTIC_TYPE_MAPPING: return createSemanticTypeMapping();
			case BaasPackage.VECTOR: return createVector();
			case BaasPackage.SIMILARITY: return createSimilarity();
			case BaasPackage.IO_MAPPING: return createIOMapping();
			case BaasPackage.MATCHING_RESULT: return createMatchingResult();
			case BaasPackage.CONFIRMATION: return createConfirmation();
			case BaasPackage.OPERATION_MAPPING: return createOperationMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composition createComposition() {
		CompositionImpl composition = new CompositionImpl();
		return composition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification createSpecification() {
		SpecificationImpl specification = new SpecificationImpl();
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IO createIO() {
		IOImpl io = new IOImpl();
		return io;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotator createAnnotator() {
		AnnotatorImpl annotator = new AnnotatorImpl();
		return annotator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationResult createAnnotationResult() {
		AnnotationResultImpl annotationResult = new AnnotationResultImpl();
		return annotationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticType createSemanticType() {
		SemanticTypeImpl semanticType = new SemanticTypeImpl();
		return semanticType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiscoveryResult createDiscoveryResult() {
		DiscoveryResultImpl discoveryResult = new DiscoveryResultImpl();
		return discoveryResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticTypeMapping createSemanticTypeMapping() {
		SemanticTypeMappingImpl semanticTypeMapping = new SemanticTypeMappingImpl();
		return semanticTypeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector createVector() {
		VectorImpl vector = new VectorImpl();
		return vector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Similarity createSimilarity() {
		SimilarityImpl similarity = new SimilarityImpl();
		return similarity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOMapping createIOMapping() {
		IOMappingImpl ioMapping = new IOMappingImpl();
		return ioMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchingResult createMatchingResult() {
		MatchingResultImpl matchingResult = new MatchingResultImpl();
		return matchingResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Confirmation createConfirmation() {
		ConfirmationImpl confirmation = new ConfirmationImpl();
		return confirmation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationMapping createOperationMapping() {
		OperationMappingImpl operationMapping = new OperationMappingImpl();
		return operationMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaasPackage getBaasPackage() {
		return (BaasPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BaasPackage getPackage() {
		return BaasPackage.eINSTANCE;
	}

} //BaasFactoryImpl
