package com.fullcycle.admin.catalogo.application;

import com.fullcycle.admin.catalogo.domain.category.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {
    @Test
    public void testCreateUseCase() {
        Assertions.assertInstanceOf(UseCase.class, new UseCase().execute());
    }
}