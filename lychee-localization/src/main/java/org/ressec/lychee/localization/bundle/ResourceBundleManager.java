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
package org.ressec.lychee.localization.bundle;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.NonNull;
import lombok.Synchronized;
import lombok.extern.log4j.Log4j2;
import org.reflections.ReflectionUtils;
import org.ressec.avocado.core.exception.checked.StringExpanderException;
import org.ressec.avocado.core.exception.unchecked.AnnotationException;
import org.ressec.avocado.core.exception.unchecked.NotImplementedException;
import org.ressec.avocado.core.helper.ReflectionHelper;
import org.ressec.avocado.core.helper.StringExpander;
import org.ressec.lychee.localization.base.Localizable;
import org.ressec.lychee.localization.base.LocalizationException;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.base.Rope;
import org.ressec.lychee.translation.base.TranslationException;
import org.ressec.lychee.translation.base.operation.TranslationOperationDetect;
import org.ressec.lychee.translation.base.operation.TranslationOperationSupportedLanguages;
import org.ressec.lychee.translation.base.operation.TranslationOperationTranslate;
import org.ressec.lychee.translation.base.processor.ITranslationProcessor;
import org.ressec.lychee.translation.base.request.ITranslationRequest;
import org.ressec.lychee.translation.base.request.TranslationRequest;
import org.ressec.lychee.translation.engine.google.version.v1.GoogleTranslationProcessorVersion1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A resource bundle manager (singleton) that serves as a central and unique access point to manage resource bundles.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Log4j2
public final class ResourceBundleManager
{
    /**
     * Creates the unique (per JVM) instance of the singleton.
     */
    private static final ResourceBundleManager instance = new ResourceBundleManager();

    /**
     * Resource bundle manager current locale.
     */
    @Getter
    private Locale locale;

    /**
     * Resource bundle manager default locale.
     */
    @Getter
    private Locale defaultLocale;

    /**
     * Collection of resource bundles (k = locale, v = Resource bundle name, w = Resource bundle).
     */
    private final Map<Locale, Map<String, ResourceBundle>> bundles = new HashMap<>();

    /**
     * Returns the unique instance of the resource manager.
     * @return Resource manager instance.
     */
    public static ResourceBundleManager getInstance()
    {
        return instance;
    }

    /**
     * Avoid direct instantiation.
     */
    private ResourceBundleManager()
    {
        Locale.setDefault(Locale.ENGLISH); // Set the JVM default locale to english
        defaultLocale = Locale.ENGLISH; // Set the default locale of the manager.
        this.locale = defaultLocale; // Set the current locale of the manager.
    }

    /**
     * Sets the default locale to use.
     * @param locale Default locale to set.
     */
    @Synchronized
    public void setDefaultLocale(final @NonNull Locale locale)
    {
        if (defaultLocale != locale)
        {
            defaultLocale = locale;
            log.info(String.format(
                    "Default locale changed to language(tag=%s, name=%s)",
                    defaultLocale,
                    defaultLocale.getDisplayLanguage(Locale.ENGLISH)));
            this.locale = defaultLocale;
        }
    }

    /**
     * Sets the default locale to use.
     * @param locale Default locale to set.
     */
    @Synchronized
    public void setLocale(final @NonNull Locale locale)
    {
        this.locale = locale;
        log.info(String.format(
                "Current locale changed to language(tag=%s, name=%s)",
                locale,
                locale.getDisplayLanguage(Locale.ENGLISH)));
    }

    /**
     * Loads and register a resource bundle using the default locale.
     * @param filePath Resource bundle path.
     */
    public void load(final @NonNull String filePath)
    {
        load(filePath, null);
    }

