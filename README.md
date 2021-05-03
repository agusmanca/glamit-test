# Test ingreso a Glamit

## Descripcion
El siguiente proyecto fue realizado en lenguaje java a partir del uso de Spring boot framwork.
Se uso tambien base de dato en memoria H2 junto con Jpa para el manejo de la capa de datos.
De acuerdo a lo planteado se uso el principio de POO (programación orientada a objetos).

### Tecnologia empleada
El siguiente proyecto fue realizado con:

    - Java 8
    - Spring Boot Framwork
    - Base de datos H2
 
Tambien resaltar el uso de las siguientes dependencias:
    
    - Swagger
    - Modelmapper
    - Jackson
    - Lombok

## Instalación
Para el uso del proyecto debera ejecutar desde consola el siguiete comando, ubicado en el root del proyecto.
(A fin de contar con todas las dependencias necesarias para la ejecución del mismo).

    - mvn clean install

### *Aclaración:
En el siguiente proyecto se hace uso del puerto 8080 por defecto. Asegurarse de que el mismo no este siendo usado por otra aplicación.

## Swagger:
El siguiente proyecto cuenta con documentacion en swagger. 
Para mayor facilidad en la prueba del proyecto, una vez levantado el mismo, dirigirse a la siguiente URL: 

    localhost:8080/swagger-ui.html

## Desarrollo
El proyecto cuenta con los siguientes endpoints:

### Metodos de verbo GET
```
    http://localhost:8080/product?page={Número de página} --> Obtener la lista de productos.

    http://localhost:8080/product?page={Número de página}&sku={Código Sku} --> Obtener un porducto filtrado por 'Sku'.

    http://localhost:8080/category --> Obtener lista de categorias.

    http://localhost:8080/category/{ID de categoria} --> Buscar una categoria filtrada por ID.
```

### Metodos de verbo POST
```
http://localhost:8080/product/create --> Permite crear un nuevo producto.
```

En este último caso es necesario mandar por payload el contenido del nuevo producto. 

Ejemplo:
```
{
    "name": "producto H",
    "category":1,
    "price":9.90,
    "imgUrl":"",
    "sku":"USd002sWhYSDn12"
}
```

Como asi tambien es necesario firmar el header con un código de authorizacion codificado en base64.
(No se uso método de autenticacion basado en JWT ni similares. Solo se uso un interceptor.)

```
Authorization: Bearer R2xhbWl0VXNlclNpZ24=
```

Para codificar firmas puede hacerse uso de la siguiente página:

https://www.convertstring.com/es/EncodeDecode/Base64Encode


