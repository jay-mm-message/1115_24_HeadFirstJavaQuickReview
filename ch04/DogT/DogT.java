package ch04.DogT;

public class DogT {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public boolean equals(DogT d) {
        if (this.getSize() == d.getSize()) {
            if (this.getName().equals(d.getName())) {
                return true;
            }
        }
        return false;
    }
}
