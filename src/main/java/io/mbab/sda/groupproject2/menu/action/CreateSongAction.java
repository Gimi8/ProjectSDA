package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.entity.Song;
import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.SongRepository;
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

    System.out.println("Podaj nazwę artysty:");

    input = scanner.nextLine();

    if (pressedZero(input)) return;

    var builder2 = builder.artist(input).build();

    System.out.println("Podaj nazwę albumu:");

    input = scanner.nextLine();

    var album = builder.album(input).build();
    System.out.println("Podaj długość utworu ");

    double length = scanner.nextDouble();
    var song = builder.lenght(length).build();

    if (pressedZero(input)) return;
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
