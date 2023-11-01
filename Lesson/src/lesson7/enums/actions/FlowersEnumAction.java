package lesson7.enums.actions;

import MenuBuilder.AbstractAction;

public class FlowersEnumAction extends AbstractAction {
    @Override
    public void doAction() {
        Flowers flowers = Flowers.ROSE;
        System.out.println(flowers.getName());
        for (Flowers f: Flowers.values()) {
            System.out.println("Назва: " + f.getName() + " кольори: " + f.getColors());
        }
    }
}
