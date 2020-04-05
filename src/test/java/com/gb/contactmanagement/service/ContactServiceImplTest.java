package com.gb.contactmanagement.service;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.model.Gender;
import com.gb.contactmanagement.model.Salutation;
import com.gb.contactmanagement.repository.ContactRepository;
import com.gb.contactmanagement.web.dto.ContactDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class ContactServiceImplTest {
    ContactDto contactDto;
    Contact contact;

    @Mock
    ContactRepository contactRepository;

    @InjectMocks
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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveTest() {
        given(contactRepository.save(any())).willReturn(contact);
        ContactDto result = contactService.save(contactDto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("sample@domain.com",result.getEmailId());
    }

    @Test
    public void findByIdTest() {
        given(contactRepository.findById(any())).willReturn(java.util.Optional.ofNullable(contact));
        ContactDto dto = contactDto = contactService.findById("sample@domain.com");
        Assertions.assertNotNull(dto);
        Assertions.assertEquals("sample@domain.com", dto.getEmailId());

    }
}
