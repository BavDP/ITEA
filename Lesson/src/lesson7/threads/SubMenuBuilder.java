package lesson7.threads;

import MenuBuilder.ConsoleMenuBuilder;
import lesson5.generics.actions.CountUniqueElemsAction;
import lesson7.threads.syncSimple.SimpleSyncThreadAction;
import lesson7.threads.syncWithWaitNotify.WaitSyncThreadAction;

public class SubMenuBuilder {
    static public ConsoleMenuBuilder getMenu(String prnTitle) {
        final String SIMPLE_SYNC = "Synchronized";
        final String WAIT_SYNC = "Wait, notify, notifyAll";


        return new ConsoleMenuBuilder(prnTitle)
                .AddMenuItem("1", SIMPLE_SYNC, new SimpleSyncThreadAction())
                .AddMenuItem("2", WAIT_SYNC, new WaitSyncThreadAction())
                .AddMenuItem("0", "Go to previous menu", null, true);
    }
}
