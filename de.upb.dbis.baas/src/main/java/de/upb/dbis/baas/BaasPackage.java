/**
 */
package de.upb.dbis.baas;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.upb.dbis.baas.BaasFactory
 * @model kind="package"
 * @generated
 */
public interface BaasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "baas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "baas";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaasPackage eINSTANCE = de.upb.dbis.baas.impl.BaasPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.UniqueElement <em>Unique Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.UniqueElement
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getUniqueElement()
	 * @generated
	 */
	int UNIQUE_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_ELEMENT__UUID = 0;

	/**
	 * The number of structural features of the '<em>Unique Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Unique Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.UserImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Compositions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__COMPOSITIONS = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__SPECIFICATIONS = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LAST_NAME = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.CompositionImpl <em>Composition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.CompositionImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getComposition()
	 * @generated
	 */
	int COMPOSITION = 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__NAME = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION__OPERATIONS = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Search Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION___SEARCH_OPERATION__STRING = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION___ADD_OPERATION__OPERATION = UNIQUE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Add Mapping</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION___ADD_MAPPING__IO_IO = UNIQUE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Match Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION___MATCH_OPERATIONS = UNIQUE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION___GENERATE = UNIQUE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Composition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.SpecificationImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__OPERATIONS = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__NAME = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Raw Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__RAW_SPECIFICATION = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__DESCRIPTION = UNIQUE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__HOST = UNIQUE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.OperationImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Ios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IOS = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SPECIFICATION = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OPERATION_ID = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DESCRIPTION = UNIQUE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Summary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SUMMARY = UNIQUE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Response Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RESPONSE_CODE = UNIQUE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__METHOD = UNIQUE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PATH = UNIQUE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.IOImpl <em>IO</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.IOImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getIO()
	 * @generated
	 */
	int IO = 4;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__NAME = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__OPERATION = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__DESCRIPTION = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__TYPE = UNIQUE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__FORMAT = UNIQUE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Json Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__JSON_PATH = UNIQUE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__VALUES = UNIQUE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__DATATYPE = UNIQUE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__DEFAULT = UNIQUE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Semantic Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__SEMANTIC_TYPES = UNIQUE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__SUBJECT = UNIQUE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__PREDICATE = UNIQUE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO__OBJECT = UNIQUE_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>IO</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>IO</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.AnnotatorImpl <em>Annotator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.AnnotatorImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getAnnotator()
	 * @generated
	 */
	int ANNOTATOR = 5;

	/**
	 * The number of structural features of the '<em>Annotator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATOR_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Search Semantic Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATOR___SEARCH_SEMANTIC_TYPE__IO = 0;

	/**
	 * The operation id for the '<em>Add</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATOR___ADD__IO_SEMANTICTYPE = 1;

	/**
	 * The number of operations of the '<em>Annotator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATOR_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.RankingImpl <em>Ranking</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.RankingImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getRanking()
	 * @generated
	 */
	int RANKING = 15;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING__MAPPINGS = 0;

	/**
	 * The number of structural features of the '<em>Ranking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Average Precision</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING___AVERAGE_PRECISION__INT = 0;

	/**
	 * The number of operations of the '<em>Ranking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.AnnotationResultImpl <em>Annotation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.AnnotationResultImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getAnnotationResult()
	 * @generated
	 */
	int ANNOTATION_RESULT = 6;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_RESULT__MAPPINGS = RANKING__MAPPINGS;

	/**
	 * The number of structural features of the '<em>Annotation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_RESULT_FEATURE_COUNT = RANKING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Average Precision</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_RESULT___AVERAGE_PRECISION__INT = RANKING___AVERAGE_PRECISION__INT;

	/**
	 * The number of operations of the '<em>Annotation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_RESULT_OPERATION_COUNT = RANKING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.SemanticTypeImpl <em>Semantic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.SemanticTypeImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSemanticType()
	 * @generated
	 */
	int SEMANTIC_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE__URI = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE__COMMENT = 2;

	/**
	 * The number of structural features of the '<em>Semantic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Semantic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.DiscoveryResultImpl <em>Discovery Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.DiscoveryResultImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getDiscoveryResult()
	 * @generated
	 */
	int DISCOVERY_RESULT = 8;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT__MAPPINGS = RANKING__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT__UUID = RANKING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT__QUERY = RANKING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT__NAME = RANKING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Discovery Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT_FEATURE_COUNT = RANKING_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Average Precision</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT___AVERAGE_PRECISION__INT = RANKING___AVERAGE_PRECISION__INT;

	/**
	 * The number of operations of the '<em>Discovery Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCOVERY_RESULT_OPERATION_COUNT = RANKING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.Mapping <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.Mapping
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 13;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SCORE = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Confirmation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONFIRMATION = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__RELEVANCE = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl <em>Semantic Type Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.SemanticTypeMappingImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSemanticTypeMapping()
	 * @generated
	 */
	int SEMANTIC_TYPE_MAPPING = 9;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING__UUID = MAPPING__UUID;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING__SCORE = MAPPING__SCORE;

	/**
	 * The feature id for the '<em><b>Confirmation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING__CONFIRMATION = MAPPING__CONFIRMATION;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING__RELEVANCE = MAPPING__RELEVANCE;

	/**
	 * The feature id for the '<em><b>Semantictype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING__SEMANTICTYPE = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Io</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING__IO = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Semantic Type Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Semantic Type Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_TYPE_MAPPING_OPERATION_COUNT = MAPPING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.VectorImpl <em>Vector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.VectorImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getVector()
	 * @generated
	 */
	int VECTOR = 10;

	/**
	 * The feature id for the '<em><b>Similarities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR__SIMILARITIES = 0;

	/**
	 * The number of structural features of the '<em>Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Length</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR___LENGTH = 0;

	/**
	 * The operation id for the '<em>Average</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR___AVERAGE = 1;

	/**
	 * The number of operations of the '<em>Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.SimilarityImpl <em>Similarity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.SimilarityImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSimilarity()
	 * @generated
	 */
	int SIMILARITY = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMILARITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Sigma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMILARITY__SIGMA = 1;

	/**
	 * The number of structural features of the '<em>Similarity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMILARITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Similarity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMILARITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.IOMappingImpl <em>IO Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.IOMappingImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getIOMapping()
	 * @generated
	 */
	int IO_MAPPING = 12;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__UUID = MAPPING__UUID;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__SCORE = MAPPING__SCORE;

	/**
	 * The feature id for the '<em><b>Confirmation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__CONFIRMATION = MAPPING__CONFIRMATION;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__RELEVANCE = MAPPING__RELEVANCE;

	/**
	 * The feature id for the '<em><b>Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__VECTOR = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__LEFT = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING__RIGHT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IO Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>IO Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_MAPPING_OPERATION_COUNT = MAPPING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.MatchingResultImpl <em>Matching Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.MatchingResultImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getMatchingResult()
	 * @generated
	 */
	int MATCHING_RESULT = 16;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_RESULT__MAPPINGS = RANKING__MAPPINGS;

	/**
	 * The number of structural features of the '<em>Matching Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_RESULT_FEATURE_COUNT = RANKING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Average Precision</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_RESULT___AVERAGE_PRECISION__INT = RANKING___AVERAGE_PRECISION__INT;

	/**
	 * The number of operations of the '<em>Matching Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHING_RESULT_OPERATION_COUNT = RANKING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.ConfirmationImpl <em>Confirmation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.ConfirmationImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getConfirmation()
	 * @generated
	 */
	int CONFIRMATION = 17;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIRMATION__UUID = UNIQUE_ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIRMATION__USER = UNIQUE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Datetime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIRMATION__DATETIME = UNIQUE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Confirmation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIRMATION_FEATURE_COUNT = UNIQUE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Confirmation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIRMATION_OPERATION_COUNT = UNIQUE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.upb.dbis.baas.impl.OperationMappingImpl <em>Operation Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.upb.dbis.baas.impl.OperationMappingImpl
	 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getOperationMapping()
	 * @generated
	 */
	int OPERATION_MAPPING = 18;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING__UUID = MAPPING__UUID;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING__SCORE = MAPPING__SCORE;

	/**
	 * The feature id for the '<em><b>Confirmation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING__CONFIRMATION = MAPPING__CONFIRMATION;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING__RELEVANCE = MAPPING__RELEVANCE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING__OPERATION = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operation Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_MAPPING_OPERATION_COUNT = MAPPING_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see de.upb.dbis.baas.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the reference list '{@link de.upb.dbis.baas.User#getCompositions <em>Compositions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Compositions</em>'.
	 * @see de.upb.dbis.baas.User#getCompositions()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Compositions();

	/**
	 * Returns the meta object for the reference list '{@link de.upb.dbis.baas.User#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specifications</em>'.
	 * @see de.upb.dbis.baas.User#getSpecifications()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Specifications();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.User#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see de.upb.dbis.baas.User#getLastName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_LastName();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Composition <em>Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition</em>'.
	 * @see de.upb.dbis.baas.Composition
	 * @generated
	 */
	EClass getComposition();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Composition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.upb.dbis.baas.Composition#getName()
	 * @see #getComposition()
	 * @generated
	 */
	EAttribute getComposition_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.upb.dbis.baas.Composition#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see de.upb.dbis.baas.Composition#getOperations()
	 * @see #getComposition()
	 * @generated
	 */
	EReference getComposition_Operations();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Composition#searchOperation(java.lang.String) <em>Search Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search Operation</em>' operation.
	 * @see de.upb.dbis.baas.Composition#searchOperation(java.lang.String)
	 * @generated
	 */
	EOperation getComposition__SearchOperation__String();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Composition#addOperation(de.upb.dbis.baas.Operation) <em>Add Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Operation</em>' operation.
	 * @see de.upb.dbis.baas.Composition#addOperation(de.upb.dbis.baas.Operation)
	 * @generated
	 */
	EOperation getComposition__AddOperation__Operation();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Composition#addMapping(de.upb.dbis.baas.IO, de.upb.dbis.baas.IO) <em>Add Mapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Mapping</em>' operation.
	 * @see de.upb.dbis.baas.Composition#addMapping(de.upb.dbis.baas.IO, de.upb.dbis.baas.IO)
	 * @generated
	 */
	EOperation getComposition__AddMapping__IO_IO();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Composition#matchOperations() <em>Match Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Match Operations</em>' operation.
	 * @see de.upb.dbis.baas.Composition#matchOperations()
	 * @generated
	 */
	EOperation getComposition__MatchOperations();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Composition#generate() <em>Generate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate</em>' operation.
	 * @see de.upb.dbis.baas.Composition#generate()
	 * @generated
	 */
	EOperation getComposition__Generate();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see de.upb.dbis.baas.Specification
	 * @generated
	 */
	EClass getSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link de.upb.dbis.baas.Specification#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see de.upb.dbis.baas.Specification#getOperations()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Operations();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Specification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.upb.dbis.baas.Specification#getName()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Specification#getRawSpecification <em>Raw Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Specification</em>'.
	 * @see de.upb.dbis.baas.Specification#getRawSpecification()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_RawSpecification();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Specification#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.upb.dbis.baas.Specification#getDescription()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Specification#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see de.upb.dbis.baas.Specification#getHost()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_Host();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see de.upb.dbis.baas.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.upb.dbis.baas.Operation#getIos <em>Ios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ios</em>'.
	 * @see de.upb.dbis.baas.Operation#getIos()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Ios();

	/**
	 * Returns the meta object for the container reference '{@link de.upb.dbis.baas.Operation#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specification</em>'.
	 * @see de.upb.dbis.baas.Operation#getSpecification()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Specification();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Operation#getOperationId <em>Operation Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Id</em>'.
	 * @see de.upb.dbis.baas.Operation#getOperationId()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_OperationId();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Operation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.upb.dbis.baas.Operation#getDescription()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Operation#getSummary <em>Summary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Summary</em>'.
	 * @see de.upb.dbis.baas.Operation#getSummary()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Summary();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Operation#getResponseCode <em>Response Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Code</em>'.
	 * @see de.upb.dbis.baas.Operation#getResponseCode()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_ResponseCode();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Operation#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see de.upb.dbis.baas.Operation#getMethod()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Method();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Operation#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see de.upb.dbis.baas.Operation#getPath()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Path();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.IO <em>IO</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IO</em>'.
	 * @see de.upb.dbis.baas.IO
	 * @generated
	 */
	EClass getIO();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.upb.dbis.baas.IO#getName()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Name();

	/**
	 * Returns the meta object for the container reference '{@link de.upb.dbis.baas.IO#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see de.upb.dbis.baas.IO#getOperation()
	 * @see #getIO()
	 * @generated
	 */
	EReference getIO_Operation();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.upb.dbis.baas.IO#getDescription()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.upb.dbis.baas.IO#getType()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see de.upb.dbis.baas.IO#getFormat()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Format();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getJsonPath <em>Json Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Json Path</em>'.
	 * @see de.upb.dbis.baas.IO#getJsonPath()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_JsonPath();

	/**
	 * Returns the meta object for the attribute list '{@link de.upb.dbis.baas.IO#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see de.upb.dbis.baas.IO#getValues()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Values();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Datatype</em>'.
	 * @see de.upb.dbis.baas.IO#getDatatype()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Datatype();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.IO#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see de.upb.dbis.baas.IO#getDefault()
	 * @see #getIO()
	 * @generated
	 */
	EAttribute getIO_Default();

	/**
	 * Returns the meta object for the reference list '{@link de.upb.dbis.baas.IO#getSemanticTypes <em>Semantic Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Semantic Types</em>'.
	 * @see de.upb.dbis.baas.IO#getSemanticTypes()
	 * @see #getIO()
	 * @generated
	 */
	EReference getIO_SemanticTypes();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.IO#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subject</em>'.
	 * @see de.upb.dbis.baas.IO#getSubject()
	 * @see #getIO()
	 * @generated
	 */
	EReference getIO_Subject();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.IO#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see de.upb.dbis.baas.IO#getPredicate()
	 * @see #getIO()
	 * @generated
	 */
	EReference getIO_Predicate();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.IO#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see de.upb.dbis.baas.IO#getObject()
	 * @see #getIO()
	 * @generated
	 */
	EReference getIO_Object();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Annotator <em>Annotator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotator</em>'.
	 * @see de.upb.dbis.baas.Annotator
	 * @generated
	 */
	EClass getAnnotator();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Annotator#searchSemanticType(de.upb.dbis.baas.IO) <em>Search Semantic Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search Semantic Type</em>' operation.
	 * @see de.upb.dbis.baas.Annotator#searchSemanticType(de.upb.dbis.baas.IO)
	 * @generated
	 */
	EOperation getAnnotator__SearchSemanticType__IO();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Annotator#add(de.upb.dbis.baas.IO, de.upb.dbis.baas.SemanticType) <em>Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add</em>' operation.
	 * @see de.upb.dbis.baas.Annotator#add(de.upb.dbis.baas.IO, de.upb.dbis.baas.SemanticType)
	 * @generated
	 */
	EOperation getAnnotator__Add__IO_SemanticType();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.AnnotationResult <em>Annotation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Result</em>'.
	 * @see de.upb.dbis.baas.AnnotationResult
	 * @generated
	 */
	EClass getAnnotationResult();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.SemanticType <em>Semantic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Type</em>'.
	 * @see de.upb.dbis.baas.SemanticType
	 * @generated
	 */
	EClass getSemanticType();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.SemanticType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see de.upb.dbis.baas.SemanticType#getLabel()
	 * @see #getSemanticType()
	 * @generated
	 */
	EAttribute getSemanticType_Label();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.SemanticType#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see de.upb.dbis.baas.SemanticType#getUri()
	 * @see #getSemanticType()
	 * @generated
	 */
	EAttribute getSemanticType_Uri();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.SemanticType#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see de.upb.dbis.baas.SemanticType#getComment()
	 * @see #getSemanticType()
	 * @generated
	 */
	EAttribute getSemanticType_Comment();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.DiscoveryResult <em>Discovery Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discovery Result</em>'.
	 * @see de.upb.dbis.baas.DiscoveryResult
	 * @generated
	 */
	EClass getDiscoveryResult();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.DiscoveryResult#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see de.upb.dbis.baas.DiscoveryResult#getQuery()
	 * @see #getDiscoveryResult()
	 * @generated
	 */
	EAttribute getDiscoveryResult_Query();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.DiscoveryResult#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.upb.dbis.baas.DiscoveryResult#getName()
	 * @see #getDiscoveryResult()
	 * @generated
	 */
	EAttribute getDiscoveryResult_Name();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.SemanticTypeMapping <em>Semantic Type Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Type Mapping</em>'.
	 * @see de.upb.dbis.baas.SemanticTypeMapping
	 * @generated
	 */
	EClass getSemanticTypeMapping();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.SemanticTypeMapping#getSemantictype <em>Semantictype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Semantictype</em>'.
	 * @see de.upb.dbis.baas.SemanticTypeMapping#getSemantictype()
	 * @see #getSemanticTypeMapping()
	 * @generated
	 */
	EReference getSemanticTypeMapping_Semantictype();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.SemanticTypeMapping#getIo <em>Io</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Io</em>'.
	 * @see de.upb.dbis.baas.SemanticTypeMapping#getIo()
	 * @see #getSemanticTypeMapping()
	 * @generated
	 */
	EReference getSemanticTypeMapping_Io();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Vector <em>Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vector</em>'.
	 * @see de.upb.dbis.baas.Vector
	 * @generated
	 */
	EClass getVector();

	/**
	 * Returns the meta object for the containment reference list '{@link de.upb.dbis.baas.Vector#getSimilarities <em>Similarities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Similarities</em>'.
	 * @see de.upb.dbis.baas.Vector#getSimilarities()
	 * @see #getVector()
	 * @generated
	 */
	EReference getVector_Similarities();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Vector#length() <em>Length</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Length</em>' operation.
	 * @see de.upb.dbis.baas.Vector#length()
	 * @generated
	 */
	EOperation getVector__Length();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Vector#average() <em>Average</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Average</em>' operation.
	 * @see de.upb.dbis.baas.Vector#average()
	 * @generated
	 */
	EOperation getVector__Average();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Similarity <em>Similarity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Similarity</em>'.
	 * @see de.upb.dbis.baas.Similarity
	 * @generated
	 */
	EClass getSimilarity();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Similarity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.upb.dbis.baas.Similarity#getName()
	 * @see #getSimilarity()
	 * @generated
	 */
	EAttribute getSimilarity_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Similarity#getSigma <em>Sigma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sigma</em>'.
	 * @see de.upb.dbis.baas.Similarity#getSigma()
	 * @see #getSimilarity()
	 * @generated
	 */
	EAttribute getSimilarity_Sigma();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.IOMapping <em>IO Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IO Mapping</em>'.
	 * @see de.upb.dbis.baas.IOMapping
	 * @generated
	 */
	EClass getIOMapping();

	/**
	 * Returns the meta object for the containment reference '{@link de.upb.dbis.baas.IOMapping#getVector <em>Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vector</em>'.
	 * @see de.upb.dbis.baas.IOMapping#getVector()
	 * @see #getIOMapping()
	 * @generated
	 */
	EReference getIOMapping_Vector();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.IOMapping#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see de.upb.dbis.baas.IOMapping#getLeft()
	 * @see #getIOMapping()
	 * @generated
	 */
	EReference getIOMapping_Left();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.IOMapping#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see de.upb.dbis.baas.IOMapping#getRight()
	 * @see #getIOMapping()
	 * @generated
	 */
	EReference getIOMapping_Right();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.upb.dbis.baas.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Mapping#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see de.upb.dbis.baas.Mapping#getScore()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Score();

	/**
	 * Returns the meta object for the reference list '{@link de.upb.dbis.baas.Mapping#getConfirmation <em>Confirmation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Confirmation</em>'.
	 * @see de.upb.dbis.baas.Mapping#getConfirmation()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Confirmation();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Mapping#getRelevance <em>Relevance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevance</em>'.
	 * @see de.upb.dbis.baas.Mapping#getRelevance()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Relevance();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.UniqueElement <em>Unique Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Element</em>'.
	 * @see de.upb.dbis.baas.UniqueElement
	 * @generated
	 */
	EClass getUniqueElement();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.UniqueElement#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see de.upb.dbis.baas.UniqueElement#getUuid()
	 * @see #getUniqueElement()
	 * @generated
	 */
	EAttribute getUniqueElement_Uuid();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Ranking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ranking</em>'.
	 * @see de.upb.dbis.baas.Ranking
	 * @generated
	 */
	EClass getRanking();

	/**
	 * Returns the meta object for the containment reference list '{@link de.upb.dbis.baas.Ranking#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see de.upb.dbis.baas.Ranking#getMappings()
	 * @see #getRanking()
	 * @generated
	 */
	EReference getRanking_Mappings();

	/**
	 * Returns the meta object for the '{@link de.upb.dbis.baas.Ranking#averagePrecision(int) <em>Average Precision</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Average Precision</em>' operation.
	 * @see de.upb.dbis.baas.Ranking#averagePrecision(int)
	 * @generated
	 */
	EOperation getRanking__AveragePrecision__int();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.MatchingResult <em>Matching Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matching Result</em>'.
	 * @see de.upb.dbis.baas.MatchingResult
	 * @generated
	 */
	EClass getMatchingResult();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.Confirmation <em>Confirmation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Confirmation</em>'.
	 * @see de.upb.dbis.baas.Confirmation
	 * @generated
	 */
	EClass getConfirmation();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.Confirmation#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see de.upb.dbis.baas.Confirmation#getUser()
	 * @see #getConfirmation()
	 * @generated
	 */
	EReference getConfirmation_User();

	/**
	 * Returns the meta object for the attribute '{@link de.upb.dbis.baas.Confirmation#getDatetime <em>Datetime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Datetime</em>'.
	 * @see de.upb.dbis.baas.Confirmation#getDatetime()
	 * @see #getConfirmation()
	 * @generated
	 */
	EAttribute getConfirmation_Datetime();

	/**
	 * Returns the meta object for class '{@link de.upb.dbis.baas.OperationMapping <em>Operation Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Mapping</em>'.
	 * @see de.upb.dbis.baas.OperationMapping
	 * @generated
	 */
	EClass getOperationMapping();

	/**
	 * Returns the meta object for the reference '{@link de.upb.dbis.baas.OperationMapping#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see de.upb.dbis.baas.OperationMapping#getOperation()
	 * @see #getOperationMapping()
	 * @generated
	 */
	EReference getOperationMapping_Operation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaasFactory getBaasFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.UserImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Compositions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__COMPOSITIONS = eINSTANCE.getUser_Compositions();

		/**
		 * The meta object literal for the '<em><b>Specifications</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__SPECIFICATIONS = eINSTANCE.getUser_Specifications();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LAST_NAME = eINSTANCE.getUser_LastName();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.CompositionImpl <em>Composition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.CompositionImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getComposition()
		 * @generated
		 */
		EClass COMPOSITION = eINSTANCE.getComposition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITION__NAME = eINSTANCE.getComposition_Name();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION__OPERATIONS = eINSTANCE.getComposition_Operations();

		/**
		 * The meta object literal for the '<em><b>Search Operation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITION___SEARCH_OPERATION__STRING = eINSTANCE.getComposition__SearchOperation__String();

		/**
		 * The meta object literal for the '<em><b>Add Operation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITION___ADD_OPERATION__OPERATION = eINSTANCE.getComposition__AddOperation__Operation();

		/**
		 * The meta object literal for the '<em><b>Add Mapping</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITION___ADD_MAPPING__IO_IO = eINSTANCE.getComposition__AddMapping__IO_IO();

		/**
		 * The meta object literal for the '<em><b>Match Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITION___MATCH_OPERATIONS = eINSTANCE.getComposition__MatchOperations();

		/**
		 * The meta object literal for the '<em><b>Generate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITION___GENERATE = eINSTANCE.getComposition__Generate();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.SpecificationImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSpecification()
		 * @generated
		 */
		EClass SPECIFICATION = eINSTANCE.getSpecification();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__OPERATIONS = eINSTANCE.getSpecification_Operations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__NAME = eINSTANCE.getSpecification_Name();

		/**
		 * The meta object literal for the '<em><b>Raw Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__RAW_SPECIFICATION = eINSTANCE.getSpecification_RawSpecification();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__DESCRIPTION = eINSTANCE.getSpecification_Description();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__HOST = eINSTANCE.getSpecification_Host();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.OperationImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Ios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__IOS = eINSTANCE.getOperation_Ios();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__SPECIFICATION = eINSTANCE.getOperation_Specification();

		/**
		 * The meta object literal for the '<em><b>Operation Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__OPERATION_ID = eINSTANCE.getOperation_OperationId();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__DESCRIPTION = eINSTANCE.getOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Summary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__SUMMARY = eINSTANCE.getOperation_Summary();

		/**
		 * The meta object literal for the '<em><b>Response Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__RESPONSE_CODE = eINSTANCE.getOperation_ResponseCode();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__METHOD = eINSTANCE.getOperation_Method();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__PATH = eINSTANCE.getOperation_Path();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.IOImpl <em>IO</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.IOImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getIO()
		 * @generated
		 */
		EClass IO = eINSTANCE.getIO();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__NAME = eINSTANCE.getIO_Name();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO__OPERATION = eINSTANCE.getIO_Operation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__DESCRIPTION = eINSTANCE.getIO_Description();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__TYPE = eINSTANCE.getIO_Type();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__FORMAT = eINSTANCE.getIO_Format();

		/**
		 * The meta object literal for the '<em><b>Json Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__JSON_PATH = eINSTANCE.getIO_JsonPath();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__VALUES = eINSTANCE.getIO_Values();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__DATATYPE = eINSTANCE.getIO_Datatype();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO__DEFAULT = eINSTANCE.getIO_Default();

		/**
		 * The meta object literal for the '<em><b>Semantic Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO__SEMANTIC_TYPES = eINSTANCE.getIO_SemanticTypes();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO__SUBJECT = eINSTANCE.getIO_Subject();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO__PREDICATE = eINSTANCE.getIO_Predicate();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO__OBJECT = eINSTANCE.getIO_Object();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.AnnotatorImpl <em>Annotator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.AnnotatorImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getAnnotator()
		 * @generated
		 */
		EClass ANNOTATOR = eINSTANCE.getAnnotator();

		/**
		 * The meta object literal for the '<em><b>Search Semantic Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATOR___SEARCH_SEMANTIC_TYPE__IO = eINSTANCE.getAnnotator__SearchSemanticType__IO();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANNOTATOR___ADD__IO_SEMANTICTYPE = eINSTANCE.getAnnotator__Add__IO_SemanticType();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.AnnotationResultImpl <em>Annotation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.AnnotationResultImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getAnnotationResult()
		 * @generated
		 */
		EClass ANNOTATION_RESULT = eINSTANCE.getAnnotationResult();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.SemanticTypeImpl <em>Semantic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.SemanticTypeImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSemanticType()
		 * @generated
		 */
		EClass SEMANTIC_TYPE = eINSTANCE.getSemanticType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_TYPE__LABEL = eINSTANCE.getSemanticType_Label();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_TYPE__URI = eINSTANCE.getSemanticType_Uri();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_TYPE__COMMENT = eINSTANCE.getSemanticType_Comment();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.DiscoveryResultImpl <em>Discovery Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.DiscoveryResultImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getDiscoveryResult()
		 * @generated
		 */
		EClass DISCOVERY_RESULT = eINSTANCE.getDiscoveryResult();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCOVERY_RESULT__QUERY = eINSTANCE.getDiscoveryResult_Query();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCOVERY_RESULT__NAME = eINSTANCE.getDiscoveryResult_Name();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.SemanticTypeMappingImpl <em>Semantic Type Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.SemanticTypeMappingImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSemanticTypeMapping()
		 * @generated
		 */
		EClass SEMANTIC_TYPE_MAPPING = eINSTANCE.getSemanticTypeMapping();

		/**
		 * The meta object literal for the '<em><b>Semantictype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_TYPE_MAPPING__SEMANTICTYPE = eINSTANCE.getSemanticTypeMapping_Semantictype();

		/**
		 * The meta object literal for the '<em><b>Io</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_TYPE_MAPPING__IO = eINSTANCE.getSemanticTypeMapping_Io();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.VectorImpl <em>Vector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.VectorImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getVector()
		 * @generated
		 */
		EClass VECTOR = eINSTANCE.getVector();

		/**
		 * The meta object literal for the '<em><b>Similarities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VECTOR__SIMILARITIES = eINSTANCE.getVector_Similarities();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VECTOR___LENGTH = eINSTANCE.getVector__Length();

		/**
		 * The meta object literal for the '<em><b>Average</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VECTOR___AVERAGE = eINSTANCE.getVector__Average();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.SimilarityImpl <em>Similarity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.SimilarityImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getSimilarity()
		 * @generated
		 */
		EClass SIMILARITY = eINSTANCE.getSimilarity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMILARITY__NAME = eINSTANCE.getSimilarity_Name();

		/**
		 * The meta object literal for the '<em><b>Sigma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMILARITY__SIGMA = eINSTANCE.getSimilarity_Sigma();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.IOMappingImpl <em>IO Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.IOMappingImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getIOMapping()
		 * @generated
		 */
		EClass IO_MAPPING = eINSTANCE.getIOMapping();

		/**
		 * The meta object literal for the '<em><b>Vector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO_MAPPING__VECTOR = eINSTANCE.getIOMapping_Vector();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO_MAPPING__LEFT = eINSTANCE.getIOMapping_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IO_MAPPING__RIGHT = eINSTANCE.getIOMapping_Right();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.Mapping <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.Mapping
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__SCORE = eINSTANCE.getMapping_Score();

		/**
		 * The meta object literal for the '<em><b>Confirmation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CONFIRMATION = eINSTANCE.getMapping_Confirmation();

		/**
		 * The meta object literal for the '<em><b>Relevance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__RELEVANCE = eINSTANCE.getMapping_Relevance();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.UniqueElement <em>Unique Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.UniqueElement
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getUniqueElement()
		 * @generated
		 */
		EClass UNIQUE_ELEMENT = eINSTANCE.getUniqueElement();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIQUE_ELEMENT__UUID = eINSTANCE.getUniqueElement_Uuid();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.RankingImpl <em>Ranking</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.RankingImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getRanking()
		 * @generated
		 */
		EClass RANKING = eINSTANCE.getRanking();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANKING__MAPPINGS = eINSTANCE.getRanking_Mappings();

		/**
		 * The meta object literal for the '<em><b>Average Precision</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RANKING___AVERAGE_PRECISION__INT = eINSTANCE.getRanking__AveragePrecision__int();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.MatchingResultImpl <em>Matching Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.MatchingResultImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getMatchingResult()
		 * @generated
		 */
		EClass MATCHING_RESULT = eINSTANCE.getMatchingResult();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.ConfirmationImpl <em>Confirmation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.ConfirmationImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getConfirmation()
		 * @generated
		 */
		EClass CONFIRMATION = eINSTANCE.getConfirmation();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIRMATION__USER = eINSTANCE.getConfirmation_User();

		/**
		 * The meta object literal for the '<em><b>Datetime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIRMATION__DATETIME = eINSTANCE.getConfirmation_Datetime();

		/**
		 * The meta object literal for the '{@link de.upb.dbis.baas.impl.OperationMappingImpl <em>Operation Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.upb.dbis.baas.impl.OperationMappingImpl
		 * @see de.upb.dbis.baas.impl.BaasPackageImpl#getOperationMapping()
		 * @generated
		 */
		EClass OPERATION_MAPPING = eINSTANCE.getOperationMapping();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_MAPPING__OPERATION = eINSTANCE.getOperationMapping_Operation();

	}

} //BaasPackage
