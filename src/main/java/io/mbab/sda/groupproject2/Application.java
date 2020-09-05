package io.mbab.sda.groupproject2;

import io.mbab.sda.groupproject2.config.Configuration;
import io.mbab.sda.groupproject2.config.JpaUtil;
import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.action.MainAction;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.CrudRepositoryFactory;

public class Application {

  public static void main(String... args) {
    var emFactory =
        JpaUtil.getEntityManagerFactory(
            Configuration.getDataSource(), Configuration.getEntityClass());
    var repositoryFactory = new CrudRepositoryFactory(emFactory);
    var scanner = new CustomScanner();

    new MenuActionContext(scanner, repositoryFactory).use(MainAction.class).execute();
  }
}
