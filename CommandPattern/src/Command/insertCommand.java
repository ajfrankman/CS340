package Command;

import javax.swing.text.Document;

public class insertCommand implements Command{

    Document document;
    int insertionIndex;
    int sequenceInput;

    public insertCommand(Document document, int insertionIndex, int sequenceInput) {
        this.document = document;
        this.insertionIndex = insertionIndex;
        this.sequenceInput = sequenceInput;
    }

    @Override
    public void exectue() {
        document.inser
    }

    @Override
    public void undo() {

    }
}
