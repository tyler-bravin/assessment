package triangle.abstractSyntaxTrees.visitors;

import triangle.abstractSyntaxTrees.*;
import triangle.abstractSyntaxTrees.commands.*;
import triangle.abstractSyntaxTrees.declarations.*;
import triangle.abstractSyntaxTrees.expressions.*;
import triangle.abstractSyntaxTrees.formals.*;
import triangle.abstractSyntaxTrees.types.*;
import triangle.abstractSyntaxTrees.vnames.*;

/**
 * SummaryVisitor counts specific AST node types:
 * - BinaryExpression
 * - IfCommand
 * - WhileCommand
 */
public class SummaryVisitor implements CommandVisitor<Void, Void>, ExpressionVisitor<Void, Void>, DeclarationVisitor<Void, Void>, VnameVisitor<Void, Void> {

    private int binaryExpressionCount = 0;
    private int ifCommandCount = 0;
    private int whileCommandCount = 0;

    // Getters for the counts
    public int getBinaryExpressionCount() {
        return binaryExpressionCount;
    }

    public int getIfCommandCount() {
        return ifCommandCount;
    }

    public int getWhileCommandCount() {
        return whileCommandCount;
    }

    // Program
    public void visitProgram(Program ast, Void unused) {
        ast.C.visit(this, unused); // Visit the command part of the program
    }

    // Commands
    @Override
    public Void visitSequentialCommand(SequentialCommand ast, Void unused) {
        ast.C1.visit(this, unused); // Visit first command
        ast.C2.visit(this, unused); // Visit second command
        return null;
    }

    @Override
    public Void visitLetCommand(LetCommand ast, Void unused) {
        ast.D.visit(this, unused); // Visit the declaration part
        ast.C.visit(this, unused); // Visit the command part
        return null;
    }

    @Override
    public Void visitAssignCommand(AssignCommand ast, Void unused) {
        ast.V.visit(this, unused); // Visit the variable being assigned
        ast.E.visit(this, unused); // Visit the expression being assigned
        return null;
    }

    @Override
    public Void visitCallCommand(CallCommand ast, Void unused) {
        return null;
    }

    @Override
    public Void visitIfCommand(IfCommand ast, Void unused) {
        ifCommandCount++;
        ast.E.visit(this, unused);  // Visit the condition
        ast.C1.visit(this, unused); // Visit the then command
        ast.C2.visit(this, unused); // Visit the else command
        return null;
    }

    @Override
    public Void visitWhileCommand(WhileCommand ast, Void unused) {
        whileCommandCount++;
        ast.E.visit(this, unused);  // Visit the condition
        ast.C.visit(this, unused);  // Visit the body command
        return null;
    }

    @Override
    public Void visitSquareCommand(SquareCommand ast, Void unused) {
        return null;
    }

    @Override
    public Void visitLoopWhileCommand(LoopWhileCommand ast, Void unused) {
        return null;
    }

    // Expressions
    @Override
    public Void visitUnaryExpression(UnaryExpression ast, Void unused) {
        ast.E.visit(this, unused); // Visit the operand
        return null;
    }

    @Override
    public Void visitArrayExpression(ArrayExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitBinaryExpression(BinaryExpression ast, Void unused) {
        binaryExpressionCount++;
        ast.E1.visit(this, unused); // Visit the left operand
        ast.E2.visit(this, unused); // Visit the right operand
        return null;
    }

    @Override
    public Void visitCallExpression(CallExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitCharacterExpression(CharacterExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitVnameExpression(VnameExpression ast, Void unused) {
        ast.V.visit(this, unused); // Visit the variable name
        return null;
    }

    // Declarations
    @Override
    public Void visitSequentialDeclaration(SequentialDeclaration ast, Void unused) {
        ast.D1.visit(this, unused); // Visit the first declaration
        ast.D2.visit(this, unused); // Visit the second declaration
        return null;
    }

    @Override
    public Void visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Void unused) {
        return null;
    }

    @Override
    public Void visitConstDeclaration(ConstDeclaration ast, Void unused) {
        ast.E.visit(this, unused); // Visit the constant's value
        return null;
    }

    @Override
    public Void visitFuncDeclaration(FuncDeclaration ast, Void unused) {
        return null;
    }

    @Override
    public Void visitProcDeclaration(ProcDeclaration ast, Void unused) {
        return null;
    }

    // Variable Names (Vnames)
    @Override
    public Void visitDotVname(DotVname ast, Void unused) {
        ast.V.visit(this, unused); // Visit the parent record
        return null;
    }

    @Override
    public Void visitSubscriptVname(SubscriptVname ast, Void unused) {
        ast.V.visit(this, unused); // Visit the array
        ast.E.visit(this, unused); // Visit the subscript expression
        return null;
    }

    @Override
    public Void visitSimpleVname(SimpleVname ast, Void unused) {
        // Nothing specific to count here
        return null;
    }

    // Other methods
    @Override
    public Void visitEmptyCommand(EmptyCommand ast, Void unused) {
        return null;
    }

    @Override
    public Void visitEmptyExpression(EmptyExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitIfExpression(IfExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitIntegerExpression(IntegerExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitLetExpression(LetExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitRecordExpression(RecordExpression ast, Void unused) {
        return null;
    }

    @Override
    public Void visitConstFormalParameter(ConstFormalParameter ast, Void unused) {
        return null;
    }

    @Override
    public Void visitFuncFormalParameter(FuncFormalParameter ast, Void unused) {
        return null;
    }

    @Override
    public Void visitProcFormalParameter(ProcFormalParameter ast, Void unused) {
        return null;
    }

    @Override
    public Void visitVarFormalParameter(VarFormalParameter ast, Void unused) {
        return null;
    }

    @Override
    public Void visitTypeDeclaration(TypeDeclaration ast, Void unused) {
        return null;
    }

    @Override
    public Void visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Void unused) {
        return null;
    }

    @Override
    public Void visitVarDeclaration(VarDeclaration ast, Void unused) {
        return null;
    }
}
