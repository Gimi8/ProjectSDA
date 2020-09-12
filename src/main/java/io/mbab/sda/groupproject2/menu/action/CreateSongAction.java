package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.entity.Song;
import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import io.mbab.sda.groupproject2.repository.SongRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateSongAction implements MenuAction {

    private final CustomScanner scanner;
    private final MenuActionContext ctx;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    @Override
    public void execute() {
        System.out.println("0) Przejdź do poprzedniego menu");
        System.out.println("Podaj nazwę piosenki:");
        var input = scanner.nextLine();
        if (pressedZero(input)) return;

        var builder = Song.builder().title(input);

        System.out.println("Podaj nazwę artysty:");

        input = scanner.nextLine();

        if (pressedZero(input)) return;

        builder.artist(input).build();


        System.out.println("Podaj długość utworu ");

        double lenght = scanner.nextDouble();
        builder.lenght(lenght).build();

        if (pressedZero(input)) return;

       addAlbum(builder);



        songRepository.create(builder.build());

        ctx.use(MainAction.class).execute();
    }

    private void addAlbum(Song.SongBuilder builder) {
        System.out.println("Podaj ID albumu:");

        int albumId = scanner.nextInt();

        albumRepository.findById(albumId).ifPresentOrElse(album -> builder.album(album), () -> {
            System.out.println("nie znaleziono albumu o podanym ID");
            addAlbum(builder);
        });
    }

    private boolean pressedZero(String input) {
        if (input.equals("0")) {
            ctx.use(MainAction.class).execute();
            return true;
        }
        return false;
    }
}
