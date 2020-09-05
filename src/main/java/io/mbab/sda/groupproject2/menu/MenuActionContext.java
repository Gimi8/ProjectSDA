package io.mbab.sda.groupproject2.menu;

import io.mbab.sda.groupproject2.menu.action.*;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import io.mbab.sda.groupproject2.repository.CrudRepositoryFactory;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class MenuActionContext {

  private MenuAction action;
  private Map<Class<? extends MenuAction>, MenuAction> holder = new HashMap<>();

  public MenuActionContext(CustomScanner scanner, CrudRepositoryFactory repositoryFactory) {
    initHolder(scanner, repositoryFactory);
  }

  public MenuActionContext use(Class<? extends MenuAction> actionClass) {
    action = holder.get(actionClass);
    return this;
  }

  @SneakyThrows
  public void execute() {
    if (action == null) throw new RuntimeException("Menu action not set");
    action.execute();
  }

  private void initHolder(CustomScanner scanner, CrudRepositoryFactory repositoryFactory) {
    holder.put(MainAction.class, new MainAction(scanner, this));
    holder.put(
        CreateAlbumAction.class,
        new CreateAlbumAction(scanner, this, repositoryFactory.get(AlbumRepository.class)));
    holder.put(
        ViewCitiesAction.class,
        new ViewCitiesAction(this, repositoryFactory.get(AlbumRepository.class)));
  }
}
