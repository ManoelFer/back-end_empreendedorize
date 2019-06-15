package com.manoelneto.empreendedorize.ws.services.exception;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException (String message){
        super(message);
    }
}
