package Books;

public class Russian_Fuction extends Book {

    private String name;

    @Override
    public String getFullName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
