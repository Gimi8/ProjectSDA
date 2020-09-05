package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.City;
import io.mbab.sda.groupproject.entity.Song;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CityRepository;
import io.mbab.sda.groupproject.repository.SongRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateSongAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final SongRepository repository;

    @Override
    public void execute() {
        System.out.println("0) Przejdź do poprzedniego menu");
        System.out.println("Podaj nazwę piosenki:");

        var input = scanner.nextLine();

        if (pressedZero(input)) return;

        var builder = Song.builder().title(input);



        System.out.println("Podaj nazwę albumu:");

        input = scanner.nextLine();

        if (pressedZero(input)) return;

        var song = builder.album(input).build();



        System.out.println("podaj dlugosc piosenki");
        input = scanner.nextLine();
        if (pressedZero(input)) return;
        song = builder.lenght(Integer.parseInt(input)).build();


        System.out.println("podaj artyste");
        input = scanner.nextLine();
        if (pressedZero(input)) return;
        song = builder.artist(input).build();


        repository.create(song);
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