    /**
     * Loads a resource bundle or a set of resource bundles.
     * <br>
     * If locale is set to null, all available resource bundle properties files will be loaded
     * If locale is not null, only the matching resource bundle properties file will be loaded
     * @param filePath Resource bundle path.
     * @param locale Locale.
     */
    public void load(final @NonNull String filePath, final Locale locale)
    {
        boolean exist = false;

        if (locale != null)
        {
            try
            {
                add(filePath,locale);
                exist = true;
            }
            catch (Exception e)
            {
                // Do nothing!
            }
        }
        else
        {
            for (Locale current : getFilteredLocales())
            {
                try
                {
                    add(filePath,current);
                    exist = true;
                }
                catch (Exception e)
                {
                    // Do nothing!
                }
            }
        }

        if (!exist)
        {
            // Inform the specified bundle file has not been found at all!
            throw new ResourceBundleException(String.format("Resource bundle file: '%s' cannot be found for any locale!", filePath));
        }
    }

    /**
     * Returns a list of filtered {@link Locale} based on a range of authorized languages.
     * @return List of filtered {@link Locale}.
     */
    private List<Locale> getFilteredLocales()
    {
        final String languagesPriorityRange = "en;q=1.0,fr;q=0.5,de;q=0.5,it;q=0.5,es;q=0.5,ja;q=0.5,af;q=0.5," +
                "ar;q=0.5,bg;q=0.5,cs;q=0.5,da;q=0.5,el;q=0.5,et;q=0.5,fi;q=0.5,hi;q=0.5,hu;q=0.5,iw;q=0.5,ko;q=0.5," +
                "nl;q=0.5,no;q=0.5,pl;q=0.5,pt;q=0.5,ro;q=0.5,ru;q=0.5,sq;q=0.5,th;q=0.5,tr;q=0.5,zh;q=0.5";

        List<String> listWithDuplicates = new ArrayList<>();
        // Get only locales for languages
        for (Locale current : Locale.getAvailableLocales())
        {
            listWithDuplicates.add(current.getLanguage());
        }

        // Remove duplicates
        List<String> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());

        List<Locale.LanguageRange> languageRanges = Locale.LanguageRange.parse(languagesPriorityRange);
        List<String> filtered = Locale.filterTags(languageRanges, listWithoutDuplicates);

        return filtered.stream().map(Locale::forLanguageTag).collect(Collectors.toList());
    }

    /**
     * Adds a resource bundle to the collection of managed resource bundles.
     * @param filePath Resource bundle path and name.
     * @param locale Locale.
     */
    private void add(final @NonNull String filePath, final @NonNull Locale locale)
    {
        ResourceBundle bundle = ResourceBundle.getBundle(filePath, locale);
        bundles.computeIfAbsent(
                Locale.forLanguageTag(locale.getLanguage()),
                function -> Maps.newHashMap()).put(filePath, bundle);
    }

    /**
     * Retrieves a resource bundle entry key for the default locale.
     * @param key Resource bundle entry key.
     * @return Value of the resource bundle entry.
     */
    public String get(final @NonNull String key)
    {
        return get(key, locale);
    }

    /**
     * Retrieves a resource bundle entry key for the given locale.
     * @param key Resource bundle entry key.
     * @param locale Locale.
     * @return Value of the resource bundle entry.
     */
    public String get(final @NonNull String key, final @NonNull Locale locale)
    {
        return lookup(key, locale);
    }

    /**
     * Retrieves a resource bundle entry key for the given bundle and locale.
     * @param bundle Resource bundle path name.
     * @param key Resource bundle entry key.
     * @param locale Locale.
     * @return Value of the resource bundle entry.
     */
    public String get(final @NonNull String bundle, final @NonNull String key, final @NonNull Locale locale)
    {
        load(bundle, locale);
        return lookup(key,locale);
    }

