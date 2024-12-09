public class Spirit {
    private String type;
    private String rarity;

    public Spirit(String type, String rarity) {
        this.type = type;
        this.rarity = rarity;
    }

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "Spirit: " + type + " (" + rarity + ")";
    }
}