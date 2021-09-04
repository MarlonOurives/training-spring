package br.com.training.exceptions;

import br.com.training.util.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
