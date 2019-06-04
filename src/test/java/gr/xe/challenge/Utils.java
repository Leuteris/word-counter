package gr.xe.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;

class Utils {

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
