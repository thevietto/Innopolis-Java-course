import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MockitoTest {

    @Test
    public void test() {
        ArrayList mock = mock(ArrayList.class);
        when(mock.get(1)).thenReturn("1");
        when(mock.get(1)).thenReturn("2");
        when(mock.get(1)).thenReturn("3");
        when(mock.get(2)).then(RETURNS_SMART_NULLS);

        System.out.println(mock.get(1));
        System.out.println(mock.get(2));
        System.out.println(mock.get(1));
        System.out.println(mock.get(1));

        verify(mock, atLeast(2)).get(1);
        verify(mock, times(1)).get(2);



    }

}
