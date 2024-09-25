package application.controller;

import application.bean.TrailResponseWS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration")
@EnableConfigurationProperties
public class TrailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void test_getTrails_success() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/trails")
                .queryParam("hasFee", "Yes"))
                .andExpect(status().isOk());

        TrailResponseWS trailResponseWS = getResponse(resultActions);
        assertThat(trailResponseWS.getCount()).isEqualTo(2);
    }

    @Test
    public void test_getTrails_emptyRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/trails"))
                .andExpect(status().isBadRequest());
    }

    protected TrailResponseWS getResponse(ResultActions resultActions) throws UnsupportedEncodingException, JsonProcessingException {
        String result = resultActions.andReturn().getResponse().getContentAsString();
        return objectMapper.readValue(result, new TypeReference<>() {
        });
    }
}
