package fr.romaingervais.imt.demospringboot.account;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Transactional
class BankControllerTest {

    static final String SERVER_URL = "http://localhost:8181";
    static final String CONTROLLER_BASE_URL = SERVER_URL + "/api/banks";

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    void test_transfertMoney_with_existing_account_should_return_OK() {
        // ARRANGE
        RequestEntity<?> request = post(CONTROLLER_BASE_URL + "/transfert-money")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"accountIdFrom\":\"imt-nantes\", \"accountIdTo\":\"rgervais\", \"amount\": 100000.0}");

        // ACT
        ResponseEntity<TransfertMoneyResponse> response = testRestTemplate.exchange(request, TransfertMoneyResponse.class);

        // ASSERT
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(response.getBody().getResult()).isEqualTo("OK");
    }

    @Test
    void test_transfertMoney_with_no_request_body_should_return_error() {
        // ARRANGE
        RequestEntity<?> request = post(CONTROLLER_BASE_URL + "/transfert-money")
                .contentType(MediaType.APPLICATION_JSON)
                .body(null);

        // ACT
        ResponseEntity<Map<String, Object>> response = testRestTemplate.exchange(request, new ParameterizedTypeReference<>() {});

        // ASSERT
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(response.getBody())
                .containsEntry("status", 400)
                .containsEntry("error", "Bad Request")
                .containsEntry("path", "/api/banks/transfert-money")
                .containsKey("timestamp"); // le timestamp change à chaque fois on ne peut pas faire un assert equals dessus
    }
}