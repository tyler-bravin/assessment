/*
 * @(#)EmptyFormalParameterSequence.java       
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

package triangle.abstractSyntaxTrees.formals;

import triangle.abstractSyntaxTrees.visitors.FormalParameterSequenceVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public class EmptyFormalParameterSequence extends FormalParameterSequence {

	public EmptyFormalParameterSequence(SourcePosition position) {
		super(position);
	}

	public <TArg, TResult> TResult visit(FormalParameterSequenceVisitor<TArg, TResult> v, TArg arg) {
		return v.visitEmptyFormalParameterSequence(this, arg);
	}

	@Override
	public boolean equals(Object fpsAST) {
		return (fpsAST instanceof EmptyFormalParameterSequence);
	}
}