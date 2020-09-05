package io.mbab.sda.groupproject2.menu.action;

import io.mbab.sda.groupproject2.entity.Album;
import io.mbab.sda.groupproject2.menu.CustomScanner;
import io.mbab.sda.groupproject2.menu.MenuActionContext;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import io.mbab.sda.groupproject2.repository.AlbumRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CreateCityActionTest {

    @Test
    void shouldExecuteMainAction() {
        //given
        var scanner = mock(CustomScanner.class);
        var actionCtx = mock(MenuActionContext.class);
        var repository = mock(AlbumRepository.class);
        var testedAction = new CreateAlbumAction(scanner, actionCtx, repository);

        when(scanner.nextLine()).thenReturn("0");
        when(actionCtx.use(MainAction.class)).thenReturn(actionCtx);

        //when
        testedAction.execute();

        //then
        verify(actionCtx, times(1)).execute();
       // use(MainAction.class)
    }
}
