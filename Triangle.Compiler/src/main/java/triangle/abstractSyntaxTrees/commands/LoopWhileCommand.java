package triangle.abstractSyntaxTrees.commands;

import triangle.abstractSyntaxTrees.expressions.Expression;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public class LoopWhileCommand extends Command {
    public Command C1, C2;
    public Expression E;
    public LoopWhileCommand(Command c1, Expression e, Command c2, SourcePosition position) {
        super(position);
        C1 = c1; E = e; C2 = c2;
    }
    public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> visitor, TArg arg) {
        return visitor.visitLoopWhileCommand(this, arg);
    }
}
