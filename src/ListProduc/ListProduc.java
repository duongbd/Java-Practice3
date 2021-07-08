package ListProduc;

public class ListProduc {
    static private int count = 0;
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Name list: " + this.name);
        System.out.println("Id       : " + this.id);
        System.out.println();
    }

    public ListProduc(String name) {
        this.id = ++count;
        this.name = name;
    }
}
