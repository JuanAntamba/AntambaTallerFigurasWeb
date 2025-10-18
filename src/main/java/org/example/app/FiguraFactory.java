package org.example.app;

import org.example.figuras.Figura;
import java.lang.reflect.Constructor;

public class FiguraFactory {
    public static Figura crearFigura(String nombreClase, Object... params) {
        try {
            Class<?> clase = Class.forName("org.example.figuras." + nombreClase);
            for (Constructor<?> c : clase.getConstructors()) {
                if (c.getParameterCount() == params.length) {
                    return (Figura) c.newInstance(params);
                }
            }
            throw new IllegalArgumentException("No se encontró un constructor compatible para " + nombreClase);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
