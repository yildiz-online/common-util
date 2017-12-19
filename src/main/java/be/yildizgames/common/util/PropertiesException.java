package be.yildizgames.common.util;

import be.yildizgames.common.exception.technical.TechnicalException;

public class PropertiesException extends TechnicalException {

    PropertiesException(String message, Exception cause) {
        super(message, cause);
    }

    PropertiesException(Exception cause) {
        super(cause);
    }

    PropertiesException(String s) {
        super(s);
    }
}
