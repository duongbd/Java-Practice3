package ListProduc;

public class Production {
    private static int count;
    private int id;
    private int idListProduc;
    private String name;
    private int price;
    private String dateIn, dateOut, expiryDate, description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdListProduc() {
        return idListProduc;
    }

    public void setIdListProduc(int idListProduc) {
        this.idListProduc = idListProduc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void show() {
        System.out.println("Name production: " + this.name);
        System.out.println("Id production  : " + this.id);
        System.out.println("Price          : " + this.price);
        System.out.println("Date in        : " + this.dateIn);
        System.out.println("Date out       : " + this.dateOut);
        System.out.println("expiryDate     : " + this.expiryDate);
        System.out.println("Description    : " + this.description);
        System.out.println();
    }

    public Production(int idListProduc, String name, int price, String dateIn, String dateOut, String expiryDate, String description) {
        this.id = ++count;
        this.idListProduc = idListProduc;
        this.name = name;
        this.price = price;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.expiryDate = expiryDate;
        this.description = description;
    }

    public Production(int id, int idListProduc, String name, int price, String dateIn, String dateOut, String expiryDate, String description) {
        this.id = id;
        this.idListProduc = idListProduc;
        this.name = name;
        this.price = price;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.expiryDate = expiryDate;
        this.description = description;
        count=Math.max(count,id);
    }
}
