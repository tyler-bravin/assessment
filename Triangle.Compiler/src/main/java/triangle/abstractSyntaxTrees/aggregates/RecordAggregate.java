/*
 * @(#)RecordAggregate.java                       
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

package triangle.abstractSyntaxTrees.aggregates;

import triangle.abstractSyntaxTrees.AbstractSyntaxTree;
import triangle.abstractSyntaxTrees.types.FieldTypeDenoter;
import triangle.abstractSyntaxTrees.visitors.RecordAggregateVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public abstract class RecordAggregate extends AbstractSyntaxTree {

	public RecordAggregate(SourcePosition position) {
		super(position);
		type = null;
	}

	public FieldTypeDenoter type;

	public abstract <TArg, TResult> TResult visit(RecordAggregateVisitor<TArg, TResult> visitor, TArg arg);

	public <TArg, TResult> TResult visit(RecordAggregateVisitor<TArg, TResult> visitor) {
		return visit(visitor, null);
	}
}
