public class AdapterThing implements TableData{

    ContactManager contactManager;

    public AdapterThing(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return contactManager.getContactCount();
    }

    @Override
    public int getColumnSpacing() {
        return 2;
    }

    @Override
    public int getRowSpacing() {
        return 2;
    }

    @Override
    public char getHeaderUnderline() {
        return '_';
    }

    @Override
    public String getColumnHeader(int col) {
        return contactManager.getContact(col).getLastName();
    }

    @Override
    public int getColumnWidth(int col) {
        return contactManager.getContact(col).getLastName().length();
    }

    @Override
    public Justification getColumnJustification(int col) {
        return Justification.Center;
    }

    @Override
    public String getCellValue(int row, int col) {
        return "idk";
    }
}
