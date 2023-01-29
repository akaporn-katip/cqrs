package com.katipwork.cqrs.spring;
import com.katipwork.cqrs.core.CommandBus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration( classes =  {CqrsConfiguration.class})
public class CqrsConfigurationTests {

    @Mock ApplicationContext applicationContext;

    @InjectMocks
    private CqrsConfiguration cqrsConfiguration;

    @Test
    @Description("given applicationContext has HandleClass with annotation CommandHandler")
    public void testCommandBusRegistration() {
        Map<String, Object> handlers = new HashMap<>();
        ExampleCommandHandler exampleCommandHandler = new ExampleCommandHandler();
        handlers.put("exampleCommandHandler", exampleCommandHandler);
        when(applicationContext.getBeansWithAnnotation(CommandHandler.class)).thenReturn(handlers);
        CommandBus commandBus = cqrsConfiguration.commandBusRegistration();
        assertNotNull(commandBus);
        assertEquals(commandBus.dispatch(new ExampleCommand()), "Hello Command Handler");
    }
}
