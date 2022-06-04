package stepDef;

public enum SortPrice {
    умолчанию(0, "По умолчанию"),
    дате(1,"По дате"),
    дешевле(2,"Дешевле"),
    дороже(3,"Дороже"),
    удаленности(4,"По удаленности");

    public String value;
    public Integer id;

    public String getValue() {
        return value;
    }

    SortPrice(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
}
