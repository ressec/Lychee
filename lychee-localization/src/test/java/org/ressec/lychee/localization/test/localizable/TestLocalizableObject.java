/*
 * Copyright(c) 2021 by Resse Christophe.
 * --------------------------------------------------------------------------------------
 * This file is part of Resse Christophe public projects which is licensed
 * under the Apache license version 2 and use is subject to license terms.
 * You should have received a copy of the license with the project's artifact
 * binaries and/or sources.
 *
 * License can be consulted at http://www.apache.org/licenses/LICENSE-2.0
 * --------------------------------------------------------------------------------------
 */
package org.ressec.lychee.localization.test.localizable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.base.Localizable;
import org.ressec.lychee.localization.base.Rope;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.calendar.DayType;
import org.ressec.lychee.localization.type.calendar.MonthType;

import java.util.Locale;

/**
 * A class for unit testing the {@link LocalizableObject} entity (and so the {@link Localizable} interface).
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("i18n")
@Tag("internal")
final class TestLocalizableObject extends BaseUnitTest
{
    @Test
    @DisplayName("Should localize all localizable fields")
    final void shouldLocalize()
    {
        LocalizableObject o = new LocalizableObject(
                DayType.SATURDAY,
                MonthType.JUNE,
                null,
                Rope.builder()
                        .withBundle("i18n/month")
                        .withKey("month.DECEMBER.name")
                .build());

        o.localize(Locale.GERMAN); // Localize all annotated fields

        // Test with annotated fields
        Assertions.assertEquals("Sábado", o.getDayName(Locale.forLanguageTag("es")));
        Assertions.assertEquals("Juni", o.getMonthName(Locale.GERMAN));
        Assertions.assertEquals("Juni", o.getMonthName(Locale.GERMAN)); // Should not re-invoke localization process as the requested locale is the same as the previous one

        // Test with annotated methods
        Assertions.assertEquals("Domenica", o.getSundayName(Locale.ITALIAN));

        o.setDay(DayType.FRIDAY); // Change the day
        Assertions.assertEquals("Vendredi", o.getDayName(Locale.FRENCH));
    }

    @Test
    @DisplayName("Should not localize when the given locale is not available")
    final void shouldLocalizeUsingFallback()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);

        Locale vietnamese = Locale.forLanguageTag("vi"); // Vietnamese locale is not available!
        LocalizableObject o = new LocalizableObject(
                DayType.SATURDAY,
                MonthType.JUNE,
                Rope.builder()
                        .withValue("A free text not to be localized!")
                        .build(),
                null);

        o.localize(vietnamese);

        Assertions.assertEquals("Saturday", o.getDayName());
        Assertions.assertEquals("June", o.getMonthName());

        Assertions.assertNull(o.getTestName());
    }
}