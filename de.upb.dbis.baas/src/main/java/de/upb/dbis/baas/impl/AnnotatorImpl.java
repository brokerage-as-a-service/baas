/**
 */
package de.upb.dbis.baas.impl;

import de.upb.dbis.baas.AnnotationResult;
import de.upb.dbis.baas.Annotator;
import de.upb.dbis.baas.BaasPackage;
import de.upb.dbis.baas.IO;
import de.upb.dbis.baas.SemanticType;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AnnotatorImpl extends MinimalEObjectImpl.Container implements Annotator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaasPackage.Literals.ANNOTATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationResult searchSemanticType(IO io) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void add(IO io, SemanticType type) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BaasPackage.ANNOTATOR___SEARCH_SEMANTIC_TYPE__IO:
				return searchSemanticType((IO)arguments.get(0));
			case BaasPackage.ANNOTATOR___ADD__IO_SEMANTICTYPE:
				add((IO)arguments.get(0), (SemanticType)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //AnnotatorImpl
