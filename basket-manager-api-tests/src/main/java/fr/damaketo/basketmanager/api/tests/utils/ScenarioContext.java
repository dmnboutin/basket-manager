package fr.damaketo.basketmanager.api.tests.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Scenario context is instancied for each scenario.
 * It provides a unique correlation id and methods to store data and retrieve them during the scenario execution.
 *
 * @author pierre_pedron
 */
@Component
@Scope("cucumber-glue")
public class ScenarioContext {

    /**
     * Data store
     */
    private Map<String, Object> dataStore = new HashMap<>();

    /**
     * Store data identified by the specified key in context
     *
     * @param key  key
     * @param data data
     */
    public void put(String key, Object data) {
        dataStore.put(key, data);
    }

    /**
     * Returns data stored for the specified key and cast it to the specified class
     *
     * @param key   key
     * @param clazz expected value class
     * @param <T>   type
     * @return data
     */
    public <T> T get(String key, Class<T> clazz) {
        final Object data = dataStore.get(key);
        return (T) data;
    }

    /**
     * Returns data stored for the specified key
     *
     * @param key key
     * @return data as object
     */
    public Object get(String key) {
        return dataStore.get(key);
    }

    /**
     * Removes data stored for the specified key
     *
     * @param key key
     * @return data as object
     */
    public Object remove(String key) {
        return dataStore.remove(key);
    }

    /**
     * Determines if context contains data identified by specified key
     *
     * @param key key
     * @return true or false
     */
    public boolean contains(String key) {
        return dataStore.containsKey(key);
    }

    /**
     * Determines if context contains data of the specified class and identified by specified key
     * @param key key
     * @param clazz class
     * @param <T> type
     * @return true or false
     */
    public <T> boolean containsKeyOfType(String key, Class<T> clazz) {
        return dataStore.containsKey(key) && dataStore.get(key).getClass().equals(clazz);
    }

    /**
     * Clear all data stored in context
     */
    public void clear() {
        dataStore.clear();
    }

}
