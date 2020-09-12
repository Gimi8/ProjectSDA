package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;

    @Override
    public void execute() {
        System.out.println("0) Zamknij aplikację");
        System.out.println("1) Dodaj Album");
        System.out.println("2) Wyswietl Albumy");
        System.out.println("3) Dodaj Piosenk");
        System.out.println("4) Wyświetl piosenki");
        System.out.println("5) Wyswietl piosenki dla albumu o nr");
        System.out.println("6) Wyswietl piosenki dla albumu nazwie");
        System.out.println("7) Wyswietl piosenki dla albumu artysty");


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
            ctx.use(ViewAlbumsAction.class).execute();
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
        if (input.equals("5")) {
            ctx.use(ViewAlbumAction.class).execute();
        }
        if (input.equals("6")) {
            ctx.use(FindAlbumByName.class).execute();

        }if (input.equals("7")) {
            ctx.use(FindAlbumByArtistName.class).execute();
        }


        System.out.println("wprowadzono nieprawidlowa wartosc");
        execute();
    }


}


