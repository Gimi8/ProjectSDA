package io.mbab.sda.groupproject2.menu.action;


import io.mbab.sda.groupproject2.entity.Album;
import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAlbumAction implements MenuAction  {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final AlbumRepository repository;

    @Override
    public void execute() {
        System.out.println("0) Przejdź do poprzedniego menu");
        System.out.println("Podaj nazwę Albumu:");

        var input = scanner.nextLine();

        if (pressedZero(input)) return;

        var builder = Album.builder().name(input);

        System.out.println("Podaj wykonawce Albumu:");

        input = scanner.nextLine();

        if (pressedZero(input)) return;

        var album = builder.artistName(input).build();

        repository.create(album);
        ctx.use(MainAction.class).execute();
    }

    private boolean pressedZero(String input) {
        if (input.equals("0")) {
            ctx.use(MainAction.class).execute();
            return true;
        }
        return false;
    }
}
