package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAlbumByArtistNameAction implements MenuAction{

    private final MenuActionContext ctx;
    private final AlbumRepository repository;
    private final CustomScanner scanner;


    @Override
    public void execute() {
        System.out.println("Podaj nazwe wykonawcy : ");

        String artistName = scanner.nextLine();
        repository
                .findAlbumByArtistName(artistName)
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nie znaleziono"));
        ctx.use(MainAction.class).execute();

    }


}

