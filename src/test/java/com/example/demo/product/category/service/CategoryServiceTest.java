package com.example.demo.product.category.service;

import com.example.demo.product.category.dto.CategoryDto;
import com.example.demo.product.category.entity.Category;
import com.example.demo.product.category.repository.CategoryRepo;
import com.example.demo.service.InitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("category 생성 확인")
    void saveCategory_shouldCallRepoSave() {
        Category category = Category.builder()
                .id("1")
                .categoryName("Electronics")
                .build();

        categoryService.saveCategory(category);

        // 1회 수행 검증
        verify(categoryRepo, times(1)).save(category);
    }

    @Test
    @DisplayName("category 전체 조회")
    void findAll_shouldReturnAllCategories() {
        List<Category> mockList = List.of(new Category("1", "Electronics"), new Category("2", "Books"));
        when(categoryRepo.findAll()).thenReturn(mockList);

        List<Category> result = categoryService.findAll();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getCategoryName()).isEqualTo("Electronics");
        assertThat(result.get(1).getCategoryName()).isEqualTo("Books");
    }

    @Test
    @DisplayName("category ID 조회")
    void getCategory_whenExists_shouldReturnCategory() {
        Category category = new Category("1", "Toys");
        when(categoryRepo.findById("1")).thenReturn(Optional.of(category));

        Category result = categoryService.getCategory("1");

        assertThat(result).isNotNull();
        assertThat(result.getCategoryName()).isEqualTo("Toys");
    }

    @Test
    @DisplayName("category null 조회")
    void getCategory_whenNotExists_shouldReturnNull() {
        when(categoryRepo.findById("1")).thenReturn(Optional.empty());

        Category result = categoryService.getCategory("1");

        assertThat(result).isNull();
    }

    @Test
    @DisplayName("category null 조회")
    void categoryInit_shouldReturnCategoryDtoList() throws Exception {
        // given
        String json = "[{\"id\":\"1\", \"categoryName\":\"Food\"}, {\"id\":\"2\", \"categoryName\":\"Clothes\"}]";
        try (MockedStatic<InitService> mock = Mockito.mockStatic(InitService.class)) {
            mock.when(() -> InitService.resourceJsonToString("category.json")).thenReturn(json);

            // when
            ArrayList<CategoryDto> result = categoryService.categoryInit();

            // then
            assertThat(result).hasSize(2);
            assertThat(result.get(0).getCategoryName()).isEqualTo("Food");
        }
    }
}