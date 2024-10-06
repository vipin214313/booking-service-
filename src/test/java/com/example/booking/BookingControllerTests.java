package com.example.booking;

import com.example.booking.controller.BookingController;
import com.example.booking.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookingController.class)
public class BookingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // You can add any additional setup here if needed
    }

    @Test
    public void testCreateBooking() throws Exception {
        Booking booking = new Booking("1", "123", "Location A", "Location B");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/booking/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(booking)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    public void testGetBooking() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/booking/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    public void testUpdateBooking() throws Exception {
        Booking booking = new Booking("1", "123", "Location A", "Location C");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/booking/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(booking)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.dropoffLocation").value("Location C"));
    }

    @Test
    public void testDeleteBooking() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/booking/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
