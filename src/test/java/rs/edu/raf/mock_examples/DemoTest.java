package rs.edu.raf.mock_examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DemoTest {

    @Test
    public void demoTest(){

        List<Integer> lol = Arrays.asList(1,2,3);

        List<Integer> result = lol.stream().map(x -> x + 10).collect(Collectors.toList());
        System.out.println(String.valueOf(result));

        Optional<Integer> a = Optional.ofNullable(null);

        a.map(x -> x+10).orElseThrow(IndexOutOfBoundsException::new);

    }
}
