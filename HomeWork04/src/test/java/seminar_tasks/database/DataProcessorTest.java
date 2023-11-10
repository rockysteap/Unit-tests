package seminar_tasks.database;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.shortThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {


    @Test
    void testDataProcessorProcessData() {
        Database db = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(db);

        when(dataProcessor.processData("data")).thenReturn(List.of(new String[]{"Data1", "Data2", "Data3"}));

        assertEquals(List.of(new String[]{"Data1", "Data2", "Data3"}), dataProcessor.processData("data"));

    }

}