//    /**
//     * Retrieves a resource bundle entry key for the given bundle, locale and object instance.
//     * @param bundle Resource bundle path name.
//     * @param key Resource bundle key.
//     * @param locale Locale.
//     * @param instance Instance of object containing the values of the variables to substitute in {@code bundle} and {@code key}.
//     * @return Localized text.
//     * @throws LocalizationException Thrown in case an error occurred during variable expansion of annotation parameters.
//     */
//    public String get(final @NonNull String bundle, final @NonNull String key, final @NonNull Locale locale, final Object instance)
//    {
//        try
//        {
//            load(StringExpander.expandVariables(instance, bundle), locale);
//            return lookup(StringExpander.expandVariables(instance, key), locale);
//        }
//        catch (StringExpanderException e)
//        {
//            throw new LocalizationException(e);
//        }
//    }

    /**
     * Lookups for the first matching resource bundle entry in registered resource bundles.
     * @param key Resource bundle entry key.
     * @param locale Locale.
     * @return Value of the resource bundle entry.
     */
    private String lookup(final @NonNull String key, final @NonNull Locale locale)
    {
        if (bundles.isEmpty())
        {
            throw new ResourceBundleException(String.format(
                    "No resource bundle found containing key: '%s' for locale: '%s'. Try loading the resource bundle first using one of the ResourceBundleManager#load services!",
                    key,
                    locale));
        }

        Locale currentLocale = Locale.forLanguageTag(locale.getLanguage());

        Map<String, ResourceBundle> elements = bundles.get(currentLocale);
        for (ResourceBundle bundle : elements.values())
        {
            if (!currentLocale.getDisplayLanguage().equals(locale.getDisplayLanguage()))
            {
                log.warn(String.format("No resource bundle: '%s' for language(tag: '%s', language: '%s') found!",
                        bundle.getBaseBundleName(), locale.toLanguageTag(), locale.getDisplayLanguage()));
            }

            if (bundle.containsKey(key))
            {
                return bundle.getString(key);
            }
            else
            {
                loadBundle(bundle, locale);
                if (bundle.containsKey(key))
                {
                    return bundle.getString(key);
                }
            }
        }

        throw new ResourceBundleException(String.format("Resource key: '%s' for locale: '%s' not found!", key, locale));
    }

    /**
     * Loads a resource bundle (if absent).
     * @param bundle Resource bundle.
     * @param locale Locale.
     */
    private void loadBundle(final @NonNull ResourceBundle bundle, final @NonNull Locale locale)
    {
        try
        {
            load(bundle.getBaseBundleName(), locale);
        }
        catch (Exception e)
        {
            // Do nothing!
        }
    }

    /**
     * Resolves the localization of an element annotated with the {@link Localize} annotation.
     * @param instance Object instance (containing the element to localize).
     * @param locale Locale.
     * @return Localized value.
     */
    public String resolve(final @NonNull Object instance, final Locale locale)
    {
        Method method;

        // Invoked from an enumeration?
        if (instance instanceof Enum)
        {
            return resolveEnum(instance, locale);
        }
        else
        {
            // Invoked from a normal class that should implement the Localizable interface.
            method = getCallerMethod();
            if (method == null)
            {
                try
                {
                    throw new AnnotationException(String.format(
                            "Service 'ResourceBundleManager#resolve' invoked from a class not being an enum nor from an annotated method! Please check class: '%s'",
                            instance.getClass().getDeclaringClass().getName()));
                }
                catch (NullPointerException e)
                {
                    throw new AnnotationException(String.format(
                            "Service 'ResourceBundleManager#resolve' invoked from a class not being an enum nor from an annotated method! Please check class: '%s'",
                            instance.getClass().getName()));
                }
            }
        }

        return resolveMethod(instance,method,locale);
    }

    /**
     * Retrieves the given key from the given resource bundle path.
     * @param filePath Resource bundle path and name.
     * @param key Key.
     * @param locale Locale.
     * @return Localized value.
     */
    private String getKey(final @NonNull String filePath, final @NonNull String key, final @NonNull Locale locale)
    {
        ResourceBundle bundle;
        Locale currentLocale = locale;
        Locale oldLocale = currentLocale;

        // Ensure the resource bundles are loaded
        load(filePath);

        Map<String, ResourceBundle> elements = bundles.get(currentLocale);
        if (elements != null)
        {
            bundle = elements.get(filePath);
            if (bundle != null)
            {
                if (!bundle.getLocale().toLanguageTag().equals(currentLocale.toLanguageTag()))
                {
                    currentLocale = this.locale;

                    log.warn(String.format("No resource bundle(name=%s, key=%s) for language(tag=%s, name=%s) found! Use of the default language(tag=%s, name=%s) instead",
                            filePath,
                            key,
                            oldLocale,
                            oldLocale.getDisplayLanguage(Locale.ENGLISH),
                            currentLocale,
                            currentLocale.getDisplayLanguage(Locale.ENGLISH)));

                    return getKey(filePath, key, currentLocale);
                }

                try
                {
                    return bundle.getString(key);
                }
                catch (MissingResourceException e)
                {
                    throw new ResourceBundleException(
                            String.format(
                                    "Can't find resource bundle(name=%s, key=%s) for language(tag=%s, name=%s)",
                                    filePath,
                                    key,
                                    currentLocale,
                                    currentLocale.getDisplayLanguage(Locale.ENGLISH)));
                }
            }
        }
        else
        {
            // In this case, no resource bundle exist for the given locale! Try another locale...
            currentLocale = getFallbackLocale(currentLocale);

            log.debug(String.format("No resource bundle(name=%s, key=%s) for language(tag=%s, name=%s) found! Use of the default language(tag=%s, name=%s) instead",
                    filePath,
                    key,
                    oldLocale,
                    oldLocale.getDisplayLanguage(Locale.ENGLISH),
                    currentLocale,
                    currentLocale.getDisplayLanguage(Locale.ENGLISH)));
        }

        return getKey(filePath, key, currentLocale);
    }

    private Locale getFallbackLocale(final @NonNull Locale locale)
    {
        Locale current = locale;

        if (locale != this.locale)
        {
           current = this.locale; // Fallback scenario #1 Try the ResourceBundleManager current locale.
        }
        else
        {
            if (current == defaultLocale)
            {
                current = Locale.getDefault(); // Fallback scenario #3 Try the ResourceBundleManager JVM locale.
            }
            else
            {
                current = defaultLocale; // Fallback scenario #2 Try the ResourceBundleManager default locale.
            }
        }

        return current;
    }

    /**
     * Clears the loaded resource bundles.
     */
    public final void clear()
    {
        bundles.clear();
    }

    /**
     * Resolves entities implementing the {@link Localizable} interface.
     * @param instance Object instance containing elements to localize.
     * @param locale Locale.
     */
    public void resolveLocalizable(final @NonNull Object instance, final Locale locale)
    {
        // Resolve annotated fields
        resolveFields(instance, locale);

        // Resolve caller method if annotated
        Method method = getCallerMethod();
        if (method != null && method.isAnnotationPresent(Localize.class))
        {
            resolveMethod(instance,method,locale);
        }
    }

    /**
     * Resolves {@link Rope} entities.
     * @param instance Object instance.
     * @param reference Reference object.
     * @param locale Locale.
     */
    public void resolveRope(final @NonNull Object instance, final Object reference, final Locale locale)
    {
        if (instance instanceof Rope)
        {
            Rope element = (Rope) instance;
            if (element.getBundle() != null && element.getKey() != null)
            {
                String expandedBundle;
                String expandedKey;
                Field field;
                try
                {
                    field = instance.getClass().getDeclaredField("value");
                    field.setAccessible(true);
                    expandedBundle = StringExpander.expandVariables(reference != null ? reference : instance, element.getBundle());
                    expandedKey = StringExpander.expandVariables(reference != null ? reference : instance, element.getKey());
                    String translated = get(expandedBundle, expandedKey, locale);
                    field.set(instance, translated);
                }
                catch (NoSuchFieldException | IllegalAccessException | StringExpanderException e)
                {
                    e.printStackTrace(); // TODO Log and Throw an exception!
                }
            }
            else if (element.getKey() != null) // No bundle specified, the resource bundle should be already loaded!
            {
                String expandedKey;
                Field field;
                try
                {
                    field = instance.getClass().getDeclaredField("value");
                    field.setAccessible(true);
                    expandedKey = StringExpander.expandVariables(reference != null ? reference : instance, element.getKey());
                    //String translated = get(expandedKey, locale);

                    Optional<String> result = findBundle(expandedKey);
                    if (result.isPresent())
                    {
                        field.set(instance, getKey(result.get(), expandedKey, locale));
                    }
                    else
                    {
                        // TODO Do we throw an exception?
                    }
                }
                catch (NoSuchFieldException | IllegalAccessException | StringExpanderException e)
                {
                    e.printStackTrace(); // TODO Log and Throw an exception!
                }
            }
        }
    }

    /**
     * Finds in the collection of resource bundles if one contains the given key.
     * @param key Key to find.
     * @return Optional containing the resource bundle name containing the key.
     */
    private Optional<String> findBundle(final @NonNull String key)
    {
        Map<String, ResourceBundle> map = bundles.get(Locale.ENGLISH);

        if (map != null)
        {
            for (Map.Entry<String, ResourceBundle> entry : map.entrySet())
            {
                if (entry.getValue().containsKey(key))
                {
                    return Optional.of(entry.getKey());
                }
            }
        }

        return Optional.empty();
    }
    
    /**
     * Resolves localization of all fields annotated with the {@link Localize} annotation.
     * @param instance Object instance.
     * @param locale Locale.
     */
    private void resolveFields(final @NonNull Object instance, final Locale locale)
    {
        Localize annotation;
        Rope rope;

        List<Field> fields = ReflectionHelper.findAnnotatedFieldsInClassHierarchy(instance.getClass(), Localize.class);
        for (Field field : fields)
        {
            annotation = field.getDeclaredAnnotation(Localize.class);

            try
            {
                field.setAccessible(true);
                if (field.get(instance) instanceof Rope)
                {
                    rope = (Rope) field.get(instance);
                    if (rope != null)
                    {
                        if (rope.getValue() == null && rope.getBundle() == null && rope.getKey() == null)
                        {
                            resolveField(instance, annotation, field, locale);
                        }
                        else
                        {
                            resolveRopeAnnotatedField(instance,field, annotation, locale);
                        }
                    }
                }
                else if (Localizable.class.isAssignableFrom(field.getDeclaringClass()))
                {
                    if (annotation != null)
                    {
                        if (field.getType() == String.class)
                        {
                            resolveField(instance, annotation, field, locale);
                        }
                        else if (field.getType() == Rope.class)
                        {
                            rope = (Rope) field.get(instance);
                            if (rope != null)
                            {
                                if (rope.getValue() == null && rope.getBundle() == null && rope.getKey() == null)
                                {
                                    resolveField(instance, annotation, field, locale);
                                }
                                else
                                {
                                    resolveRopeAnnotatedField(instance,field, annotation, locale);
                                }
                            }
                        }
                    }
                    else
                    {
                        throw new NotImplementedException(""); // TODO Fix this!
                    }
                }

            }
            catch (IllegalAccessException | NoSuchFieldException e)
            {
                throw new LocalizationException(e);
            }
        }
    }

    private void resolveRopeAnnotatedField(final @NonNull Object instance, final @NonNull Field field, final @NonNull Localize annotation, final @NonNull Locale locale) throws IllegalAccessException, NoSuchFieldException
    {
        String expandedBundle;
        String expandedKey;
        Field value;
        Rope rope = (Rope) field.get(instance);

        value = field.get(instance).getClass().getDeclaredField("value");
        value.setAccessible(true);

        if (rope.getBundle() != null && rope.getKey() != null)
        {
            try
            {
                expandedBundle = StringExpander.expandVariables(instance, rope.getBundle());
                expandedKey = StringExpander.expandVariables(instance, rope.getKey());
            }
            catch (StringExpanderException e)
            {
                throw new LocalizationException(e);
            }
        }
        else
        {
            try
            {
                expandedBundle = StringExpander.expandVariables(instance, annotation.bundle());
                expandedKey = StringExpander.expandVariables(instance, annotation.key());
            }
            catch (StringExpanderException e)
            {
                throw new LocalizationException(e);
            }
        }

        String translated = get(expandedBundle, expandedKey, locale);
        value.set(rope, translated); // TODO Fix this by accessing the setter!
    }

    /**
     * Resolves localization for the given method annotated with the {@link Localize} annotation.
     * @param instance Object instance (containing the method).
     * @param method Method instance.
     * @param locale Locale.
     * @return Localized value.
     */
    private String resolveMethod(final @NonNull Object instance, final @NonNull Method method, final @NonNull Locale locale)
    {
        Localize annotation = method.getAnnotation(Localize.class);

        if (annotation.key().isEmpty())
        {
            throw new AnnotationException(
                    String.format(
                            "Method: '%s' of class: '%s' annotated with: '%s' must have the property: 'key' set!",
                            method.getName(),
                            instance.getClass().getName(),
                            Localize.class.getName()));
        }

        if (annotation.bundle().isEmpty())
        {
            throw new AnnotationException(
                    String.format(
                            "Method: '%s' of class: '%s' annotated with: '%s' must have the property: 'bundle' set!",
                            method.getName(),
                            instance.getClass().getName(),
                            Localize.class.getName()));
        }

        // Do the variables substitution (if some) for the 'bundle' and the 'key' properties.
        String key = null;
        String bundle = null;
        try
        {
            key = StringExpander.expandVariables(instance, annotation.key());
            bundle = StringExpander.expandVariables(instance, annotation.bundle());
        }
        catch (StringExpanderException e)
        {
            throw new LocalizationException(e);
        }

        return getKey(bundle, key, Locale.forLanguageTag(locale.getLanguage()));
    }

    /**
     * Resolves localization for the given enumeration annotated with the {@link Localize} annotation.
     * @param instance Object instance.
     * @param locale Locale.
     * @return Localized value.
     */
    private String resolveEnum(final @NonNull Object instance, final Locale locale)
    {
        Class<?> declaringClass = ((Enum<?>) instance).getDeclaringClass();

        // An enum MUST not implement the localizable interface!
        if (Localizable.class.isAssignableFrom(declaringClass))
        {
            throw new LocalizationException(
                    String.format(
                            "Class: '%s' is an enum class that cannot implement the: '%s' interface!",
                            instance.getClass(), Localizable.class));
        }

        Method method = getCallerMethod();
        if (method != null)
        {
            return resolveMethod(instance, method, locale);
        }
        else
        {
            // Does the enumeration class itself is annotated with the Localization annotation?
            if (declaringClass.isAnnotationPresent(Localize.class))
            {
                return resolveEnumeratedValue(instance, locale);
            }
            else
            {
                throw new AnnotationException(
                        String.format(
                                "Object of type: '%s' is an enum class that should be annotated with: '%s' annotation!",
                                declaringClass.getSimpleName(), Localize.class.getSimpleName()));
            }
        }
    }

    /**
     * Resolves localization for the given enumerated value.
     * @param instance Object instance (containing the enumerated value).
     * @param locale Locale.
     * @return Localized value.
     */
    private String resolveEnumeratedValue(final @NonNull Object instance, final Locale locale)
    {
        Localize annotation = ((Enum<?>) instance).getDeclaringClass().getAnnotation(Localize.class);

        // Ensure the resource bundle properties files are loaded
        load(annotation.bundle());

        try
        {
            return getKey(
                    StringExpander.expandVariables(instance, annotation.bundle()),
                    StringExpander.expandVariables(instance, annotation.key()), locale);
        }
        catch (StringExpanderException e)
        {
            throw new LocalizationException(e);
        }
    }

    /**
     * Resolves localization of the given field annotated with the {@link Localize} annotation.
     * @param instance Object instance.
     * @param annotation Annotation instance.
     * @param field Field instance.
     * @param locale Locale.
     */
    private void resolveField(final @NonNull Object instance, final @NonNull Localize annotation, final @NonNull Field field, final @NonNull Locale locale)
    {
        String value;
        String bundle;
        String key;

        if (annotation.key().isEmpty())
        {
            throw new AnnotationException(
                    String.format(
                            "Field: '%s' of class: '%s' annotated with: '%s' must have the property: 'key' set!",
                            field.getName(),
                            instance.getClass().getName(),
                            Localize.class.getName()));
        }

        if (annotation.bundle().isEmpty())
        {
            throw new AnnotationException(
                    String.format(
                            "Field: '%s' of class: '%s' annotated with: '%s' must have the property: 'bundle' set!",
                            field.getName(),
                            instance.getClass().getName(),
                            Localize.class.getName()));
        }

        // Do the variables substitution (if some) for the 'bundle' and the 'key' properties.
        try
        {
            key = StringExpander.expandVariables(instance, annotation.key());
            bundle = StringExpander.expandVariables(instance, annotation.bundle());

            value = getKey(bundle, key, locale);
            setFieldValue(instance, field, value);
        }
        catch (StringExpanderException e)
        {
            throw new LocalizationException(e);
        }
    }

    /**
     * Sets dynamically the value of a given field.
     * @param instance Object instance (containing the field).
     * @param field Field instance.
     * @param value Value to set.
     */
    private void setFieldValue(final @NonNull Object instance, final @NonNull Field field, final @NonNull String value)
    {
        if (!field.canAccess(instance))
        {
            field.setAccessible(true);
        }

        try
        {
            field.set(instance, value); // TODO Fix this by accessing the setter instead!
        }
        catch (IllegalArgumentException e)
        {
            try
            {
                field.set(instance, Integer.valueOf(value)); // TODO Fix this by accessing the setter instead!
            }
            catch (IllegalAccessException iae)
            {
                throw new AnnotationException(iae);
            }
        }
        catch (IllegalAccessException ex)
        {
            throw new AnnotationException(ex);
        }
    }

    /**
     * Retrieves the caller method.
     * @return Caller method.
     */
    private Method getCallerMethod()
    {
        Class<?> clazz;

        for (StackTraceElement trace : Thread.currentThread().getStackTrace())
        {
            try
            {
                clazz = Class.forName(trace.getClassName());
                Method method = getCaller(clazz, trace);
                if (method != null)
                {
                    return method;
                }
            }
            catch (ClassNotFoundException e)
            {
                // Do nothing, just process the next trace!
            }
        }

        return null; // No method found annotated with I18n annotation!
    }

    /**
     * Finds the caller method (annotated with the Localization annotation).
     * @param clazz Class containing the method to evaluate.
     * @param trace Stack trace element containing the method name.
     * @return Found caller {@link Method}.
     */
    private Method getCaller(final @NonNull Class<?> clazz, final @NonNull StackTraceElement trace)
    {
        Method method;

        try
        {
            method = clazz.getMethod(trace.getMethodName());
            if (method.isAnnotationPresent(Localize.class))
            {
                return method;
            }

            // Do we have another method with the same name and that would be annotated?
            Set<Method> methods = ReflectionUtils.getAllMethods(method.getDeclaringClass(),
                    ReflectionUtils.withModifier(Modifier.PUBLIC),
                    ReflectionUtils.withPrefix(method.getName()));

            for (Method m : methods)
            {
                if (m.isAnnotationPresent(Localize.class))
                {
                    return m;
                }
            }
        }
        catch (NoSuchMethodException nsme)
        {
            try
            {
                // Maybe another method with a Locale parameter?
                method = clazz.getMethod(trace.getMethodName(), Locale.class);

                // We found our caller.
                if (method.isAnnotationPresent(Localize.class))
                {
                    return method;
                }
            }
            catch (NoSuchMethodException e)
            {
                // Do nothing, seems to be the wrong method!
            }
        }

        return null;
    }

    /**
     * Returns the number of locales loaded for the given resource bundle name.
     * @param name Resource bundle name.
     * @return Number of locales.
     */
    public int getLocalesCount(final @NonNull String name)
    {
        Map<String, ResourceBundle> list;
        int count = 0;

        for (Locale bundleLocale : bundles.keySet())
        {
            list = bundles.get(bundleLocale);
            if (list.containsKey(name))
            {
                count += 1;
            }
        }

        return count;
    }

    /**
     * Returns a list of locale loaded for the given resource bundle name.
     * @param name Resource bundle name.
     * @return List of locale.
     */
    public List<Locale> getLocalesList(final @NonNull String name)
    {
        Map<String, ResourceBundle> list;
        List<Locale> result = new ArrayList<>();

        for (Locale bundleLocale : bundles.keySet())
        {
            list = bundles.get(bundleLocale);
            if (list.containsKey(name))
            {
                result.add(bundleLocale);
            }
        }

        return result;
    }

    /**
     * Checks if the given bundle file name for the given locale is loaded?
     * @param name Resource bundle name.
     * @param locale Locale.
     * @return True if the given resource bundle name is loaded for the given locale, false otherwise.
     */
    public boolean existLocale(final @NonNull String name, final @NonNull Locale locale)
    {
        Locale criteria = Locale.forLanguageTag(locale.getLanguage());
        List<Locale> list = getLocalesList(name);

        return list.contains(criteria);
    }

    /**
     * Executes a translation request.
     * @param request Translation request to execute.
     * @return Translation request containing the result of the underlying translation operations.
     * @throws TranslationException Thrown in case an error occurred while executing the translation request.
     */
    @Synchronized
    public final Optional<ITranslationRequest> executeTranslationRequest(final @NonNull ITranslationRequest request) throws TranslationException
    {
        ITranslationProcessor processor = GoogleTranslationProcessorVersion1.builder()
                .withRequest(request)
                .build();

        processor.execute();

        return processor.getRequest(request.getName());
    }

    /**
     * Translates a text from a given language to a target language.
     * @param sourceLanguage Source language.
     * @param targetLanguage Target language.
     * @param text Text to translate.
     * @return Translation translate operation.
     * @throws TranslationException Thrown in case an error occurred while executing the translation operation.
     */
    @Synchronized
    public final TranslationOperationTranslate translate(final @NonNull Locale sourceLanguage, final @NonNull Locale targetLanguage, final @NonNull String text) throws TranslationException
    {
        ITranslationRequest request = new TranslationRequest("translate");
        request.addOperation(TranslationOperationTranslate.builder()
                .withText(text)
                .withSourceLanguage(sourceLanguage)
                .withTargetLanguage(targetLanguage)
                .build());

        request = executeTranslationRequest(request).get();

        return (TranslationOperationTranslate) request.getOperations().get(0); // Only one translation operation
    }

    /**
     * Translates a text from a given language to a target language.
     * @param targetLanguage Target language.
     * @param text Text to translate.
     * @return Translation translate operation.
     * @throws TranslationException Thrown in case an error occurred while executing the translation operation.
     */
    @Synchronized
    public final TranslationOperationTranslate translate(final @NonNull Locale targetLanguage, final @NonNull String text) throws TranslationException
    {
        ITranslationRequest request = new TranslationRequest("translate");
        request.addOperation(TranslationOperationTranslate.builder()
                .withText(text)
                .withTargetLanguage(targetLanguage)
                .build());

        request = executeTranslationRequest(request).get();

        return (TranslationOperationTranslate) request.getOperations().get(0); // Only one translation operation
    }

    /**
     * Detects the language of the given text.
     * @param text Text to detect.
     * @return Translation detect operation.
     * @throws TranslationException Thrown in case an error occurred while executing the translation operation.
     */
    @Synchronized
    public final TranslationOperationDetect detect(final @NonNull String text) throws TranslationException
    {
        ITranslationRequest request = new TranslationRequest("detect");
        request.addOperation(TranslationOperationDetect.builder()
                .withText(text)
                .build());

        request = executeTranslationRequest(request).get();

        return (TranslationOperationDetect) request.getOperations().get(0); // Only one detect operation
    }

    /**
     * Detects the language of the given text.
     * @param language Language from which other translations are supported.
     * @return Translation supported languages operation (containing list of supported languages).
     * @throws TranslationException Thrown in case an error occurred while executing the translation operation.
     */
    @Synchronized
    public final TranslationOperationSupportedLanguages getSupportedLanguage(final @NonNull Locale language) throws TranslationException
    {
        ITranslationRequest request = new TranslationRequest("supported");
        request.addOperation(TranslationOperationSupportedLanguages.builder()
                .withTargetLanguage(language)
                .build());

        request = executeTranslationRequest(request).get();

        return (TranslationOperationSupportedLanguages) request.getOperations().get(0); // Only one detect operation
    }
}