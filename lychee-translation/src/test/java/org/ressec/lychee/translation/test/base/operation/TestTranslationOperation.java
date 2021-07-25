/*
 * Copyright(c) 2020 by Resse Christophe.
 * --------------------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -------------------------------------------------------------------------------------
 */
package org.ressec.lychee.translation.test.base.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.translation.base.operation.*;

import java.util.Locale;

/**
 * A class for unit testing the {@link TranslationOperation} entity.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("translation")
@Tag("translation.operation")
final class TestTranslationOperation extends BaseUnitTest
{
    /**
     * Test resource bundle property entry for name key.
     */
    private static final String TEXT_SOURCE = "Antarctica is Earth's southernmost continent. It contains the geographic " +
            "South Pole and is situated in the Antarctic region of the Southern Hemisphere, almost entirely south of " +
            "the Antarctic Circle, and is surrounded by the Southern Ocean.";

    @Test
    @DisplayName("Should validate the creation of a translation translate operation")
    void shouldValidateEntityCreationForTranslationOperationTranslate()
    {
        TranslationOperationTranslate operation = TranslationOperationTranslate.builder()
                .withText(TEXT_SOURCE)
                .withSourceLanguage(Locale.ENGLISH)
                .withTargetLanguage(Locale.FRENCH)
                .build();

        Assertions.assertNotNull(operation);
        Assertions.assertEquals(TEXT_SOURCE, operation.getText());
        Assertions.assertEquals(Locale.ENGLISH, operation.getSourceLanguage());
        Assertions.assertEquals(Locale.FRENCH, operation.getTargetLanguage());
        Assertions.assertEquals(TranslationOperationType.TRANSLATE, operation.getOperationType());
        Assertions.assertEquals(TranslationOperationStatusType.CREATED, operation.getStatusType());
        Assertions.assertNull(operation.getApiVersion());
    }

    @Test
    @DisplayName("Should validate the creation of a translation detect operation")
    void shouldValidateEntityCreationForTranslationOperationDetect()
    {
        TranslationOperationDetect operation = TranslationOperationDetect.builder()
                .withText(TEXT_SOURCE)
                .build();

        Assertions.assertNotNull(operation);
        Assertions.assertEquals(TEXT_SOURCE, operation.getText());
        Assertions.assertEquals(TranslationOperationType.DETECT, operation.getOperationType());
        Assertions.assertEquals(TranslationOperationStatusType.CREATED, operation.getStatusType());
        Assertions.assertNull(operation.getApiVersion());
    }

    @Test
    @DisplayName("Should validate the creation of a translation get supported languages operation")
    void shouldValidateEntityCreationForTranslationOperationSupportedLanguages()
    {
        TranslationOperationSupportedLanguages operation = TranslationOperationSupportedLanguages.builder()
                .withTargetLanguage(Locale.GERMAN)
                .build();

        Assertions.assertNotNull(operation);
        Assertions.assertNull(operation.getText());
        Assertions.assertEquals(TranslationOperationType.SUPPORTED_LANGUAGES, operation.getOperationType());
        Assertions.assertEquals(Locale.GERMAN, operation.getTargetLanguage());
        Assertions.assertEquals(TranslationOperationStatusType.CREATED, operation.getStatusType());
        Assertions.assertNull(operation.getApiVersion());
    }
}