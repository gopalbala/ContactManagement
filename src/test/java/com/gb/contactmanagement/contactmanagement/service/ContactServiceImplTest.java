package com.gb.contactmanagement.contactmanagement.service;

import com.gb.contactmanagement.contactmanagement.model.Contact;
import com.gb.contactmanagement.contactmanagement.model.Gender;
import com.gb.contactmanagement.contactmanagement.model.Salutation;
import com.gb.contactmanagement.contactmanagement.repository.ContactRepository;
import com.gb.contactmanagement.contactmanagement.web.dto.ContactDto;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        Contact result = contactService.save(contactDto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("sample@domain.com",result.getEmailId());
    }
}
