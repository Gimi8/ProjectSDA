package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewCitiesAction implements MenuAction {

  private final MenuActionContext ctx;
  private final AlbumRepository repository;

  @Override
  public void execute() {
    var cities = repository.getAll();

    if (cities.isEmpty()) {
      System.out.println("Brak danych do wyświetlenia");
    } else {
      System.out.println("\n");
      cities.forEach(System.out::println);
      System.out.println("\n");
    }

    ctx.use(MainAction.class).execute();
  }
}
