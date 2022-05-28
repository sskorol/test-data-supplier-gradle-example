package io.github.sskorol.core;

import io.github.sskorol.pages.Page;
import lombok.experimental.UtilityClass;
import io.qameta.allure.Step;

import static org.joor.Reflect.onClass;

@SuppressWarnings("JavadocType")
@UtilityClass
public class PageFactory {

    public static <T extends Page> T open(final Class<T> pageClass) {
        return at(pageClass);
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        prettify(pageClass.getSimpleName());
        return onClass(pageClass)
            .create()
            .get();
    }

    @Step("Open {name}")
    @SuppressWarnings("PMD.UnusedFormalParameter")
    private static void prettify(final String name) {
        // not implemented
    }
}
