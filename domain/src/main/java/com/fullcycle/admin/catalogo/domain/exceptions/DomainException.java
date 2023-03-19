package com.fullcycle.admin.catalogo.domain.exceptions;

import com.fullcycle.admin.catalogo.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStacktraceException {
    private final List<Error> errors;

    private DomainException(final List<Error> anErrors) {
        super("");
        this.errors = anErrors;
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException(anErrors);
    }

    public static DomainException with(final Error anErrors) {
        return new DomainException(List.of(anErrors));
    }

    public List<Error> getErrors() {
        return errors;
    }
}
