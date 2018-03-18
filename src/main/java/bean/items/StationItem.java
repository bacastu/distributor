package bean.items;

public class StationItem {
    private int     id;
    private String  name;
    private String  address;
    private int     cp;

    public StationItem(){}

    public StationItem(int id, String name, String address, int cp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cp = cp;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "\n\tStationItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cp=" + cp +
                '}';
    }
}
