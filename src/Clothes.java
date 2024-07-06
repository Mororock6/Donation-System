public class Clothes {
    private ClotheSize size;//enum
    private ClotheType type;

    public Clothes(ClotheType clotheType, ClotheSize clotheSize) {
        super();
        this.type = clotheType;
        this.size = clotheSize;
        DonationsLists.addClothes(this);
    }

    @Override
    public String toString() {
        return "Clothes [size=" + size + ", type=" + type + "]";
    }

}