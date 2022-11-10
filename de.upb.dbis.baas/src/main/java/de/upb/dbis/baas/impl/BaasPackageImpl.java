/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.AnnotationResult;
import de.upb.dbis.baas.Annotator;
import de.upb.dbis.baas.BaasFactory;
import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.Composition;
import de.upb.dbis.baas.Confirmation;
import de.upb.dbis.baas.DiscoveryResult;
import de.upb.dbis.baas.IOMapping;
import de.upb.dbis.baas.Mapping;
import de.upb.dbis.baas.MatchingResult;
import de.upb.dbis.baas.Operation;
import de.upb.dbis.baas.OperationMapping;
import de.upb.dbis.baas.Ranking;
import de.upb.dbis.baas.SemanticType;
import de.upb.dbis.baas.SemanticTypeMapping;
import de.upb.dbis.baas.Similarity;
import de.upb.dbis.baas.Specification;
import de.upb.dbis.baas.UniqueElement;
import de.upb.dbis.baas.User;
import de.upb.dbis.baas.Vector;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaasPackageImpl extends EPackageImpl implements BaasPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discoveryResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticTypeMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass similarityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ioMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rankingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchingResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass confirmationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationMappingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.upb.dbis.baas.BaasPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BaasPackageImpl() {
		super(eNS_URI, BaasFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link BaasPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BaasPackage init() {
		if (isInited) return (BaasPackage)EPackage.Registry.INSTANCE.getEPackage(BaasPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBaasPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BaasPackageImpl theBaasPackage = registeredBaasPackage instanceof BaasPackageImpl ? (BaasPackageImpl)registeredBaasPackage : new BaasPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theBaasPackage.createPackageContents();

		// Initialize created meta-data
		theBaasPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBaasPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BaasPackage.eNS_URI, theBaasPackage);
		return theBaasPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Compositions() {
		return (EReference)userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Specifications() {
		return (EReference)userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_LastName() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComposition() {
		return compositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComposition_Name() {
		return (EAttribute)compositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposition_Operations() {
		return (EReference)compositionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComposition__SearchOperation__String() {
		return compositionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComposition__AddOperation__Operation() {
		return compositionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComposition__AddMapping__IO_IO() {
		return compositionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComposition__MatchOperations() {
		return compositionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComposition__Generate() {
		return compositionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecification() {
		return specificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecification_Operations() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecification_Name() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecification_RawSpecification() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecification_Description() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecification_Host() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Ios() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Specification() {
		return (EReference)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_OperationId() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Description() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Summary() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_ResponseCode() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Method() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Path() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIO() {
		return ioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Name() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIO_Operation() {
		return (EReference)ioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Description() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Type() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Format() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_JsonPath() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Values() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Datatype() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIO_Default() {
		return (EAttribute)ioEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIO_SemanticTypes() {
		return (EReference)ioEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIO_Subject() {
		return (EReference)ioEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIO_Predicate() {
		return (EReference)ioEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIO_Object() {
		return (EReference)ioEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotator() {
		return annotatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnnotator__SearchSemanticType__IO() {
		return annotatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnnotator__Add__IO_SemanticType() {
		return annotatorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationResult() {
		return annotationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticType() {
		return semanticTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticType_Label() {
		return (EAttribute)semanticTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticType_Uri() {
		return (EAttribute)semanticTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticType_Comment() {
		return (EAttribute)semanticTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscoveryResult() {
		return discoveryResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscoveryResult_Query() {
		return (EAttribute)discoveryResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscoveryResult_Name() {
		return (EAttribute)discoveryResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticTypeMapping() {
		return semanticTypeMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticTypeMapping_Semantictype() {
		return (EReference)semanticTypeMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticTypeMapping_Io() {
		return (EReference)semanticTypeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVector() {
		return vectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVector_Similarities() {
		return (EReference)vectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVector__Length() {
		return vectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVector__Average() {
		return vectorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimilarity() {
		return similarityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimilarity_Name() {
		return (EAttribute)similarityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimilarity_Sigma() {
		return (EAttribute)similarityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOMapping() {
		return ioMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIOMapping_Vector() {
		return (EReference)ioMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIOMapping_Left() {
		return (EReference)ioMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIOMapping_Right() {
		return (EReference)ioMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Score() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Confirmation() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Relevance() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueElement() {
		return uniqueElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUniqueElement_Uuid() {
		return (EAttribute)uniqueElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRanking() {
		return rankingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRanking_Mappings() {
		return (EReference)rankingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRanking__AveragePrecision__int() {
		return rankingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchingResult() {
		return matchingResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfirmation() {
		return confirmationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfirmation_User() {
		return (EReference)confirmationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfirmation_Datetime() {
		return (EAttribute)confirmationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationMapping() {
		return operationMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationMapping_Operation() {
		return (EReference)operationMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaasFactory getBaasFactory() {
		return (BaasFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		userEClass = createEClass(USER);
		createEReference(userEClass, USER__COMPOSITIONS);
		createEReference(userEClass, USER__SPECIFICATIONS);
		createEAttribute(userEClass, USER__LAST_NAME);

		compositionEClass = createEClass(COMPOSITION);
		createEAttribute(compositionEClass, COMPOSITION__NAME);
		createEReference(compositionEClass, COMPOSITION__OPERATIONS);
		createEOperation(compositionEClass, COMPOSITION___SEARCH_OPERATION__STRING);
		createEOperation(compositionEClass, COMPOSITION___ADD_OPERATION__OPERATION);
		createEOperation(compositionEClass, COMPOSITION___ADD_MAPPING__IO_IO);
		createEOperation(compositionEClass, COMPOSITION___MATCH_OPERATIONS);
		createEOperation(compositionEClass, COMPOSITION___GENERATE);

		specificationEClass = createEClass(SPECIFICATION);
		createEReference(specificationEClass, SPECIFICATION__OPERATIONS);
		createEAttribute(specificationEClass, SPECIFICATION__NAME);
		createEAttribute(specificationEClass, SPECIFICATION__RAW_SPECIFICATION);
		createEAttribute(specificationEClass, SPECIFICATION__DESCRIPTION);
		createEAttribute(specificationEClass, SPECIFICATION__HOST);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__IOS);
		createEReference(operationEClass, OPERATION__SPECIFICATION);
		createEAttribute(operationEClass, OPERATION__OPERATION_ID);
		createEAttribute(operationEClass, OPERATION__DESCRIPTION);
		createEAttribute(operationEClass, OPERATION__SUMMARY);
		createEAttribute(operationEClass, OPERATION__RESPONSE_CODE);
		createEAttribute(operationEClass, OPERATION__METHOD);
		createEAttribute(operationEClass, OPERATION__PATH);

		ioEClass = createEClass(IO);
		createEAttribute(ioEClass, IO__NAME);
		createEReference(ioEClass, IO__OPERATION);
		createEAttribute(ioEClass, IO__DESCRIPTION);
		createEAttribute(ioEClass, IO__TYPE);
		createEAttribute(ioEClass, IO__FORMAT);
		createEAttribute(ioEClass, IO__JSON_PATH);
		createEAttribute(ioEClass, IO__VALUES);
		createEAttribute(ioEClass, IO__DATATYPE);
		createEAttribute(ioEClass, IO__DEFAULT);
		createEReference(ioEClass, IO__SEMANTIC_TYPES);
		createEReference(ioEClass, IO__SUBJECT);
		createEReference(ioEClass, IO__PREDICATE);
		createEReference(ioEClass, IO__OBJECT);

		annotatorEClass = createEClass(ANNOTATOR);
		createEOperation(annotatorEClass, ANNOTATOR___SEARCH_SEMANTIC_TYPE__IO);
		createEOperation(annotatorEClass, ANNOTATOR___ADD__IO_SEMANTICTYPE);

		annotationResultEClass = createEClass(ANNOTATION_RESULT);

		semanticTypeEClass = createEClass(SEMANTIC_TYPE);
		createEAttribute(semanticTypeEClass, SEMANTIC_TYPE__LABEL);
		createEAttribute(semanticTypeEClass, SEMANTIC_TYPE__URI);
		createEAttribute(semanticTypeEClass, SEMANTIC_TYPE__COMMENT);

		discoveryResultEClass = createEClass(DISCOVERY_RESULT);
		createEAttribute(discoveryResultEClass, DISCOVERY_RESULT__QUERY);
		createEAttribute(discoveryResultEClass, DISCOVERY_RESULT__NAME);

		semanticTypeMappingEClass = createEClass(SEMANTIC_TYPE_MAPPING);
		createEReference(semanticTypeMappingEClass, SEMANTIC_TYPE_MAPPING__SEMANTICTYPE);
		createEReference(semanticTypeMappingEClass, SEMANTIC_TYPE_MAPPING__IO);

		vectorEClass = createEClass(VECTOR);
		createEReference(vectorEClass, VECTOR__SIMILARITIES);
		createEOperation(vectorEClass, VECTOR___LENGTH);
		createEOperation(vectorEClass, VECTOR___AVERAGE);

		similarityEClass = createEClass(SIMILARITY);
		createEAttribute(similarityEClass, SIMILARITY__NAME);
		createEAttribute(similarityEClass, SIMILARITY__SIGMA);

		ioMappingEClass = createEClass(IO_MAPPING);
		createEReference(ioMappingEClass, IO_MAPPING__VECTOR);
		createEReference(ioMappingEClass, IO_MAPPING__LEFT);
		createEReference(ioMappingEClass, IO_MAPPING__RIGHT);

		mappingEClass = createEClass(MAPPING);
		createEAttribute(mappingEClass, MAPPING__SCORE);
		createEReference(mappingEClass, MAPPING__CONFIRMATION);
		createEAttribute(mappingEClass, MAPPING__RELEVANCE);

		uniqueElementEClass = createEClass(UNIQUE_ELEMENT);
		createEAttribute(uniqueElementEClass, UNIQUE_ELEMENT__UUID);

		rankingEClass = createEClass(RANKING);
		createEReference(rankingEClass, RANKING__MAPPINGS);
		createEOperation(rankingEClass, RANKING___AVERAGE_PRECISION__INT);

		matchingResultEClass = createEClass(MATCHING_RESULT);

		confirmationEClass = createEClass(CONFIRMATION);
		createEReference(confirmationEClass, CONFIRMATION__USER);
		createEAttribute(confirmationEClass, CONFIRMATION__DATETIME);

		operationMappingEClass = createEClass(OPERATION_MAPPING);
		createEReference(operationMappingEClass, OPERATION_MAPPING__OPERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userEClass.getESuperTypes().add(this.getUniqueElement());
		compositionEClass.getESuperTypes().add(this.getUniqueElement());
		specificationEClass.getESuperTypes().add(this.getUniqueElement());
		operationEClass.getESuperTypes().add(this.getUniqueElement());
		ioEClass.getESuperTypes().add(this.getUniqueElement());
		annotationResultEClass.getESuperTypes().add(this.getRanking());
		discoveryResultEClass.getESuperTypes().add(this.getRanking());
		discoveryResultEClass.getESuperTypes().add(this.getUniqueElement());
		semanticTypeMappingEClass.getESuperTypes().add(this.getMapping());
		ioMappingEClass.getESuperTypes().add(this.getMapping());
		mappingEClass.getESuperTypes().add(this.getUniqueElement());
		matchingResultEClass.getESuperTypes().add(this.getRanking());
		confirmationEClass.getESuperTypes().add(this.getUniqueElement());
		operationMappingEClass.getESuperTypes().add(this.getMapping());

		// Initialize classes, features, and operations; add parameters
		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUser_Compositions(), this.getComposition(), null, "compositions", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Specifications(), this.getSpecification(), null, "specifications", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositionEClass, Composition.class, "Composition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComposition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Composition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComposition_Operations(), this.getOperation(), null, "operations", null, 0, -1, Composition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getComposition__SearchOperation__String(), this.getDiscoveryResult(), "searchOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "query", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComposition__AddOperation__Operation(), null, "addOperation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperation(), "operation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComposition__AddMapping__IO_IO(), null, "addMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIO(), "left", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIO(), "right", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComposition__MatchOperations(), this.getIOMapping(), "matchOperations", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComposition__Generate(), ecorePackage.getEString(), "generate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecification_Operations(), this.getOperation(), this.getOperation_Specification(), "operations", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_RawSpecification(), ecorePackage.getEString(), "rawSpecification", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_Description(), ecorePackage.getEString(), "description", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_Host(), ecorePackage.getEString(), "host", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Ios(), this.getIO(), this.getIO_Operation(), "ios", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_Specification(), this.getSpecification(), this.getSpecification_Operations(), "specification", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_OperationId(), ecorePackage.getEString(), "operationId", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Description(), ecorePackage.getEString(), "description", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Summary(), ecorePackage.getEString(), "summary", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_ResponseCode(), ecorePackage.getEString(), "responseCode", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Method(), ecorePackage.getEString(), "method", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Path(), ecorePackage.getEString(), "path", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ioEClass, de.upb.dbis.baas.IO.class, "IO", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIO_Name(), ecorePackage.getEString(), "name", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIO_Operation(), this.getOperation(), this.getOperation_Ios(), "operation", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIO_Description(), ecorePackage.getEString(), "description", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIO_Type(), ecorePackage.getEString(), "type", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIO_Format(), ecorePackage.getEString(), "format", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIO_JsonPath(), ecorePackage.getEString(), "jsonPath", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIO_Values(), ecorePackage.getEJavaObject(), "values", null, 0, -1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIO_Datatype(), ecorePackage.getEString(), "datatype", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIO_Default(), ecorePackage.getEString(), "default", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIO_SemanticTypes(), this.getSemanticType(), null, "semanticTypes", null, 0, -1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIO_Subject(), this.getSemanticType(), null, "subject", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIO_Predicate(), this.getSemanticType(), null, "predicate", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIO_Object(), this.getSemanticType(), null, "object", null, 0, 1, de.upb.dbis.baas.IO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotatorEClass, Annotator.class, "Annotator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAnnotator__SearchSemanticType__IO(), this.getAnnotationResult(), "searchSemanticType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIO(), "io", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAnnotator__Add__IO_SemanticType(), null, "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIO(), "io", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(annotationResultEClass, AnnotationResult.class, "AnnotationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(semanticTypeEClass, SemanticType.class, "SemanticType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSemanticType_Label(), ecorePackage.getEString(), "label", null, 0, 1, SemanticType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticType_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, SemanticType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticType_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, SemanticType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(discoveryResultEClass, DiscoveryResult.class, "DiscoveryResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscoveryResult_Query(), ecorePackage.getEString(), "query", null, 0, 1, DiscoveryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiscoveryResult_Name(), ecorePackage.getEString(), "name", null, 0, 1, DiscoveryResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semanticTypeMappingEClass, SemanticTypeMapping.class, "SemanticTypeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticTypeMapping_Semantictype(), this.getSemanticType(), null, "semantictype", null, 0, 1, SemanticTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticTypeMapping_Io(), this.getIO(), null, "io", null, 0, 1, SemanticTypeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vectorEClass, Vector.class, "Vector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVector_Similarities(), this.getSimilarity(), null, "similarities", null, 0, -1, Vector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getVector__Length(), ecorePackage.getEDouble(), "length", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getVector__Average(), ecorePackage.getEDouble(), "average", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(similarityEClass, Similarity.class, "Similarity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimilarity_Name(), ecorePackage.getEString(), "name", null, 0, 1, Similarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimilarity_Sigma(), ecorePackage.getEDouble(), "sigma", null, 0, 1, Similarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ioMappingEClass, IOMapping.class, "IOMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIOMapping_Vector(), this.getVector(), null, "vector", null, 0, 1, IOMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIOMapping_Left(), this.getIO(), null, "left", null, 0, 1, IOMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIOMapping_Right(), this.getIO(), null, "right", null, 0, 1, IOMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapping_Score(), ecorePackage.getEDouble(), "score", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_Confirmation(), this.getConfirmation(), null, "confirmation", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_Relevance(), ecorePackage.getEDouble(), "relevance", "-1.0", 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uniqueElementEClass, UniqueElement.class, "UniqueElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUniqueElement_Uuid(), ecorePackage.getEString(), "uuid", null, 0, 1, UniqueElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rankingEClass, Ranking.class, "Ranking", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRanking_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, Ranking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRanking__AveragePrecision__int(), ecorePackage.getEDouble(), "averagePrecision", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "correct", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(matchingResultEClass, MatchingResult.class, "MatchingResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(confirmationEClass, Confirmation.class, "Confirmation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfirmation_User(), this.getUser(), null, "user", null, 0, 1, Confirmation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfirmation_Datetime(), ecorePackage.getEDate(), "datetime", null, 0, 1, Confirmation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationMappingEClass, OperationMapping.class, "OperationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationMapping_Operation(), this.getOperation(), null, "operation", null, 0, 1, OperationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BaasPackageImpl
