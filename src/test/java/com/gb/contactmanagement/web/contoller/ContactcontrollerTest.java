package com.gb.contactmanagement.web.contoller;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.model.Gender;
import com.gb.contactmanagement.model.Salutation;
import com.gb.contactmanagement.service.ContactServiceImpl;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactcontrollerTest {
    @LocalServerPort
    int randomServerPort;

    ContactDto contactDto;
    Contact contact;

    @MockBean
    ContactServiceImpl contactService;

    @BeforeEach
    public void setUp() {
        contactDto = ContactDto.builder()
                .emailId("sample@domain.com")
                .firstName("firstName")
                .lastName("lastName")
                .gender(Gender.FEMALE)
                .age((short) 35)
                .salutation(Salutation.MRS).build();

        contact = new Contact(contactDto);
    }

    @Test
    public void addContactTest() throws URISyntaxException {
        given(contactService.save(any())).willReturn(contactDto);
        final String baseUrl = "http://localhost:"+randomServerPort+"/contactservice/v1/contacts";
        URI uri = new URI(baseUrl);
        HttpEntity<ContactDto> request = new HttpEntity<>(contactDto);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ContactDto> contactResponseEntity = restTemplate.postForEntity(uri,request, ContactDto.class);
        Assertions.assertEquals(200, contactResponseEntity.getStatusCode().value());
        Assertions.assertNotNull(contactResponseEntity.getBody().getFirstName());
    }

    @Test
    public void getContactTest() throws URISyntaxException {
        given(contactService.findById("sample@domain.com")).willReturn(contactDto);
        final String baseUrl = "http://localhost:"+randomServerPort+"/contactservice/v1/contacts/sample@domain.com";
        URI uri = new URI(baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ContactDto> contactResponseEntity = restTemplate.getForEntity(uri,ContactDto.class);
        Assertions.assertEquals(200, contactResponseEntity.getStatusCode().value());
        Assertions.assertNotNull(contactResponseEntity.getBody().getEmailId());
    }
}
