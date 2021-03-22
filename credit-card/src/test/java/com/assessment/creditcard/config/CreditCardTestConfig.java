package com.assessment.creditcard.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.assessment.creditcard.CreditCardApplication;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CreditCardApplication.class)
public class CreditCardTestConfig {

}
