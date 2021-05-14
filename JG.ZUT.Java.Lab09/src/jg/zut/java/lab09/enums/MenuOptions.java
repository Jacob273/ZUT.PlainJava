package jg.zut.java.lab09.enums;

public enum MenuOptions {

    List(1),
    AddEmployee(2),
    DeleteEmployee(3),
    Backup(4);

    public final int id;

    private MenuOptions(int id){
        this.id = id;
    }

    public int asId(){
        return id;
    }
}
