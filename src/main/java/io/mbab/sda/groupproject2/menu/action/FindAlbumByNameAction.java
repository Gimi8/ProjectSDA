package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAlbumByNameAction implements MenuAction {
    private final MenuActionContext ctx;
    private final AlbumRepository repository;
    private final CustomScanner scanner;

    @Override
    public void execute() {
        System.out.println("Podaj nazwe albumu : ");

        String name = scanner.nextLine();
        System.out.println(repository
                .findAlbumByName(name));

        ctx.use(MainAction.class).execute();

    }








}
