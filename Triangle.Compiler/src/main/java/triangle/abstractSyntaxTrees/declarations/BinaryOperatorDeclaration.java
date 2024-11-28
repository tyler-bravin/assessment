/*
 * @(#)BinaryOperatorDeclaration.java               
 * 
 * Revisions and updates (c) 2022-2024 Sandy Brownlee. alexander.brownlee@stir.ac.uk
 * 
 * Original release:
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package triangle.abstractSyntaxTrees.declarations;

import triangle.abstractSyntaxTrees.terminals.Operator;
import triangle.abstractSyntaxTrees.types.TypeDenoter;
import triangle.abstractSyntaxTrees.visitors.DeclarationVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public class BinaryOperatorDeclaration extends Declaration {

	public BinaryOperatorDeclaration(Operator oAST, TypeDenoter arg1AST, TypeDenoter arg2AST, TypeDenoter resultAST,
			SourcePosition position) {
		super(position);
		O = oAST;
		ARG1 = arg1AST;
		ARG2 = arg2AST;
		RES = resultAST;
	}

	public <TArg, TResult> TResult visit(DeclarationVisitor<TArg, TResult> v, TArg arg) {
		return v.visitBinaryOperatorDeclaration(this, arg);
	}

	public final Operator O;
	public final TypeDenoter ARG1, ARG2, RES;
}
