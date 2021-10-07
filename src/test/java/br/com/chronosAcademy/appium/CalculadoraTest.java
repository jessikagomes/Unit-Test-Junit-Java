package br.com.chronosAcademy.appium;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    DriverFactory driverFactory;

    @BeforeEach
    public void iniciarDriver() throws MalformedURLException {
        driverFactory = new DriverFactory();
        driverFactory.setCapabilities("Android","ChronosAcademy","uiautomator2","com.android.calculator2","com.android.calculator2.Calculator");
        driverFactory.setDriver();
    }

    @AfterEach
    public void finalizarDriver(){
        driverFactory.getDriver().quit();
    }

    @Test
    @DisplayName("Validar Multiplicação 7 x 9 resultado 63")
    public void validarMultiplicacao() {

        clickId("digit_7");
        clickId("op_mul");
        clickId("digit_9");
        clickId("eq");

        Integer resultado = Integer.parseInt(driverFactory.getDriver().findElement(MobileBy.id("result")).getText());

        assertEquals(63,resultado);

    }

    @Test
    @DisplayName("Validar Adição 25 + 45 resultado 70")
    public void validarAdicao() throws MalformedURLException {

        driverFactory.getDriver().findElement(MobileBy.id("digit_2")).click();
        driverFactory.getDriver().findElement(MobileBy.id("digit_5")).click();
        driverFactory.getDriver().findElement(MobileBy.id("op_add")).click();
        driverFactory.getDriver().findElement(MobileBy.id("digit_4")).click();
        driverFactory.getDriver().findElement(MobileBy.id("digit_5")).click();
        driverFactory.getDriver().findElement(MobileBy.id("eq")).click();

        Integer resultado = Integer.parseInt(driverFactory.getDriver().findElement(MobileBy.id("result")).getText());

        assertEquals(70,resultado);

    }


    public void clickId(String id){
        driverFactory.getDriver().findElement(MobileBy.id(id)).click();
    }

    public void getResult(String id){
        Integer resultado = Integer.parseInt(driverFactory.getDriver().findElement(MobileBy.id(id)).getText());
    }
}
