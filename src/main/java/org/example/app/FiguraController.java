package org.example.app;

import org.example.figuras.Figura;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@Controller  // <- Para renderizar HTML
@RequestMapping("/figuras")
public class FiguraController {

    // Página principal (index.html)
    @GetMapping("/")
    public String index() {
        return "index"; // Busca src/main/resources/templates/index.html
    }

    // Crear figura Java desde parámetros
    @GetMapping("/crearJava")
    @ResponseBody
    public String crearFiguraJava(
            @RequestParam String tipo,
            @RequestParam String params
    ) {
        // Convertir params (String) a double[]
        double[] valores = Arrays.stream(params.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Object[] parametros = Arrays.stream(valores).boxed().toArray();
        Figura f = FiguraFactory.crearFigura(tipo, parametros);
        if (f == null) return "No se pudo crear la figura.";

        return tipo + " creada!\nÁrea: " + f.calcularArea() +
                "\nPerímetro: " + f.calcularPerimetro();
    }

    // Crear figura Groovy desde código y parámetros
    @PostMapping("/crearGroovy")
    @ResponseBody  // Para devolver texto plano
    public String crearFiguraGroovy(
            @RequestParam String codigo,
            @RequestParam String params
    ) {
        double[] valores = Arrays.stream(params.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Object[] parametros = Arrays.stream(valores).boxed().toArray();

        Figura f = GroovyFiguraFactory.crearFiguraDesdeGroovy(codigo, parametros);
        if (f == null) return "No se pudo crear la figura Groovy.";

        return "Figura Groovy creada!\nÁrea: " + f.calcularArea() + "\nPerímetro: " + f.calcularPerimetro();
    }
}
