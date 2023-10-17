package lesson4.anonymous;

import MenuBuilder.AbstractAction;

public class AnonymousShapeAction extends AbstractAction {
    private void drawAnyShape(ShapeAnonymous shape){
        shape.draw();
    }
    @Override
    public void doAction() {
        drawAnyShape(new ShapeAnonymous() {
            @Override
            public void draw() {
                System.out.println("draw anonymous shape");
            }
        });
    }
}
