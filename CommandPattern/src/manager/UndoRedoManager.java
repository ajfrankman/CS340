package manager;

import Command.Command;

import java.util.Stack;

public class UndoRedoManager {
    private Stack<Command> _undoStack;
    private Stack<Command> _redoStack;

    public UndoRedoManager() {
        _undoStack = new Stack<>();
        _redoStack = new Stack<>();
    }

    void executeCommand(Command command) {
        _redoStack.clear();
        command.exectue();
        _undoStack.push(command);
    }

    void undo() {
        if (!_undoStack.isEmpty()) {
            Command command = _undoStack.pop();
            _redoStack.push(command);
            command.undo();
        }
    }
}
