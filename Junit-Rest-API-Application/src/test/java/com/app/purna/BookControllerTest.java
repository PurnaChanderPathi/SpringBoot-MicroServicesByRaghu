package com.app.purna;

import com.app.purna.controller.BookController;
import com.app.purna.entity.Book;
import com.app.purna.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    Book book_1 = new Book(1L, "Java","Backend",5);
    Book book_2 = new Book(2L, "React","FrontEnd",4);
    Book book_3 = new Book(3L, "MySql","Database",4);

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getAllRecords_Success() throws Exception
    {
        List<Book> records = new ArrayList<>(Arrays.asList(book_1,book_2,book_3));

        Mockito.when(bookRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Java"));

    }

    @Test
    public void getBookById_success() throws Exception
    {
        Mockito.when(bookRepository.findById(book_1.getBookId())).thenReturn(Optional.of(book_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/book/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Java"));

    }

    @Test
    public void createRecord_success() throws Exception
    {
        Book record = Book.builder()
                .bookId(4L)
                .name("Introduction to C")
                .summary("the name bit Longer")
                .rating(5)
                .build();

        Mockito.when(bookRepository.save(record)).thenReturn(record);

        String content = null;
        try {
            content = objectWriter.writeValueAsString(record);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        try {
            mockMvc.perform(mockRequest)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Introduction to C"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void updateBookRecord_success() throws Exception
    {
        Book updateRecord = Book.builder()
                .bookId(1L)
                .name("Java")
                .summary("Backend")
                .rating(5)
                .build();

        Mockito.when(bookRepository.findById(book_1.getBookId())).thenReturn(Optional.ofNullable(book_1));
        Mockito.when(bookRepository.save(updateRecord)).thenReturn(updateRecord);

        String updatedContent = objectWriter.writeValueAsString(updateRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockRequest)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Java"));
    }

    @Test
    public void deleteBookById_success() throws Exception
    {
        Mockito.when(bookRepository.findById(book_2.getBookId())).thenReturn(Optional.ofNullable(book_2));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/book/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }



}
