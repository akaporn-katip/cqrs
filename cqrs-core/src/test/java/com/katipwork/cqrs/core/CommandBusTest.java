package com.katipwork.cqrs.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;

public class CommandBusTest {
    private CommandBus commandBus;

    @BeforeEach
    void setUp() {
        System.out.println("abcde");
        this.commandBus = new CommandBus();
    }

    @Test
    public void testRegisterCommand() {
        ICommandHandler commandHandler = mock(ICommandHandler.class);
        ICommand command = mock(ICommand.class);
        this.commandBus.register(command.getClass(), commandHandler);
        Assertions.assertEquals(1, commandBus.size());
    }

    @Test
    public void testDispatch() {
        ICommandHandler commandHandler = mock(ICommandHandler.class);
        ICommand command = mock(ICommand.class);
        this.commandBus.register(command.getClass(), commandHandler);
        this.commandBus.dispatch(command);
        verify(commandHandler).handle(command);
    }

    @Test
    public void testThrowWhenDispatchUnRegisteredCommand() {
        ICommand command = mock(ICommand.class);
        IllegalArgumentException exception  = Assertions.assertThrows(IllegalArgumentException.class, () -> this.commandBus.dispatch(command));
        Assertions.assertEquals("No handler registered for command type: " + command.getClass(), exception.getMessage());
    }
}
