/**
 */
package de.upb.dbis.baas.util;

import de.upb.dbis.baas.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.upb.dbis.baas.BaasPackage
 * @generated
 */
public class BaasSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BaasPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaasSwitch() {
		if (modelPackage == null) {
			modelPackage = BaasPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BaasPackage.USER: {
				User user = (User)theEObject;
				T result = caseUser(user);
				if (result == null) result = caseUniqueElement(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.COMPOSITION: {
				Composition composition = (Composition)theEObject;
				T result = caseComposition(composition);
				if (result == null) result = caseUniqueElement(composition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.SPECIFICATION: {
				Specification specification = (Specification)theEObject;
				T result = caseSpecification(specification);
				if (result == null) result = caseUniqueElement(specification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseUniqueElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.IO: {
				IO io = (IO)theEObject;
				T result = caseIO(io);
				if (result == null) result = caseUniqueElement(io);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.ANNOTATOR: {
				Annotator annotator = (Annotator)theEObject;
				T result = caseAnnotator(annotator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.ANNOTATION_RESULT: {
				AnnotationResult annotationResult = (AnnotationResult)theEObject;
				T result = caseAnnotationResult(annotationResult);
				if (result == null) result = caseRanking(annotationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.SEMANTIC_TYPE: {
				SemanticType semanticType = (SemanticType)theEObject;
				T result = caseSemanticType(semanticType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.DISCOVERY_RESULT: {
				DiscoveryResult discoveryResult = (DiscoveryResult)theEObject;
				T result = caseDiscoveryResult(discoveryResult);
				if (result == null) result = caseRanking(discoveryResult);
				if (result == null) result = caseUniqueElement(discoveryResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.SEMANTIC_TYPE_MAPPING: {
				SemanticTypeMapping semanticTypeMapping = (SemanticTypeMapping)theEObject;
				T result = caseSemanticTypeMapping(semanticTypeMapping);
				if (result == null) result = caseMapping(semanticTypeMapping);
				if (result == null) result = caseUniqueElement(semanticTypeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.VECTOR: {
				Vector vector = (Vector)theEObject;
				T result = caseVector(vector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.SIMILARITY: {
				Similarity similarity = (Similarity)theEObject;
				T result = caseSimilarity(similarity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.IO_MAPPING: {
				IOMapping ioMapping = (IOMapping)theEObject;
				T result = caseIOMapping(ioMapping);
				if (result == null) result = caseMapping(ioMapping);
				if (result == null) result = caseUniqueElement(ioMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseUniqueElement(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.UNIQUE_ELEMENT: {
				UniqueElement uniqueElement = (UniqueElement)theEObject;
				T result = caseUniqueElement(uniqueElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.RANKING: {
				Ranking ranking = (Ranking)theEObject;
				T result = caseRanking(ranking);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.MATCHING_RESULT: {
				MatchingResult matchingResult = (MatchingResult)theEObject;
				T result = caseMatchingResult(matchingResult);
				if (result == null) result = caseRanking(matchingResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.CONFIRMATION: {
				Confirmation confirmation = (Confirmation)theEObject;
				T result = caseConfirmation(confirmation);
				if (result == null) result = caseUniqueElement(confirmation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BaasPackage.OPERATION_MAPPING: {
				OperationMapping operationMapping = (OperationMapping)theEObject;
				T result = caseOperationMapping(operationMapping);
				if (result == null) result = caseMapping(operationMapping);
				if (result == null) result = caseUniqueElement(operationMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComposition(Composition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecification(Specification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IO</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IO</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIO(IO object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotator(Annotator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationResult(AnnotationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticType(SemanticType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discovery Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discovery Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscoveryResult(DiscoveryResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Type Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Type Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticTypeMapping(SemanticTypeMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVector(Vector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Similarity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Similarity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimilarity(Similarity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IO Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IO Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOMapping(IOMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueElement(UniqueElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ranking</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ranking</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRanking(Ranking object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matching Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matching Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchingResult(MatchingResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Confirmation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Confirmation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfirmation(Confirmation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationMapping(OperationMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BaasSwitch
