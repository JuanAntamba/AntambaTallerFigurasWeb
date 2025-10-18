package org.example.app;

import org.example.figuras.Figura;
import groovy.lang.GroovyClassLoader;
import java.lang.reflect.Constructor;

public class GroovyFiguraFactory {
    public static Figura crearFiguraDesdeGroovy(String codigo, Object... params) {
        try {
            GroovyClassLoader loader = new GroovyClassLoader();
            Class<?> clase = loader.parseClass(codigo); // Compila el código Groovy
            Constructor<?> constructor = clase.getConstructors()[0];
            return (Figura) constructor.newInstance(params);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
