package use_cases.homepage_use_cases;

import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenHomePageTest {

    @Test
    void openHome() {
        class fakePresenter implements HomePageOutputBoundary {
            @Override
            public void openHome(int userId) {
                assertEquals(userId, 0);
            }
        }

        OpenHomePageInputBoundary openHome = new OpenHomePage(new fakePresenter());
        openHome.openHome(0);
    }
}