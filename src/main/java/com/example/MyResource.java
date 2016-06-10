package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Вот это как раз такой класс с конфигурацией
 * Конфигурация задается через аннотаци
 * Аннотации это что с собакой @Annotation
 */
@Path("myresource")
// Эта говорит, что будет принимать запросы, пришедшие на /myresource. я это знаю)
// Отлично
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
    // Дальше должно быть понятно тоже

    // Ща я пару минут добавлю тебе ин-мемори базу данных
}
