package triangle.abstractSyntaxTrees.commands;

import triangle.abstractSyntaxTrees.vnames.Vname;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

/**
 * Represents the `**` command, which squares the value of a variable.
 */
public class SquareCommand extends Command {

    public SquareCommand(Vname vAST, SourcePosition position) {
        super(position);
        V = vAST;
    }

    public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> v, TArg arg) {
        return v.visitSquareCommand(this, arg);
    }

    public Vname V; // The variable being squared
}
