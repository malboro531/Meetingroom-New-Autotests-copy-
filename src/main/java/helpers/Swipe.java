package helpers;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;
//https://www.youtube.com/watch?v=XAmR_8T3HIw&t=835s
// Ссылка на видео по правильному написанию свайпов с помощью W3C Action

public class Swipe {

    public static void swipeElement(int startY, int endY, int startX, int endX) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(0));
        DriverManager.getDriver()
                .perform(List.of(swipe));
    }

    public static int findCenter(WebElement element) {
        return element.getRect().y + (element.getSize().height / 2);
    }


    public static void swipeElementToLeft(WebElement element) {
        int startX = (int) (element.getRect().x + (element.getSize().width * 0.9));
        int endX = (int) (element.getRect().x + (element.getSize().width * 0.1));
        swipeElement(findCenter(element), findCenter(element), startX, endX);
    }

    public static void swipeElementToRight(WebElement element) {
        int endX = (int) (element.getRect().x + (element.getSize().width * 0.9));
        int startX = (int) (element.getRect().x + (element.getSize().width * 0.1));
        swipeElement(findCenter(element), findCenter(element), startX, endX);
    }

    public static void swipeElementUp(WebElement element) {
        int endY = (int) (element.getRect().y - (element.getSize().height * 0.1));
        int startY = (int) (element.getRect().y + (element.getSize().height * 0.9));
        swipeElement(startY, endY, findCenter(element), findCenter(element));
    }

    public static void swipeElementToElementRight(WebElement elementToSwipe, WebElement destinationElement) {
        int endX = elementToSwipe.getRect().x + destinationElement.getLocation().x;
        int startX = elementToSwipe.getRect().x + (elementToSwipe.getSize().width);
        swipeElement(findCenter(elementToSwipe), findCenter(elementToSwipe), startX, endX);
    }

    public static void swipeElementToElementLeft(WebElement elementToSwipe, WebElement destinationElement) {
        int startX = elementToSwipe.getRect().x + destinationElement.getLocation().x;
        int endX = elementToSwipe.getRect().x + (elementToSwipe.getSize().width);
        swipeElement(findCenter(elementToSwipe), findCenter(elementToSwipe), startX, endX);
    }
    public static void swipeElementToElementMaxRight(WebElement elementToSwipe) {
        int endX = elementToSwipe.getRect().x + elementToSwipe.getSize().width * 1000;
        int startX = elementToSwipe.getRect().x + (elementToSwipe.getSize().width);
        swipeElement(findCenter(elementToSwipe), findCenter(elementToSwipe), startX, endX);
    }
}
