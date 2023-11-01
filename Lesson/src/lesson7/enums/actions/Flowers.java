package lesson7.enums.actions;

public enum Flowers {
    ROSE("Троянда", "Білий, червоний. рожевий"),
    DACIE("Маргаритка", "Білий"),
    CHAMOMILE("Ромашка", "Білий"),
    VIOLET("Фіалка", "Білий, фіолетовий"),
    ORCHID("Орхідея", "Рожевий, білий");

    Flowers(String name, String colors) {
        this.name = name;
        this.colors = colors;
    }

    private final String name;
    private final String colors;

    public String getName() {
        return name;
    }

    public String getColors() {
        return colors;
    }
}
