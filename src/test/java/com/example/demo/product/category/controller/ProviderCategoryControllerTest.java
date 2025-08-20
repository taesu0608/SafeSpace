package com.example.demo.product.category.controller;

import com.example.demo.product.category.entity.Category;
import com.example.demo.provider.entity.Provider;
import com.example.demo.product.category.entity.ProviderCategory;
import com.example.demo.product.category.service.ProviderCategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProviderCategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
class ProviderCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProviderCategoryService providerCategoryService;

    @Test
    @DisplayName("ProviderCategory 전체 조회 성공")
    void findAll_shouldReturnListOfProviderCategoryDto() throws Exception {
        Provider p1 = Provider.builder().providerId("1").name("홍길동").imgPath("fakeImage").build();
        Category c1 = Category.builder().categoryName("식품").build();

        Provider p2 = Provider.builder().providerId("2").name("견훤").imgPath("fakeImage").build();
        Category c2 = Category.builder().categoryName("마케팅").build();
        // given
        ProviderCategory pc1 = ProviderCategory.builder().provider(p1).category(c1).build();
        ProviderCategory pc2 = ProviderCategory.builder().provider(p2).category(c2).build();
        List<ProviderCategory> mockList = List.of(pc1, pc2);
        when(providerCategoryService.getAllProviderCategory()).thenReturn(mockList);

        // when & then
        mockMvc.perform(get("/provider_category/findAll/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].provider.providerId").value(1))
                .andExpect(jsonPath("$[0].category.categoryName").value("식품"))
                .andExpect(jsonPath("$[1].provider.providerId").value(2))
                .andExpect(jsonPath("$[1].category.categoryName").value("마케팅"));

        verify(providerCategoryService).getAllProviderCategory();
    }
}