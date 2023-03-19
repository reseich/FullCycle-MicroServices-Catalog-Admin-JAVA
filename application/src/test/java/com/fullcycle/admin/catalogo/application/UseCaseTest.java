package com.fullcycle.admin.catalogo.application;

import com.fullcycle.admin.catalogo.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {
    @Test
    public void testCreateUseCase() {
        Assertions.assertInstanceOf(Category.class, new UseCase().execute());
    }
}