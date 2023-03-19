package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.category.Category;
import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CategoryTest {
    @Test
    public void testCreateNewCategoryWithSuccess() {
        // GIVEN
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        // WHEN
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        // THEN
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void testCreateNewCategoryWithValidationErrorNameNull() {
        // GIVEN
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        // WHEN
        final var actualCategory = Category.newCategory(null, expectedDescription, expectedIsActive);

        // THEN
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void testCreateNewCategoryWithValidationErrorNameEmpty() {
        // GIVEN
        final var expectedName = "";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        // WHEN
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        // THEN
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void testCreateNewCategoryWithValidationErrorNameLessThan3() {
        // GIVEN
        final var expectedName = "RA ";
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        // WHEN
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        // THEN
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void testCreateNewCategoryWithValidationErrorNameBiggerThan255() {
        // GIVEN
        final var expectedName = """
                lorenASHD ASJD Asd=asdjik asdasjkld asd aslkd asçd asçldçlas dlçaskçdkasçdl kasçd kasçld kasçldk çasldk açsdkaslçd kasçdkaçsdk
                lorenASHD ASJD Asd=asdjik asdasjkld asd aslkd asçd asçldçlas dlçaskçdkasçdl kasçd kasçld kasçldk çasldk açsdkaslçd kasçdkaçsdk
                lorenASHD ASJD Asd=asdjik asdasjkld asd aslkd asçd asçldçlas dlçaskçdkasçdl kasçd kasçld kasçldk çasldk açsdkaslçd kasçdkaçsdk
                """;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        // WHEN
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        // THEN
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void testCreateNewCategoryWithSuccessEmptyDescription() {
        // GIVEN
        final var expectedName = "Filmes";
        final var expectedDescription = " ";
        final var expectedIsActive = true;

        // WHEN
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        // THEN
        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void testCreateNewCategoryWithSuccessFalseActive() {
        // GIVEN
        final var expectedName = "Filmes";
        final var expectedDescription = " ";
        final var expectedIsActive = false;

        // WHEN
        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        // THEN
        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNotNull(actualCategory.getDeletedAt());
    }
}