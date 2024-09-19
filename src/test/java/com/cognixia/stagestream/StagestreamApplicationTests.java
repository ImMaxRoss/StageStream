package com.cognixia.stagestream;

import com.cognixia.stagestream.models.Address;
import com.cognixia.stagestream.repositories.AddressRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class StagestreamApplicationTests {

    @Autowired
    private AddressRepo addressRepo;

    @BeforeEach
    public void setup() {
        // Ensure the test data is in place
        Address address = new Address("IL", "Springfield", "62704", "123 Main St");
        addressRepo.save(address);
    }

    @Test
    public void contextLoads() {
        Address address = addressRepo.findByStateAndCityAndZipcodeAndStreet("IL", "Springfield", "62704", "123 Main St");
        assertThat(address).isNotNull();
    }
}