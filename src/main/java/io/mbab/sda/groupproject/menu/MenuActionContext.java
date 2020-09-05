package io.mbab.sda.groupproject.menu;

import io.mbab.sda.groupproject.menu.action.*;
import io.mbab.sda.groupproject.repository.CityRepository;
import io.mbab.sda.groupproject.repository.CrudRepositoryFactory;
import io.mbab.sda.groupproject.repository.SongRepository;
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


    public void execute() {
        if (action == null) throw new RuntimeException("Menu action not set");
        action.execute();
    }

    private void initHolder(CustomScanner scanner, CrudRepositoryFactory repositoryFactory) {
        holder.put(MainAction.class, new MainAction(scanner, this));
        holder.put(
                CreateCityAction.class,
                new CreateCityAction(scanner, this, repositoryFactory.get(CityRepository.class)));
        holder.put(
                ViewCitiesAction.class,
                new ViewCitiesAction(this, repositoryFactory.get(CityRepository.class)));

        holder.put(CreateSongAction.class, new CreateSongAction(scanner, this, repositoryFactory.get(SongRepository.class)));

        holder.put(VievSongsAction.class, new VievSongsAction(this, repositoryFactory.get(SongRepository.class)));
    }

}
