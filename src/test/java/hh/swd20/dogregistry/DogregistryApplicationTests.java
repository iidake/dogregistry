package hh.swd20.dogregistry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.dogregistry.webcontrol.DogController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DogregistryApplicationTests {

    @Autowired
    private DogController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}

