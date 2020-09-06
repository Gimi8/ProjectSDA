package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;

    @Override
    public void execute() {
        System.out.println("0) Zamknij aplikację");
        System.out.println("1) Dodaj Album");
        System.out.println("2) Wyswietl nazwe Albumu");
        System.out.println("3) Dodaj Piosenk");
        System.out.println("4) Wyświetl piosenke");
        System.out.println("5) Znajdz album po numerze");

        var input = scanner.nextLine();

        if (input.equals("0")) {
            System.exit(0);
            return;
        }

        if (input.equals("1")) {
            ctx.use(CreateAlbumAction.class).execute();
            return;
        }

        if (input.equals("2")) {
            ctx.use(ViewAlbumAction.class).execute();
            return;
        }
        if (input.equals("3")) {
            ctx.use(CreateSongAction.class).execute();
            return;
        }
        if (input.equals("4")) {
            ctx.use(ViewSongAction.class).execute();
            return;
        }

    }


}


