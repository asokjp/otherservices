package com.wellpoint.microservices.services.service.api;

/**
 * 
 * Response object for the Consumer service
 *
 */
public class HelloWorldResponse extends ResponseSimple {

    transient private static final long serialVersionUID = 4947254632135696832L;

    private String helloWorld;

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("|[HELLO_WORLD]:").append(helloWorld);
        return sb.toString();
    }

}
