package api.pages;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import verification.VerifySoft;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BaseScreen {

    public BaseScreen() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        verifyPageIsOpened();
    }

    public void verifyPageIsOpened() {
        getRequiredElements().forEach(element -> {
                    try {
                        VerifySoft.verifyTrueSoft(element.isDisplayed(),
                                String.format("Element '%s' is not displayed", element));
                    } catch (NoSuchElementException e) {
                        throw new NoSuchElementException(String.format("\nPage '%s' is not opened. Required element is not displayed. \n%s",
                                getPageNameByAnnotation(), e.getMessage()));
                    }
                }
        );
        VerifySoft.showAllChecking(String.format("Page '%s' is opened", getPageNameByAnnotation()));
    }

    private Object getFieldValue(Field field, Object owner) {
        field.setAccessible(Boolean.TRUE);
        try {
            return field.get(owner);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Exception during getting value from field " + field.getName());
        }
    }

    private WebElement castToWebElement(Object object) {
        if (object instanceof WebElement) {
            return (WebElement) object;
        } else {
            return null;
        }
    }

    private List<WebElement> getRequiredElements() {
        return Arrays.stream(getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Required.class))
                .map(field -> getFieldValue(field, this))
                .map(this::castToWebElement)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private String getPageNameByAnnotation() {
        Class<? extends BaseScreen> thisClass = this.getClass();
        if (thisClass.isAnnotationPresent(PageName.class)) {
            PageName pageName = this.getClass().getAnnotation(PageName.class);
            return pageName.pageName();
        } else {
            return "Page without Annotation";
        }
    }
}
